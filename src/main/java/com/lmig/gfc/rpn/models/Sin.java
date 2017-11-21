package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Sin extends OneNumberCalculation {

	public Sin(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return Math.sin(number);
	}

}
