package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class TwoArgumentUndoer extends OneArgumentUndoer {

	private double secondNumber;
	
	public TwoArgumentUndoer(double firstNumber, double secondNumber) {
		super(firstNumber);
		this.secondNumber = secondNumber;
	}

	public void undo(Stack<Double> stack) {
		stack.pop();
		parentUndo(stack);
	}

	protected void parentUndo(Stack<Double> stack) {
		stack.push(secondNumber);
		super.parentUndo(stack);
	}
	
}
