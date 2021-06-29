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
	HomeMenuService homeMenuService;
	
	@Around("execution(* com.home.controller.HomeController.*(..))")
	public Object homeMenu(ProceedingJoinPoint pjp) throws Throwable{
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		request.setAttribute("homeMenuList", homeMenuService.selectHomeMenu(null));
		logger.info("홈 매니저 호출");
		return pjp.proceed();
	}
}
