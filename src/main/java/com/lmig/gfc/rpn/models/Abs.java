package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Abs extends OneNumberCalculator {

	public Abs(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return Math.abs(number);
	}

}
