package com.elektrobit.netservice.view;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class WeekInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {

		Calendar c = Calendar.getInstance();
		int dayOfWeek = c.get(c.DAY_OF_WEEK);

		if (dayOfWeek == 2) {
			response.getWriter().write("The website is closed please try on another day ");
			
			return false;
		}

		return true;
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		System.out.println("HandlerInterceptorAdapter: Spring MVC Called aftercompletion for" + request.getRequestURI().toString());
		
		
		
		
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		
		System.out.println("HandlerInterceptorAdapter: Spring MVC Called postHandle for" + request.getRequestURI().toString());
		
	}

}
