package com.test.lineardsa;

public class Queue {

	int[] queueArr;
	int front;
	int rear;
	int capacity;
	int size;
	
	public Queue(int size) {
		this.capacity=size;
		this.queueArr= new int[this.capacity];
		this.front = 0;
		this.rear = capacity-1;
	}

	public static void main(String[] args) {
		Queue queue = new Queue(10);
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.dequeue();
		queue.enqueue(60);
		queue.dequeue();
		queue.peek();
	}

	private void peek() {
		System.out.println("Queue element after peek : "+queueArr[front]);
	}

	private void enqueue(int val) {
		if(size == capacity) {
			System.out.println("Queue is full");
			return;
		}
		rear = (rear+1)%capacity;
		queueArr[rear] = val;
		System.out.println("Enqueue emement : "+queueArr[rear]);
		size++;
	}

	private void dequeue() {
		if(size==0) {
			System.out.println("Queue is empty");
		}
		int item = queueArr[front];
		front=(front+1)%capacity;
		size--;
		System.out.println("Dequeue element : "+item);
	}
}
