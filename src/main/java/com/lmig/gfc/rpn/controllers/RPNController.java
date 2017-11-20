package com.lmig.gfc.rpn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RPNController {
	
	@RequestMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@RequestMapping("/calculate")
	public ModelAndView calculateResult() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculate");
		
		return mv;
	}
	
	@RequestMapping("/reset")
	public ModelAndView resetCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("reset");
		
		return mv;
	}
}
