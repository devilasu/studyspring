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

@Component
@Aspect
public class AdminAdvice {
	Logger logger = LoggerFactory.getLogger(AdminAdvice.class);
	
	@Inject
	private AdminService adminService;
	
	@Around("execution(* com.home.controller.AdminController.*(..))")
	public Object AdminMenu(ProceedingJoinPoint pjp) throws Throwable{
		logger.info("어드민 어드바이스 호출");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		request.setAttribute("adminMenuList", adminService.selectAdminMenu(null));
		
		return pjp.proceed();
	}

}
