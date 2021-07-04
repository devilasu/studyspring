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
	
	@RequestMapping(value = "/admin/boards/{type}", method = RequestMethod.GET)
	public String boardLists(@PathVariable String type, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setType(type);
		model.addAttribute("boardList",boardService.selectBoard(searchVO));
		return "admin/boardList";
	}
	
	//게시판관리 요청시 호출.
	@RequestMapping(value = "/admin/boards", method = RequestMethod.GET)
	public String adminBoardList(Model model) throws Exception{
		model.addAttribute("boardList", boardService.selectBoard());
		model.addAttribute("leftMenuList", boardTypeService.selectBoardType());	//left에 전달하는 메뉴목록.
		return "on.admin.boardList";
	}

}
