package com.lmig.gfc.rpn.controllers;

import java.util.Stack;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.servlet.ModelAndView;

import com.lmig.gfc.rpn.models.AbsoluterOfOneNumber;
import com.lmig.gfc.rpn.models.Adder;
import com.lmig.gfc.rpn.models.Cos;
import com.lmig.gfc.rpn.models.Cosh;
import com.lmig.gfc.rpn.models.Divider;
import com.lmig.gfc.rpn.models.Exponent;
import com.lmig.gfc.rpn.models.GoDoer;
import com.lmig.gfc.rpn.models.Log;
import com.lmig.gfc.rpn.models.Multiplier;
import com.lmig.gfc.rpn.models.ItDoesThePushing;
import com.lmig.gfc.rpn.models.Sin;
import com.lmig.gfc.rpn.models.Sinh;
import com.lmig.gfc.rpn.models.Subtractor;
import com.lmig.gfc.rpn.models.Tan;
import com.lmig.gfc.rpn.models.Tanh;
import com.lmig.gfc.rpn.models.OneNumberCalculation;

// Button to clear stack taht is undoable
// Stack maniuplation operations:
// * Swap (change positions)
// * Rotate - take 3 most recent operations so oldest becomes newest

@Controller
public class RPNController {

	// What can I interface in this Controller?
	// I can Interface with a Stack, or with an Undoer
	private Stack<Double> stack;
	private Stack<GoDoer> undoers;
	private Stack<GoDoer> redoers;
	private Stack<GoDoer> clearers;

	// Constructor
	// Must setup any Inteface I plan on using
	public RPNController() {
		this.stack = new Stack<Double>();
		this.undoers = new Stack<GoDoer>();
		this.redoers = new Stack<GoDoer>();
		this.clearers = new Stack<GoDoer>();
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
		clearers.push(onc);
		redoers.clear();

		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

	private ModelAndView doTwoNumberOperation(GoDoer tnc) {
		tnc.goDoIt();
		undoers.push(tnc);
		clearers.push(tnc);
		redoers.clear();

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
		mv.addObject("hasRedoer", !redoers.isEmpty());
		mv.addObject("hasTwoOrMoreNumbers", hasTwoOrMoreNumbers());
		mv.addObject("hasOneOrMoreNumbers", hasOneOrMoreNumbers());

		return mv;
	}

	@PostMapping("/enter")
	public ModelAndView pushNumberOntoStack(double value) {
		ItDoesThePushing pusher = new ItDoesThePushing(stack, value);
		return doTwoNumberOperation(pusher);
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
		AbsoluterOfOneNumber absoluter = new AbsoluterOfOneNumber(stack);
		return doTwoNumberOperation(absoluter);
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
		
		GoDoer undoer = undoers.pop();
		GoDoer clearer = clearers.pop();
		
		clearer.goDoIt();
		undoer.goDoIt();
		
		undoer.undo(stack);
		
		redoers.push(undoer);

		return redirectToHome();
	}

	@PostMapping("/redo")
	public ModelAndView redoNumbersOnStack() {

		GoDoer godoer = redoers.pop();
		godoer.goDoIt();
		undoers.push(godoer);

		return redirectToHome();
	}

	@PostMapping("/clear")
	public ModelAndView clearNumbersOnStack() {
		
		GoDoer clearer = clearers.pop();
		undoers.push(clearer);
		
		stack.clear();
		
		return redirectToHome();
	}

	private ModelAndView redirectToHome() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:/");

		return mv;
	}

}
