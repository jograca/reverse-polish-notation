package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.CalculateOne;
import com.lmig.gfc.rpn.models.CalculateTwo;
import com.lmig.gfc.rpn.models.OneArgumentUndoer;
import com.lmig.gfc.rpn.models.TwoArgumentUndoer;

@Controller
public class RPNController {

	private double firstNumber;
	private double secondNumber;
	
	private Stack<Double> stack;
	private OneArgumentUndoer undoer;
	private CalculateOne calcOne = new CalculateOne(firstNumber);
	private CalculateTwo calcTwo = new CalculateTwo(firstNumber, secondNumber);
		
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
		
		calcTwo.addNumbersOnStack(stack);
	
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/subtract")
	public ModelAndView subtractNumbersOnStack() {

		calcTwo.subtractNumbersOnStack(stack);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/multiply")
	public ModelAndView multiplyNumbersOnStack() {

		calcTwo.multiplyNumbersOnStack(stack);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/divide")
	public ModelAndView divideNumbersOnStack() {

		calcTwo.divideNumbersOnStack(stack);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/abs")
	public ModelAndView absoluteValue() {

		calcOne.absoluteNumbersOnStack(stack);
		//undoer = new OneArgumentUndoer(number);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	
	@PostMapping("/sin")
	public ModelAndView sinValue() {

		calcOne.sinNumberOnStack(stack);
		//undoer = new OneArgumentUndoer(number);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/cos")
	public ModelAndView cosValue() {

		calcOne.cosNumberOnStack(stack);
		//undoer = new OneArgumentUndoer(number);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/undo")
	public ModelAndView undoNumbersOnStack() {
		
		undoer.undo(stack);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/redo")
	public ModelAndView redoNumbersOnStack() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

}
