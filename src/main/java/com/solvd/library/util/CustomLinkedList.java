package com.solvd.library.util;

public class CustomLinkedList<T> {
	Node<T> head;

	// function to add an element to the list at the end if there are element
	// already and at the start if no elements are there
	public void insert(T data) {
		Node<T> newNode = new Node<T>(data);
		if (head == null) {
			head = newNode;
		} else {
			Node<T> n = head;
			while (n.next != null) {
				n = n.next;
			}
			n.next = newNode;
		}
	}

	// function to add an element at the start of the list
	public void insertAtStart(T data) {
		Node<T> newNode = new Node<T>(data);

		newNode.next = head;
		head = newNode;
	}

	// function to add an element at a given index
	public void insertAt(int index, T data) {
		if (index == 0) {
			insertAtStart(data); // We already have a function to do this.
		} else {
			Node<T> newNode = new Node<T>(data);

			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			newNode.next = currentNode.next;
			currentNode.next = newNode;
		}
	}

	// function to delete an element at the given index
	public void deleteAt(int index) {
		if (index == 0) {
			head = head.next;
		} else {
			Node<T> currentNode = head;
			for (int i = 0; i < index - 1; i++) {
				currentNode = currentNode.next;
			}
			currentNode.next = currentNode.next.next;
		}
	}

	// function to show the list
	public void show() {
		Node<T> currentNode = head;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				System.out.print(currentNode.data + " ");
				currentNode = currentNode.next;
			}
		}
	}

	public int size() {
		Node<T> currentNode = head;
		int size = 0;
		if (currentNode == null) {
			System.out.println("Linked list is empty");
		} else {
			while (currentNode != null) {
				size = size + 1;
				currentNode = currentNode.next;
			}
		}
		return size;
	}

	public Node<T> get(int index) {
		if (index == 0) {
			return head;
		} else {
			Node<T> currentNode = head;
			for (int i = 0; i < index; i++) {
				currentNode = currentNode.next;
			}
			return currentNode;
		}
	}
}