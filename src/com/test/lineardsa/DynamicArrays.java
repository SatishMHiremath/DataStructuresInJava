package com.test.lineardsa;

public class DynamicArrays {

	int[] arr;
	int size;
	int capacity;
	public DynamicArrays() {
		arr = new int[5];
		size = 0;
		capacity = arr.length;
	}

	private int get(int index) throws Exception {
		if(index<0 || index>size) {
			throw new Exception("Index out of bound exception");
		}
		System.out.println("Find the element after removing index at "+index +"  is "+ arr[index]);
		return arr[index];
	}

	private void remove(int index) throws Exception {
		if(index<0 || index>size) {
			throw new Exception("Index out of bound exception");
		}
		System.out.println("Remove Element at index "+index+" for element "+arr[index]);

		for(int i=index; i< size-1; i++) {
			arr[i]=arr[i+1];
		}
		size--;
	}

	private void add(int val) {
		if(size == capacity) {
		    resize();
		}
		arr[++size] = val;
		System.out.println("Add item into array : "+arr[size]);
	}

	public void resize() {
		capacity*=2;
		arr = Arrays.copyOf(arr, capacity);
	}
	
	public static void main(String[] args) {
		DynamicArrays arrays = new DynamicArrays();
		arrays.add(10);
		arrays.add(20);
		arrays.add(30);
		arrays.add(40);
		try {
			arrays.remove(2);
			arrays.get(2);
			arrays.set(1,100);
			boolean hasVal = arrays.find(40);
			System.out.println("Element found in array : "+ hasVal);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private boolean find(int val) {
		boolean hasVal = false;
		for(int i=0;i<arr.length;i++) {
			if(arr[i] == val) {
				hasVal = true;
				break;
			}
		}
		return hasVal;
	}

	private void set(int index, int value) throws Exception {
		if(index < 0 || index>=size) {
			throw new Exception("Ïndex out of bound exception");
		}
		arr[index]=value;
		System.out.println("Set element at index"+index+" for element "+arr[index]);
	}
}
