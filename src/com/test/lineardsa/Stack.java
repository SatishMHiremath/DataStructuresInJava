package com.test.lineardsa;

public class Stack {
	int[] arr;
	int size;
	int capacity;
	int top;

	public Stack(int size) {
		this.capacity = size;
		this.arr= new int[size];
		this.top = -1;
	}

	public static void main(String[] args) {
		Stack stack = new Stack(10);
		stack.push(100);
		stack.push(200);
		stack.push(300);
		stack.push(400);
		stack.push(500);
		stack.pop();
		stack.pop();
		stack.peek();
	}

	private void peek() {
		System.out.println("Stack element to peek : "+arr[top]);
	}

	private void pop() {
		if(top == -1) {
			System.out.println("Stack is empty");
		}
		System.out.println("Pop element : "+arr[top--]);
	}

	private void push(int val) {
		if(top == capacity-1) {
			System.out.println("Stack is full");
		}
		arr[++top] = val;
		System.out.println("Element pushed on to stack : "+arr[top]);
	}

}
