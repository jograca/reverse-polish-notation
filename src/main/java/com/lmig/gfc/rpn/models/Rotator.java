package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Rotator implements GoDoer {

	private Stack<Double> stack = new Stack<Double>();
	
	public Rotator(Stack<Double> stack) {
		this.stack = stack;
	}

	private void rotateValues(Stack<Double> stack) {
		Double mostRecent = stack.pop();
		Double secondRecent = stack.pop();
		Double thirdRecent = stack.pop();
		stack.push(mostRecent);
		stack.push(secondRecent);
		stack.push(thirdRecent);
	}
	
	@Override
	public void undo(Stack<Double> stack) {
		rotateValues(stack);
	}

	@Override
	public void goDoIt() {
		rotateValues(stack);
	}
}
