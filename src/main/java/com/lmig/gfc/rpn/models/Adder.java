package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Adder extends TwoNumberCalculation implements Undoer {

	public Adder(Stack<Double> stack) {
		super(stack);
	}
	
	@Override
	protected double doMath(double firstNumber, double secondNumber) {
		return (firstNumber + secondNumber);
	}

}
