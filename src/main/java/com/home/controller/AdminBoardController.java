package com.home.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.home.service.BoardService;
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
	/**
	 * 게시판 선택시 게시물 목록을 보내주는 부분.
	 */
	//게시판관리의 CRUD
	//검색과 페이지이동을 함께 처리하는 함수
	@RequestMapping(value = "/admin/boards/{type}")
	public String searchBoardList(@PathVariable String type, @RequestParam("page") Integer page, @RequestParam("searchKeyword") String searchKeyword, @RequestParam("searchType") String searchType, Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setSearch_keyword(searchKeyword);
		searchVO.setSearch_type(searchType);
		searchVO.setType(type);
		searchVO.setPageVO(new PageVO());
		searchVO.getPageVO().setPage(page);
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));		//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		return "admin/boardList";
	}
	
	//게시판관리 요청시 호출.
	@RequestMapping(value = "/admin/boards", method = RequestMethod.GET)
	public String adminBoardList(Model model) throws Exception{
		SearchVO searchVO = new SearchVO();
		searchVO.setPageVO(new PageVO());
		searchVO.setType("notice");	//기본값은 공지사항(안전을 위해서는 select로 첫번째 메뉴값을 가져오는 것도 좋다.)
		
		model.addAttribute("boardList", boardService.searchBoard(searchVO));			//여기서 calcPage가 일어난다.
		model.addAttribute("searchVO",searchVO);
		return "on.admin.boardList";
	}

}
