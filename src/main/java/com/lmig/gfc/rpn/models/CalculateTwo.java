package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class CalculateTwo extends CalculateOne {

	protected double firstNumber;
	protected double secondNumber;

	public CalculateTwo(double firstNumber, double secondNumber) {
		super(firstNumber);
		this.secondNumber = secondNumber;
	}

	public void addNumbersOnStack(Stack<Double> stack) {

		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber + firstNumber);
		stack.push(result);
	}

	public void subtractNumbersOnStack(Stack<Double> stack) {

		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber - firstNumber);
		stack.push(result);
	}

	public void multiplyNumbersOnStack(Stack<Double> stack) {

		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber * firstNumber);
		stack.push(result);
	}

	public void divideNumbersOnStack(Stack<Double> stack) {

		firstNumber = stack.pop();
		secondNumber = stack.pop();
		double result = (secondNumber / firstNumber);
		stack.push(result);
	}

}
