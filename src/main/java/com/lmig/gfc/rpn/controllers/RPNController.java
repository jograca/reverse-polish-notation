package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

@Controller
public class RPNController {

	private Stack<Double> stack;
	
	// Constructor
	public RPNController () {
		this.stack = new Stack<Double>(); 
	}

	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", stack);

		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		stack.push(value);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/pop")
	public ModelAndView resetStack() {

		stack.pop();
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
}
