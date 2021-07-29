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
 * 관리자단의 게시판관리의 부분업데이트 처리.
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
	//검색과 페이지이동을 함께 처리하는 함수(ajax포함)
	@RequestMapping(value = "/admin/boards/{type}", method = RequestMethod.GET)
	public String searchBoardList(@PathVariable String type, @RequestParam("page") Integer page, @RequestParam("searchKeyword") String searchKeyword, @RequestParam("searchType") String searchType, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		if(searchKeyword!=null)
			searchVO.setSearch_keyword(searchKeyword);
		if(searchType!=null)
			searchVO.setSearch_type(searchType);
		searchVO.setType(type);
		searchVO.setPageVO(new PageVO());
		if(page!=null)
			searchVO.getPageVO().setPage(page);
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));		//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		
		return "admin/board/boardList";
		
	}
	
	//게시물 뷰
	@RequestMapping(value = "/admin/boards/{type}/{idx}", method = RequestMethod.GET)
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
		
		return "/admin/boards";
		//+type+"?page=1&searchType=&searchKeyword=&ajax="+false
	}
	
	//게시물 추가
	@RequestMapping(value = "/admin/boards/{type}/write", method = RequestMethod.POST)
	public String insertBoard(@PathVariable String type, BoardVO boardVO, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setPageVO(new PageVO());
		searchVO.setType(type);

		int boardIdx = boardService.insertBoard(boardVO);
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));			//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		
		return "redirect:/admin/boards/"+type+"/"+boardIdx;
	}
	
	//게시판관리 요청시 호출.
	@RequestMapping(value = "/admin/boards", method = RequestMethod.GET)
	public String adminBoardList(Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setPageVO(new PageVO());
		searchVO.setType("notice");	//기본값은 공지사항(안전을 위해서는 select로 첫번째 메뉴값을 가져오는 것도 좋다.)
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));			//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		return "on.admin.board.boardList";
	}
	
}
