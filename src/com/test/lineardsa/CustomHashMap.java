package com.test.lineardsa;

import java.util.LinkedList;

public class CustomHashMap<K, V> {

	static class Entry<K,V> {
		K key;
		V value;

		Entry(K key, V value) {
			this.key=key;
			this.value=value;
		}
	}

	private final int SIZE = 16;
	private final java.util.LinkedList<Entry<K, V>>[] table;

	public CustomHashMap() {
		table = new java.util.LinkedList[SIZE];
		for (int i = 0; i < SIZE; i++) {
			table[i] = new java.util.LinkedList<>();
		}
	}

	public static void main(String[] args) {
		CustomHashMap<String, Integer> customMap = new CustomHashMap<String, Integer>();
		customMap.put("a", 1);
		customMap.put("b", 2);
		System.out.println(customMap.get("a"));
		System.out.println(customMap.get("b"));
	}

	private V get(K key) {
		int index = key.hashCode()%SIZE; 
		LinkedList<Entry<K, V>> bucket = table[index];
		for(Entry<K, V> entry : bucket) {
			if(entry.key.equals(key)) {
				return entry.value;
			}
		}
		return null;
	}

	private void put(K key, V value) {
		int index = key.hashCode()%SIZE;
		LinkedList<Entry<K, V>> bucket = table[index];
		for(Entry<K, V> entry : bucket) {
			if(entry.key.equals(key)) {
				entry.value = value;
				return;
			}
		}
		bucket.add(new Entry<>(key, value));
	} 
}
