package com.test.nonlineardsa;

import java.util.PriorityQueue;

public class MinHeap {
    public static void main(String[] args) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Output: 5 10 20
        }
    }
}

