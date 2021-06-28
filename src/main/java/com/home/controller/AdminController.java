package com.home.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.home.service.HomeMenuService;
/**
 * admin 페이지 관리 컨트롤러
 * @author 김영제
 *
 */
@Controller
public class AdminController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);
	@Inject
	private HomeMenuService homeMenuService;
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminMainPage() throws Exception{
		logger.info("어드민 컨트롤러 호출");
		return "admin.index.tiles";
	}
}
