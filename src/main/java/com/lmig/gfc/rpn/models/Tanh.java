package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Tanh extends OneNumberCalculation {

	public Tanh(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return (Math.tanh(number));
	}

}
