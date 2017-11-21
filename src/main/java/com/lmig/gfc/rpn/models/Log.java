package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Log extends OneNumberCalculation {

	public Log(Stack<Double> stack) {
		super(stack);
	}

	@Override
	protected double doMath(double number) {
		return (Math.log(number));
	}

}
