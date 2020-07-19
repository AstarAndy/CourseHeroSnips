package com.acf.samples;

import java.util.Stack;
import java.util.function.IntConsumer;

public class JavaFunctions {
	
	/**
	 * This class is used by those functions that will
	 * move by more than one space and contains the specific movement
	 * function to be called and how many times.
	 * @author Student's Name
	 */
	static class MovementAction {
		private IntConsumer action;
		private Integer howFar;
		MovementAction(IntConsumer whatDirection, Integer howMany) {
			action = whatDirection;
			howFar = howMany;
		}
		public void move() {
			action.accept(howFar);
		}
	}
	
	// This is a queue of the movements to be made
	static Stack<MovementAction> queue = new Stack<>();
	
	// Moves the robot 1 space forward
	static IntConsumer funcForward = oneSpace -> {
		System.out.println("funcForward moving 1 space");
	};
	
	// Moves the robot 1 space backwards
	static IntConsumer funcBackward = oneSpace -> {
		System.out.println("funcBackward moving 1 space");
	};

	// This function will call the funcForward function based on the value passed
	static IntConsumer moveForward = spaces -> {
		for (int a = 0; a < spaces; a++) {
			queue.push(new MovementAction(funcForward, 1));
		}
	};	

	// This function will call the funcBackward function based on the value passed
	static IntConsumer moveBackward = spaces -> {
		for (int a = 0; a < spaces; a++) {
			queue.push(new MovementAction(funcBackward, 1));
		}
	};	

	// Turns the robot 1/4 left
	static IntConsumer funcLeft = oneSpace -> {
		System.out.println("funcLeft turning 1/4 space left");
	};
	
	// Turns the robot 1/4 turn right
	static IntConsumer funcRight = oneSpace -> {
		System.out.println("funcRight turning 1/4 space right");
	};

	// This function will call the funcLeft function based on the value passed
	static IntConsumer turnLeft = spaces -> {
		for (int a = 0; a < spaces; a++) {
			queue.push(new MovementAction(funcLeft, 1));
		}
	};	

	// This function will call the funcRight function based on the value passed
	static IntConsumer turnRight = spaces -> {
		for (int a = 0; a < spaces; a++) {
			queue.push(new MovementAction(funcRight, 1));
		}
	};	
	
	// Just a function to test the other functions
	static IntConsumer run = notUsed -> {
		moveForward.accept(5);
		turnLeft.accept(3);
	};
	
	/**
	 * Used to test the functions
	 * @param args
	 */
	public static void main(String[] args) {
		
		// First test is to just call the various movement functions directly
		
		moveForward.accept(5);
		turnLeft.accept(3);
		turnRight.accept(2);
		
		// Now execute the movements
		for (MovementAction action : queue) {
			action.move();
		}
		
		queue.clear();
		
		// Now use the run function
		run.accept(0);
		// Now execute the movements
		for (MovementAction action : queue) {
			action.move();
		}		
		
	}

}
