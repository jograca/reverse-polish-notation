package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.Abs;
import com.lmig.gfc.rpn.models.Adder;
import com.lmig.gfc.rpn.models.Cos;
import com.lmig.gfc.rpn.models.Divider;
import com.lmig.gfc.rpn.models.Multiplier;
import com.lmig.gfc.rpn.models.PushUndoer;
import com.lmig.gfc.rpn.models.Sin;
import com.lmig.gfc.rpn.models.Subtractor;
import com.lmig.gfc.rpn.models.Undoer;

@Controller
public class RPNController {
	
	// What can I interface in this Controller? 
	// I can Interface with a Stack, or with an Undoer
	private Stack<Double> stack;
	private Stack<Undoer> undoers;
				
	// Constructor
	// Must setup any Inteface I plan on using
	public RPNController() {
		this.stack = new Stack<Double>();
		this.undoers = new Stack<Undoer>();
	}

	public boolean hasTwoOrMoreNumbers() {
		return (stack.size() >= 2);
	}
	
	public boolean hasOneOrMoreNumbers() {
		return (stack.size() >= 1);
	}
 	
	@GetMapping("/")
	public ModelAndView showCalculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		mv.addObject("stack", stack);
		mv.addObject("hasUndoer", !undoers.isEmpty());
		mv.addObject("hasTwoOrMoreNumbers", hasTwoOrMoreNumbers());
		mv.addObject("hasOneOrMoreNumbers", hasOneOrMoreNumbers());

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
		
		Adder adder = new Adder(stack);
		adder.goDoIt();
		undoers.push(adder);
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");
		return mv;
	}
	
	@PostMapping("/subtract")
	public ModelAndView subtractNumbersOnStack() {
		
		Subtractor sub = new Subtractor(stack);
		sub.goDoIt();
		undoers.push(sub);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/multiply")
	public ModelAndView multiplyNumbersOnStack() {
		
		Multiplier mul = new Multiplier(stack);
		mul.goDoIt();
		undoers.push(mul);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/divide")
	public ModelAndView divideNumbersOnStack() {
		
		Divider div = new Divider(stack);
		div.goDoIt();
		undoers.push(div);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/abs")
	public ModelAndView absoluteValue() {

		Abs abs = new Abs(stack);
		abs.goDoIt();
		undoers.push(abs);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	
	@PostMapping("/sin")
	public ModelAndView sinValue() {

		Sin sin = new Sin(stack);
		sin.goDoIt();
		undoers.push(sin);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}
	
	@PostMapping("/cos")
	public ModelAndView cosValue() {

		Cos cos = new Cos(stack);
		cos.goDoIt();
		undoers.push(cos);

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
