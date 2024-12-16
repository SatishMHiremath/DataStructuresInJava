package com.test.nonlineardsa;

public class BinaryTree {
	
	Node root;
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data= data;
			this.left = null;
			this.right = null;
		}
	}
	
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(10);
		tree.root.left = new Node(20);
		tree.root.right = new Node(30);
		tree.root.left.left = new Node(40);
		tree.root.left.right = new Node(50);
		System.out.println("Inorder Traversal : ");
		tree.inorderTraversal(tree.root);
		System.out.println();
		System.out.println("Preorder Traversal : ");
		tree.preorderTraversal(tree.root);
		System.out.println();
		System.out.println("Postorder Traversal : ");
		tree.postorderTraversal(tree.root);
	}

	private void inorderTraversal(Node node) {
		if(node == null) return;
		inorderTraversal(node.left);
		System.out.print(node.data+" ");
		inorderTraversal(node.right);
	}

	private void preorderTraversal(Node node) {
		if(node == null) return;
		System.out.print(node.data+" ");
		preorderTraversal(node.left);
		preorderTraversal(node.right);
	}
	
	private void postorderTraversal(Node node) {
		if(node == null) return;
		postorderTraversal(node.left);
		postorderTraversal(node.right);
		System.out.print(node.data+" ");
	}

}
