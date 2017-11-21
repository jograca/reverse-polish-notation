package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Cos extends OneNumberCalculation {

	public Cos(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return Math.cos(number);
	}

}
