package com.test.nonlineardsa;

import java.util.LinkedList;

class Graph {
	private LinkedList<Integer>[] adjList;

	public Graph(int vertices) {
		adjList = new LinkedList[vertices];
		for (int i = 0; i < vertices; i++) {
			adjList[i] = new LinkedList<>();
		}
	}

	public void addEdge(int src, int dest) {
		adjList[src].add(dest);
		adjList[dest].add(src); // For undirected graph
	}

	public void printGraph() {
		for (int i = 0; i < adjList.length; i++) {
			System.out.print("Vertex " + i + ": ");
			for (int edge : adjList[i]) {
				System.out.print(edge + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		Graph graph = new Graph(5);
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 3);
		graph.addEdge(1, 4);
		graph.addEdge(3, 4);
		graph.addEdge(3, 2);

		graph.printGraph();
	}
}
