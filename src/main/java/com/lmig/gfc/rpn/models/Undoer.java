package com.lmig.gfc.rpn.models;

import java.util.Stack;

public interface Undoer {

	// Interfaces contain method signatures
	// They must be exact for any Class that implements it 
	
	// Interfaces are a key tennent of Polymorphism
	// That is, in Java, Objects of various types and Classes
	// Can be access through a single uniform interface
	
	public void undo(Stack<Double> stack);
}
