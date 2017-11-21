package com.lmig.gfc.rpn.models;

import java.util.Stack;

// Public abstract class - means that this class cannot be instantiated
// It does not have enough information to create a Two Number Calculation
// Indicates that the Child classes are the ones that need to be instantiated
// This method does not make sense - it returns 0 

public abstract class TwoNumberCalculation implements Undoer {

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
	
	protected abstract double doMath(double firstNumber, double secondNumber);
//
// Code above is a different way of saying: 
//
//	protected double doMath(double firstNumber, double secondNumber) {
//		return 0;
//	}
//	
	@Override
	public void undo(Stack<Double> stack) {
		undoer.undo(stack);
	}

}