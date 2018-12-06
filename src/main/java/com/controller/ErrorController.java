// package com.sample.controller;
//
// import java.util.Collections;
// import java.util.HashMap;
// import java.util.Map;
//
// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpServletResponse;
//
// import org.apache.commons.logging.Log;
// import org.apache.commons.logging.LogFactory;
// import org.springframework.beans.factory.annotation.Autowired;
// import
// org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
// import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.servlet.ModelAndView;
//
// import com.fasterxml.jackson.databind.ObjectMapper;
//
/// **
// * @author:DanLongChen
// * @versioin:2018年11月21日下午2:18:00
// **/
// @Controller
// public class ErrorController extends AbstractErrorController {
// Log log = LogFactory.getLog(ErrorController.class);
// @Autowired
// ObjectMapper objectMapper;
//
// public ErrorController() {
// // TODO Auto-generated constructor stub
// super(new DefaultErrorAttributes());
// }
//
// @RequestMapping("/error")
// public ModelAndView getErrorPath(HttpServletRequest request,
// HttpServletResponse response) {
// // TODO Auto-generated method stub
//
// Map<String, Object> map =
// Collections.unmodifiableMap(getErrorAttributes(request, false));
// Throwable cause = getCause(request);
// int status = (Integer) map.get("status");
// String message = (String) map.get("message");
// String errorMessage = getErrorMessage(cause);
// log.info(status + "," + message + "," + cause);
// response.setStatus(status);
// if (!isJsonRequest(request)) {
// ModelAndView view = new ModelAndView("/err.btl");
// view.addAllObjects(map);
// view.addObject("status", status);
// view.addObject("message", message);
// view.addObject("errorMessage", errorMessage);
// return view;
// } else {
// Map error = new HashMap();
// error.put("success", false);
// writeJson(response, error);
// return null;
// }
// }
//
// }
