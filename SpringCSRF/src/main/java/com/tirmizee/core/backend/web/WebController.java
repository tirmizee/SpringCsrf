package com.tirmizee.core.backend.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@GetMapping(path = "/Welcome")
	public ModelAndView Welcom(ModelAndView modelAndView){
		modelAndView.setViewName("pages/welcome");
		return modelAndView;
	}
}
