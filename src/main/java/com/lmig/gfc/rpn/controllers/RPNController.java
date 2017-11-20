package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.Undoer;

@Controller
public class RPNController {

	private Stack<Double> stack;
	private Undoer undoer;
	
	// Constructor
	public RPNController() {
		this.stack = new Stack<Double>();
	}

	public boolean hasTwoOrMoreNumbers() {
		return (stack.size() >= 2);
	}
	
	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", stack);
		mv.addObject("hasUndoer", undoer != null);
		mv.addObject("hasTwoOrMoreNumbers", hasTwoOrMoreNumbers());
		

		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		stack.push(value);
		undoer = null; 

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

	@PostMapping("/add")
	public ModelAndView addNumbersOnStack() {

		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (firstNumber + secondNumber);
		stack.push(result);
		undoer = new Undoer(firstNumber, secondNumber);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/subtract")
	public ModelAndView subtractNumbersOnStack() {

		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (secondNumber - firstNumber);
		stack.push(result);
		undoer = new Undoer(firstNumber, secondNumber);


		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/multiply")
	public ModelAndView multiplyNumbersOnStack() {

		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (secondNumber * firstNumber);
		stack.push(result);
		undoer = new Undoer(firstNumber, secondNumber);


		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/divide")
	public ModelAndView divideNumbersOnStack() {

		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (firstNumber / secondNumber);
		stack.push(result);
		undoer = new Undoer(firstNumber, secondNumber);


		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/undo")
	public ModelAndView undoNumbersOnStack() {
		
		undoer.undo(stack);
		undoer = null;
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

}
