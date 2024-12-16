package com.test.lineardsa;

public class LinkedList {

	private Node head;

	class Node {
		private int data;
		private Node next;
		public Node(int val) {
			this.data = val;
			this.next = null;
		}
	}

	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		linkedList.addNode(10);
		linkedList.addNode(20);
		linkedList.addNode(30);
		linkedList.addNode(40);
		//		linkedList.removeNode(20);
		//		linkedList.insertAtPosition(10);
		//		linkedList.insertAtBegining(100);
		//		linkedList.insertAtEnd(200);
		System.out.println();
		linkedList.printList();
		linkedList.reverseNode();

	}

	private void printList() {
		Node curr = head;
		System.out.println("Linked List : ");
		while(curr != null ) {
			System.out.print(curr.data);
			if(curr.next != null) {
				System.out.print(" -> ");
			}
			curr=curr.next;
		}
		System.out.println();
	}

	private void addNode(int val) {
		Node newNode = new Node(val);
		Node curr = null;
		if(head == null) {
			head = newNode;
		}else {
			curr = head;
			while(curr.next != null) {	
				curr = curr.next;
			}
			curr.next = newNode;
		}
	}

	private void removeNode(int val) {

	}

	private void insertAtPosition(int val) {

	}

	private void insertAtBegining(int val) {

	}

	private void insertAtEnd(int val) {

	} 

	private void reverseNode() {
		Node curr = head;
		Node prev = null;
		Node next = null;
		
		if(head == null) {
			System.out.println("Node head is null");
		}
//		System.out.print(curr.data+" -> ");
		while(curr != null && curr.next != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
			System.out.print(prev.data+" ");
			if(curr.next != null) {
				System.out.print(" -> ");
			}
		}
		head=prev;
	}

}
