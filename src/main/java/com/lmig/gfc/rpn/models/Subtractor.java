package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Subtractor extends TwoNumberCalculation implements Undoer {

	public Subtractor(Stack<Double> stack) {
		this.stack = stack;
	}
	
	public void goDoIt() {
		
		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (secondNumber - firstNumber);
		stack.push(result);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);
		
	}
	
}
