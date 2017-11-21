package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Subtractor extends TwoNumberCalculation {

	public Subtractor(Stack<Double> stack) {
		super(stack);
	}
	
	@Override
	protected double doMath(double firstNumber, double secondNumber) {
		return (secondNumber - firstNumber);
	}
	
}
