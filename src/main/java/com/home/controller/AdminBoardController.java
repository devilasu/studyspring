package com.home.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.service.BoardService;
import com.home.service.BoardTypeService;
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
	@Inject
	private BoardTypeService boardTypeService;
	
	/**
	 * Ajax 호출이 존재하는 함수.
	 */
	@RequestMapping(value = "/admin/boards", method = RequestMethod.GET)
	@ResponseBody
	public String searchBoardList(@RequestParam("type") String type, @RequestParam("page") Integer page, @RequestParam("searchKeyword") String searchKeyword, @RequestParam("searchType") String searchType, Model model) throws Exception{
		SearchVO searchVO = new SearchVO(type);
		if(searchKeyword!=null)
			searchVO.setSearch_keyword(searchKeyword);
		if(searchType!=null)
			searchVO.setSearch_type(searchType);
		
		searchVO.setPageVO(new PageVO());
		if(page!=null)
			searchVO.getPageVO().setPage(page);
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));		//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		
		return "admin/board/boardList";
		
	}
	
	//게시물 뷰
	@RequestMapping(value = "/admin/boards/{type}/{idx}", method = RequestMethod.GET)
	@ResponseBody
	public String viewBoardForm(@PathVariable String type, @PathVariable Integer idx, Model model)throws Exception{
		model.addAttribute("boardVO", boardService.selectBoard(idx));
		return "on.admin.board.boardView";
	}
	//게시물 추가 폼
	@RequestMapping(value = "/admin/boards/{type}/write", method = RequestMethod.GET)
	public String insertBoardForm(@PathVariable String type, Model model) throws Exception{
		model.addAttribute("boardType",boardTypeService.selectBoardType());
		model.addAttribute("type",type);
		return "on.admin.board.boardWrite";
	}
	
	//게시물 삭제
	@ResponseBody
	@RequestMapping(value = "/admin/boards/{type}/{idx}", method = RequestMethod.DELETE)
	public String deleteBoard(@PathVariable String type, @PathVariable Integer idx) throws Exception{
		boardService.deleteBoard(idx);
		
		return "redirect:/admin/boards";
		//+type+"?page=1&searchType=&searchKeyword=&ajax="+false
	}
	
	//게시물 추가
	@RequestMapping(value = "/admin/boards/{type}/write", method = RequestMethod.POST)
	@ResponseBody
	public String insertBoard(@PathVariable String type, BoardVO boardVO, Model model) throws Exception{
		SearchVO searchVO = new SearchVO(type);
		searchVO.setPageVO(new PageVO());

		int boardIdx = boardService.insertBoard(boardVO);
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));			//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		
		return "redirect:/admin/boards/"+type+"/"+boardIdx;
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
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));			//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		return "on.admin.board.boardList";
	}
	
}
