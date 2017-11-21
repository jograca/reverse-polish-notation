package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Sinh extends OneNumberCalculation {

	public Sinh(Stack<Double> stack) {
		super(stack);	}

	@Override
	protected double doMath(double number) {
		return (Math.sinh(number));
	}

}
