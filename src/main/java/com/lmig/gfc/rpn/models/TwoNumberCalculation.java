package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class TwoNumberCalculation implements Undoer {

	private Stack<Double> stack;
	private Undoer undoer;

	public TwoNumberCalculation(Stack<Double> stack) {
		this.stack = stack; 
	}

	public void goDoIt() {
		
		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = doMath(firstNumber, secondNumber);
		stack.push(result);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);
		
	}
	
	protected double doMath(double firstNumber, double secondNumber) {
		return 0;
	}
	
	@Override
	public void undo(Stack<Double> stack) {
		undoer.undo(stack);
	}

}