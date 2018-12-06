package com.interceptors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author:DanLongChen
 * @versioin:2018年11月20日下午9:43:13
 **/
@Component
public class SessionHandlerInterceptor implements HandlerInterceptor {
	// 调用Controller方法前会调用这个方法
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("preHandler");
		// User user = (User) request.getSession().getAttribute("user");
		// if (user == null) {
		// // response.sendRedirect("/login.html");
		// return true;
		// }
		return true;

	}

	// Controller方法结束，页面渲染之前调用这个方法（可以用此将渲染的视图名称更改为其他视图名称）
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
						   ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		// response.sendRedirect("/View/time");
		System.out.println("redirect to @@@");
	}

	// 页面渲染完毕之后调用该方法（用于清除资源等，相当于finally）
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		System.out.println("执行完毕");
	}
}
