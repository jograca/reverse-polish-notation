package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class CalculateOne {

	protected double number;

	public CalculateOne(double number) {
		this.number = number;
	}

	public void absoluteNumbersOnStack(Stack<Double> stack) {
		number = stack.pop();
		double result = (Math.abs(number));
		stack.push(result);
	}

	public void sinNumberOnStack(Stack<Double> stack) {
		number = stack.pop();
		double result = (Math.sin(number));
		stack.push(result);
	}

	public void cosNumberOnStack(Stack<Double> stack) {
		number = stack.pop();
		double result = (Math.cos(number));
		stack.push(result);
	}

	protected void parentCalculate(Stack<Double> stack) {
		stack.push(number);
	}
}
