package com.home.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.service.BoardService;
import com.home.service.BoardTypeService;
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
	 * 게시판 선택시 게시물 목록을 보내주는 부분.
	 */
	//게시판관리의 CRUD
	@RequestMapping(value = "/admin/boards/list/{type}/{page}/{searchKeyword}/{searchType}")
	public String searchBoardList(@PathVariable String type, @PathVariable int page, @PathVariable String searchKeyword, @PathVariable String searchType, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setSearch_keyword(searchKeyword);
		searchVO.setSearch_type(searchType);
		searchVO.setType(type);
		searchVO.getPageVO().setPage(page);
		model.addAttribute("boardList", boardService.searchBoard(searchVO));
		return "admin/boardList";
	}
	
	//left에서 게시판타입선택시 관련 게시물만 출력.
	@RequestMapping(value = "/admin/boards/list/{type}", method = RequestMethod.GET)
	public String selectedBoardList(@PathVariable String type, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setType(type);
		model.addAttribute("boardList",boardService.searchBoard(searchVO));
		return "admin/boardList";
	}
	
	//게시판관리 요청시 호출.
	@RequestMapping(value = "/admin/boards/list", method = RequestMethod.GET)
	public String adminBoardList(Model model) throws Exception{
		model.addAttribute("boardList", boardService.selectBoard());
		model.addAttribute("leftMenuList", boardTypeService.selectBoardType());	//left에 전달하는 메뉴목록.
		return "on.admin.boardList";
	}

}
