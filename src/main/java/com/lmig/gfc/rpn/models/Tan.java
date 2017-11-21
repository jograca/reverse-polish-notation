package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Tan extends OneNumberCalculation {

	public Tan(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return Math.tan(number);
	}

}
