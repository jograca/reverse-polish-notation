package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class Swapper implements GoDoer {

	private Stack<Double> stack = new Stack<Double>();
	
	public Swapper(Stack<Double> stack) {
		this.stack = stack;
	}

	private void swapValues(Stack<Double> stack) {
		Double mostRecent = stack.pop();
		Double secondRecent = stack.pop();
		stack.push(mostRecent);
		stack.push(secondRecent);
	}
	
	@Override
	public void undo(Stack<Double> stack) {
		swapValues(stack);
	}

	@Override
	public void goDoIt() {
		swapValues(stack);
	}

}
