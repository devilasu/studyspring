package com.home.controller;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.service.BoardService;
import com.home.vo.SearchVO;

/**
 * 관리자단의 게시판관리의 부분업데이트 처리.
 * @author 김영제
 *
 */
@Controller
public class AdminBoardController {
	@Inject
	BoardService boardService;
	/**
	 * 게시판 선택시 게시물 목록을 보내주는 부분.
	 */
	@ResponseBody
	@RequestMapping(value = "/admin/boards/{type}", method = RequestMethod.GET)
	public ResponseEntity<Map<String,Object>> boardLists(@PathVariable String type) throws Throwable{
		Map<String,Object> result = new HashMap<String, Object>();
		SearchVO searchVO = new SearchVO();
		searchVO.setType(type);
		result.put("boardList",boardService.selectBoard(searchVO));
		return ResponseEntity.ok(result);
	}
}
