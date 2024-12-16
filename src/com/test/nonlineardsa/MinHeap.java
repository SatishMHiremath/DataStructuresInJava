package com.test.nonlineardsa;

public class MinHeap {
    private int[] heap;
    private int size;
    private int capacity;

    public MinHeap(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.heap = new int[capacity + 1]; // heap[0] is not used
    }

    public void add(int value) {
        if (size >= capacity) {
            resize();
        }
        size++;
        heap[size] = value;
        heapifyUp(size);
    }

    public int poll() {
        if (size == 0) {
            throw new IllegalStateException("Heap is empty");
        }
        int root = heap[1];
        heap[1] = heap[size];
        size--;
        heapifyDown(1);
        return root;
    }

    private void heapifyUp(int index) {
        while (index > 1 && heap[index] < heap[index / 2]) {
            swap(index, index / 2);
            index /= 2;
        }
    }

    private void heapifyDown(int index) {
        while (2 * index <= size) {
            int smallest = 2 * index;
            if (smallest < size && heap[smallest + 1] < heap[smallest]) {
                smallest++;
            }
            if (heap[index] <= heap[smallest]) {
                break;
            }
            swap(index, smallest);
            index = smallest;
        }
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    private void resize() {
        capacity *= 2;
        heap = java.util.Arrays.copyOf(heap, capacity + 1);
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(10);
        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(5);

        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll()); // Output: 5 10 20
        }
    }
}
