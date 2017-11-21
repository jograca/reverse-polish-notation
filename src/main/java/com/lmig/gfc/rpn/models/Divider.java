package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Divider extends TwoNumberCalculation implements Undoer {

	public Divider(Stack<Double> stack) {
		super(stack);
	}
	
	@Override
	protected double doMath(double firstNumber, double secondNumber) {
		return (firstNumber + secondNumber);
	}

}
