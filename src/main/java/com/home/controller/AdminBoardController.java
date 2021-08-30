package com.home.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

//import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.message.ResponseMessage;
import com.home.service.BoardService;
import com.home.vo.BoardVO;
import com.home.vo.PageVO;
import com.home.vo.SearchVO;

/**
 * 관리자페이지의 게시판관리 부분 REST API방식
 * @author 김영제
 *
 */
@Controller
public class AdminBoardController {
	@Inject
	private BoardService boardService;

	@RequestMapping(value = "/admin/boards", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<ResponseMessage<Map<String,List<BoardVO>>>> searchBoardList(@RequestParam("type") String type, @RequestParam("page") Integer page, @RequestParam("searchKeyword") String searchKeyword, @RequestParam("searchType") String searchType, Model model) throws Exception{
		SearchVO searchVO = new SearchVO(type);
		Map<String, List<BoardVO>> map = new HashMap<String, List<BoardVO>>();
		
		if(searchKeyword!=null)
			searchVO.setSearch_keyword(searchKeyword);
		if(searchType!=null)
			searchVO.setSearch_type(searchType);
		
		searchVO.setPageVO(new PageVO());
		if(page!=null)
			searchVO.getPageVO().setPage(page);
		
		map.put("boardList",boardService.searchBoard(searchVO));
//		HttpHeaders responseHeader = new HttpHeaders();
//		responseHeader.add("LINKS", "header setting check");
		ResponseMessage<Map<String,List<BoardVO>>> responseMessage = new ResponseMessage<Map<String,List<BoardVO>>>(map);
		responseMessage.addLinks("next", "http://localhost:8080/admin/boards/40");
		ResponseEntity<ResponseMessage<Map<String,List<BoardVO>>>> result = new ResponseEntity<ResponseMessage<Map<String,List<BoardVO>>>>(responseMessage,HttpStatus.OK);
		

		return result;
		
	}
	
	//게시물 뷰
	@RequestMapping(value = "/admin/boards/{idx}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Map<String, BoardVO>> viewBoardForm(@PathVariable Integer idx, Model model)throws Exception{
		Map<String, BoardVO> map = new HashMap<String, BoardVO>();
		map.put("boardVO", boardService.selectBoard(idx));
		
		ResponseEntity<Map<String,BoardVO>> result = new ResponseEntity<Map<String,BoardVO>>(map, HttpStatus.OK);
		
		return result;
	}
	
	//게시물 삭제
	@ResponseBody
	@RequestMapping(value = "/admin/boards/{idx}", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteBoard(@PathVariable Integer idx) throws Exception{
		boardService.deleteBoard(idx);
		
		ResponseEntity<String> result= new ResponseEntity<String>("success",HttpStatus.OK);
		
		return result;
	}
	
	//게시물 추가 폼
	@RequestMapping(value="/admin/boards/new", method = RequestMethod.GET)
	public String newBoardForm() {
		//보드타입 목록과 현재 게시판 타입이 필요.
		return "/admin/board/boardWrite";
	}
	
	//게시물 추가
	@RequestMapping(value = "/admin/boards", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Map<String,BoardVO>> insertBoard(BoardVO boardVO, Model model) throws Exception{
		Map<String, BoardVO> map = new HashMap<String, BoardVO>();
		int boardIdx = boardService.insertBoard(boardVO);
		
		map.put("boardVO", boardService.selectBoard(boardIdx));
		
		ResponseEntity<Map<String,BoardVO>> result = new ResponseEntity<Map<String,BoardVO>> (map,HttpStatus.OK);
		
		return result;
	}
	
	/**
	 * 
	 * @param model
	 * @return Tiles
	 * @throws Exception
	 */
	@RequestMapping(value = "/admin/board", method = RequestMethod.GET)
	public String adminBoardList(Model model) throws Exception{
		SearchVO searchVO = new SearchVO("notice");
		searchVO.setPageVO(new PageVO());
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));
		model.addAttribute("searchVO",searchVO);
		return "on.admin.board.boardList";
	}
}
