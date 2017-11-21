package com.lmig.gfc.rpn.models;

import java.util.Stack;

public class TwoNumberCalculation implements Undoer {

	protected Stack<Double> stack;
	protected Undoer undoer;

	public TwoNumberCalculation() {
		super();
	}

	@Override
	public void undo(Stack<Double> stack) {
		undoer.undo(stack);
	}

}