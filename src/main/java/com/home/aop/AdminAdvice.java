package com.home.aop;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.home.service.AdminService;
import com.home.service.BoardTypeService;

@Component
@Aspect
public class AdminAdvice {
	Logger logger = LoggerFactory.getLogger(AdminAdvice.class);
	
	@Inject
	private AdminService adminService;
	@Inject
	private BoardTypeService boardTypeService;
	
	@Around("execution(* com.home.controller.Admin*.*(..))")
	public Object leftMenu(ProceedingJoinPoint pjp) throws Throwable{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		request.setAttribute("leftMenuList", boardTypeService.selectBoardType());	//left에 전달하는 메뉴목록.
		return pjp.proceed();
	}
	
	@Around("execution(* com.home.controller.Admin*.*(..))")
	public Object adminMenu(ProceedingJoinPoint pjp) throws Throwable{
		logger.info("어드민 어드바이스 호출");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		request.setAttribute("adminMenuList", adminService.selectMenu(null));
		
		return pjp.proceed();
	}

}
