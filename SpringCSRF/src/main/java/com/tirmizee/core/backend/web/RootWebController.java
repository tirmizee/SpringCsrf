package com.tirmizee.core.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RootWebController {

	@GetMapping(path = "/")
	public ModelAndView index(ModelAndView modelAndView){
		modelAndView.setViewName("index");
		return modelAndView;
	}
	
	@GetMapping(value = "/login")
	public ModelAndView login(ModelAndView modelAndView, @RequestParam(required = false) String error) {
		modelAndView.setViewName("index");
		if (error != null) {
			modelAndView.addObject("error", "");
		}
		return modelAndView;
	}
	
}
