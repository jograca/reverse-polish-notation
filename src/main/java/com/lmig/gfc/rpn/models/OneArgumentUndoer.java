package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class OneArgumentUndoer {

	private double firstNumber;

	public OneArgumentUndoer(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public void undo(Stack<Double> stack) {
		stack.pop();
		parentUndo(stack);
	}

	protected void parentUndo(Stack<Double> stack) {
		stack.push(firstNumber);
	}
}
