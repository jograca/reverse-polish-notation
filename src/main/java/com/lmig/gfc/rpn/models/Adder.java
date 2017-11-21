package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Adder extends TwoNumberCalculation implements Undoer {

	public Adder(Stack<Double> stack) {
		this.stack = stack;
	}
	
	public void goDoIt() {
		
		double firstNumber = stack.pop();
		double secondNumber = stack.pop();
		double result = (firstNumber + secondNumber);
		stack.push(result);
		undoer = new TwoArgumentUndoer(firstNumber, secondNumber);
		
	}

}
