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

import com.home.service.HomeMenuService;

@Component
@Aspect
public class HomeAdvice {
	Logger logger = LoggerFactory.getLogger(HomeAdvice.class);
	@Inject
	HomeMenuService homeMenuservice;
	@Around("execution(* com.home.controller.HomeController.*(..))")
	public Object homeMenu(ProceedingJoinPoint pjp) throws Throwable{
		logger.info("홈 어드바이스 호출");
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		request.setAttribute("homeMenuList", homeMenuservice.selectMenu(null));
		
		return pjp.proceed();
	}
}
