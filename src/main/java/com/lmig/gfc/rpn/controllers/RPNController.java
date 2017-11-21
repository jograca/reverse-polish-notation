package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.Abs;
import com.lmig.gfc.rpn.models.Adder;
import com.lmig.gfc.rpn.models.Cos;
import com.lmig.gfc.rpn.models.Cosh;
import com.lmig.gfc.rpn.models.Divider;
import com.lmig.gfc.rpn.models.Exponent;
import com.lmig.gfc.rpn.models.Log;
import com.lmig.gfc.rpn.models.Multiplier;
import com.lmig.gfc.rpn.models.PushUndoer;
import com.lmig.gfc.rpn.models.Sin;
import com.lmig.gfc.rpn.models.Sinh;
import com.lmig.gfc.rpn.models.Subtractor;
import com.lmig.gfc.rpn.models.Tan;
import com.lmig.gfc.rpn.models.Tanh;
import com.lmig.gfc.rpn.models.OneNumberCalculation;
import com.lmig.gfc.rpn.models.TwoNumberCalculation;
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

	private ModelAndView doOneNumberOperation(OneNumberCalculation onc) {
		onc.goDoIt();
		undoers.push(onc);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

	private ModelAndView doTwoNumberOperation(TwoNumberCalculation tnc) {
		tnc.goDoIt();
		undoers.push(tnc);

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
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
		return doTwoNumberOperation(adder);
	}

	@PostMapping("/subtract")
	public ModelAndView subtractNumbersOnStack() {

		Subtractor sub = new Subtractor(stack);
		return doTwoNumberOperation(sub);
	}

	@PostMapping("/multiply")
	public ModelAndView multiplyNumbersOnStack() {

		Multiplier mul = new Multiplier(stack);
		return doTwoNumberOperation(mul);
	}

	@PostMapping("/divide")
	public ModelAndView divideNumbersOnStack() {

		Divider div = new Divider(stack);
		return doTwoNumberOperation(div);
	}
	
	@PostMapping("/exponent")
	public ModelAndView exponentNumbersOnStack() {
		
		Exponent exp = new Exponent(stack);
		return doTwoNumberOperation(exp);
	}

	@PostMapping("/abs")
	public ModelAndView absoluteValue() {

		Abs abs = new Abs(stack);
		return doOneNumberOperation(abs);
	}

	@PostMapping("/sin")
	public ModelAndView sinValue() {

		Sin sin = new Sin(stack);
		return doOneNumberOperation(sin);
	}

	@PostMapping("/cos")
	public ModelAndView cosValue() {

		Cos cos = new Cos(stack);
		return doOneNumberOperation(cos);
	}
	
	@PostMapping("/tan")
	public ModelAndView tanValue() {

		Tan tan = new Tan(stack);
		return doOneNumberOperation(tan);
	}
	
	@PostMapping("/sinh")
	public ModelAndView sinhValue() {

		Sinh sinh = new Sinh(stack);
		return doOneNumberOperation(sinh);
	}

	@PostMapping("/cosh")
	public ModelAndView coshValue() {

		Cosh cosh = new Cosh(stack);
		return doOneNumberOperation(cosh);
	}
	
	@PostMapping("/tanh")
	public ModelAndView tanhValue() {

		Tanh tanh = new Tanh(stack);
		return doOneNumberOperation(tanh);
	}
	
	@PostMapping("/log")
	public ModelAndView logValue() {

		Log log = new Log(stack);
		return doOneNumberOperation(log);
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
