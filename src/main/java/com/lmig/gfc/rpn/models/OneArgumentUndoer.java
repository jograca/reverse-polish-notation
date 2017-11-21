package com.lmig.gfc.rpn.models;

import java.util.Stack;

// In order to implement the Interface, only the Parent Class
// needs to declare that the Class implements the Interface
// (not the Children)

public class OneArgumentUndoer implements Undoer {

	private double firstNumber;

	public OneArgumentUndoer(double firstNumber) {
		this.firstNumber = firstNumber;
	}

	public void undo(Stack<Double> stack) {
		stack.pop();
		this.parentUndo(stack);
	}

	protected void parentUndo(Stack<Double> stack) {
		stack.push(firstNumber);
	}
}
