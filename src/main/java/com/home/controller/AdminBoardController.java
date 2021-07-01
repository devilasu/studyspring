package com.home.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 관리자단의 게시판관리의 부분업데이트 처리.
 * @author 김영제
 *
 */
@RestController
public class AdminBoardController {

	@RequestMapping(value = "/admin/boards/{type}", method = RequestMethod.GET)
	public Object boardLists(@PathVariable String type) throws Throwable{
		
		return null;
	}
}
