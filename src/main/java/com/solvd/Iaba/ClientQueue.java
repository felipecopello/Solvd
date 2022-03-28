package com.solvd.Iaba;

import java.util.LinkedList;
import java.util.Queue;

public abstract class ClientQueue<E> implements Queue<E> {

	public static Queue<Integer> createQueue(int n) {
		Queue<Integer> queue = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		System.out.println(queue);
		return queue;
	}

	public static void recieveClientQueue(int args) {
		Queue<Integer> queue1 = createQueue(args);
		Librarian librarian1 = new Librarian();

		while (!queue1.isEmpty()) {
			librarian1.recieveNewClient();
			queue1.remove();
		}

	}

}
