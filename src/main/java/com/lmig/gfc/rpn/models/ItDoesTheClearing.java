package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class ItDoesTheClearing implements Undoer, GoDoer {

	private Stack<Double> stack;
	
	public ItDoesTheClearing(Stack<Double> stack) {
		this.stack = stack;
	}
	
	@Override
	public void goDoIt() {
		stack.clear();
	}

	@Override
	public void undo(Stack<Double> stack) {
		stack.pop();
	}

}
