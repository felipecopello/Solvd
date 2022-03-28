package com.solvd.util;

import java.util.AbstractList;

public class CustomLinkedList<T> extends AbstractList<T> {

	private T[] a;

	public CustomLinkedList(T[] array) {
		a = array;
	}

	public T get(int index) {
		return a[index];
	}

	public T set(int index, T element) {
		T oldValue = a[index];
		a[index] = element;
		return oldValue;
	}

	public int size() {
		return a.length;
	}

	public void show() {
		if (a.length == 0) {
			System.out.println("Linked list is empty");
		} else {
			for (int i = 0; i < a.length; i++) {
				System.out.println(a[i]);
			}
		}
	}

}
