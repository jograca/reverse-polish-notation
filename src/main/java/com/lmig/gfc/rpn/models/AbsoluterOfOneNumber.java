package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class AbsoluterOfOneNumber implements Undoer, GoDoer {
	
	private Stack<Double> stack;
	private OneArgumentUndoer oau; 
	
	public AbsoluterOfOneNumber (Stack<Double> stack) {
		this.stack = stack;
	}
	
	public void goDoIt() {
		double value = stack.pop();
		double result = Math.abs(value);
		stack.push(result);
		oau = new OneArgumentUndoer(value);
	}

	@Override
	public void undo(Stack<Double> stack) {
		oau.undo(stack);
	}
}
