package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.CalculateOne;
import com.lmig.gfc.rpn.models.OneArgumentUndoer;
import com.lmig.gfc.rpn.models.PushUndoer;
import com.lmig.gfc.rpn.models.TwoArgumentUndoer;
import com.lmig.gfc.rpn.models.Undoer;

@Controller
public class RPNController {

	private double firstNumber;
	private double secondNumber;
	
	private Stack<Double> stack;
	private Stack<Undoer> undoers;
		
	private CalculateOne calcOne = new CalculateOne(firstNumber);
		
	// Constructor
	public RPNController() {
		this.stack = new Stack<Double>();
		this.undoers = new Stack<Undoer>();
	}

	public boolean hasTwoOrMoreNumbers() {
		return (stack.size() >= 2);
	}
	
	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", stack);
		mv.addObject("hasUndoer", !undoers.isEmpty());
		mv.addObject("hasTwoOrMoreNumbers", hasTwoOrMoreNumbers());

		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		stack.push(value);
		undoers.push(new PushUndoer());

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/add")
	public ModelAndView addNumbersOnStack() {
				
		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber + firstNumber);
		stack.push(result);
		
		undoers.push(new TwoArgumentUndoer(firstNumber, secondNumber));
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/subtract")
	public ModelAndView subtractNumbersOnStack() {
		
		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber - firstNumber);
		stack.push(result);
		
		undoers.push(new TwoArgumentUndoer(firstNumber, secondNumber));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/multiply")
	public ModelAndView multiplyNumbersOnStack() {
		
		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber * firstNumber);
		stack.push(result);
		
		undoers.push(new TwoArgumentUndoer(firstNumber, secondNumber));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/divide")
	public ModelAndView divideNumbersOnStack() {
		
		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber / firstNumber);
		stack.push(result);
		
		undoers.push(new TwoArgumentUndoer(firstNumber, secondNumber));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/abs")
	public ModelAndView absoluteValue() {

		calcOne.absoluteNumbersOnStack(stack);
		undoers.push(new OneArgumentUndoer(firstNumber));
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	
	@PostMapping("/sin")
	public ModelAndView sinValue() {

		calcOne.sinNumberOnStack(stack);
		undoers.push(new OneArgumentUndoer(firstNumber));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/cos")
	public ModelAndView cosValue() {

		calcOne.cosNumberOnStack(stack);
		undoers.push(new OneArgumentUndoer(firstNumber));

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/undo")
	public ModelAndView undoNumbersOnStack() {
		
		Undoer undoer = undoers.pop();
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
