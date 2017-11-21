package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Cosh extends OneNumberCalculation {

	public Cosh(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return (Math.cosh(number));
	}

	
}
