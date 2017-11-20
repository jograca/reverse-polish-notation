package com.lmig.gfc.rpn.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class RPNController {
	
	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/calculate")
	public ModelAndView calculateResult() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
	
	@PostMapping("/reset")
	public ModelAndView resetCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		
		return mv;
	}
}
