package com.lmig.gfc.rpn.models;

import java.util.Stack;

public abstract class OneNumberCalculation implements Undoer {

	private Stack<Double> stack;
	private Undoer undoer;
	
	public OneNumberCalculation(Stack<Double> stack) {
		this.stack = stack;
	}
	
	public void goDoIt() {
		
		double number = stack.pop();
		double result = doMath(number);
		stack.push(result);
		undoer = new OneArgumentUndoer(number);
	}
	
	protected abstract double doMath(double number);

	@Override
	public void undo(Stack<Double> stack) {
		undoer.undo(stack);
	}
}
