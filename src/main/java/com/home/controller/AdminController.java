package com.home.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.home.service.HomeMenuService;
/**
 * 관리자 페이지 관리 컨트롤러
 * @author 김영제
 *
 */
@Controller
public class AdminController {
	Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Inject
	private HomeMenuService homeMenuService;
	
	//임시 제작중 페이지.
	@RequestMapping(value="/noServer",method =RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> noCreate() {
		return new ResponseEntity<String>("게시판 제작중입니다.",HttpStatus.NO_CONTENT);
	}
	
	//메뉴관리 요청시 호출.
	@RequestMapping(value = "/admin/menu", method = RequestMethod.GET)
	public String homeMenuList(Model model) throws Exception{
		
		model.addAttribute("leftMenuList", homeMenuService.selectMenu(null));	//left에 전달하는 메뉴목록.
		return "on.admin.home.menuList";
	}
	//관리자 메인페이지 요청시 호출
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminMainPage() throws Exception{
		logger.info("어드민 컨트롤러 호출");
		return "no.admin.home.index";
	}
}
