package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class StackClearer implements GoDoer {

	private Stack<Double> clearingStack = new Stack<Double>();
	private Stack<Double> holdingStack = new Stack<Double>();
	
	public StackClearer (Stack<Double> clearingStack) {
		this.clearingStack = clearingStack;
	}
	
	private void clearStack(Stack<Double> fromStack, Stack<Double> toStack) {
		while (!fromStack.isEmpty()) {
			Double value = fromStack.pop();
			toStack.push(value);
		}
	}
	
	@Override
	public void undo(Stack<Double> stack) {
		clearStack(holdingStack, clearingStack);
	}

	@Override
	public void goDoIt() {
		clearStack(clearingStack, holdingStack);
	}

}
