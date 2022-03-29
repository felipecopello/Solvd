package com.solvd.library.util;

public class Node<T> {
	T data; // Data in the current node

	Node<T> next; // Reference for the next node

	Node(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}