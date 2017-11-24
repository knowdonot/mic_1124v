package com.duo.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class MyControllerAdvice {

	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		System.out.println("binder....................");
	}
	
	
	@ModelAttribute
	public void addAttributes(Model model){
		model.addAttribute("author", "duoduo");
	}

	@ResponseBody
	@ExceptionHandler(value=Exception.class)
	public Map errorHandler(Exception e){
		Map map = new HashMap();
		map.put("code", 100);
		map.put("msg",e.getMessage());
		return map;
	}
}
