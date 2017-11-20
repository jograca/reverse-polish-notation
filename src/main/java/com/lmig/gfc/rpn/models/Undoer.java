package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Undoer {

	private double firstNumber;
	private double secondNumber;
	
	public Undoer(double firstNumber, double secondNumber) {
		this.firstNumber = firstNumber;
		this.secondNumber = secondNumber;
		
	}

	public void undo(Stack<Double> stack) {
	
		stack.pop();
		stack.push(secondNumber);
		stack.push(firstNumber);
		
	}
	
}
