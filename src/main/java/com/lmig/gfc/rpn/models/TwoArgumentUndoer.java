package com.lmig.gfc.rpn.models;

import java.util.Stack;

// Extends is the declaration that a Class inherits a Parent Class

public class TwoArgumentUndoer extends OneArgumentUndoer {

	private double secondNumber;
	
	public TwoArgumentUndoer(double firstNumber, double secondNumber) {
		super(firstNumber);
		this.secondNumber = secondNumber;
	}

	public void undo(Stack<Double> stack) {
		stack.pop();
		this.parentUndo(stack);
	}

	protected void parentUndo(Stack<Double> stack) {
		stack.push(secondNumber);
		super.parentUndo(stack);
	}
	
}
