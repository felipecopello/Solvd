package com.solvd.library.Iaba;

import java.util.LinkedList;
import java.util.Queue;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.exceptions.AgeNotIntException;
import com.solvd.library.exceptions.IdTooLongException;
import com.solvd.library.exceptions.NoStockException;

public class ClientQueue {
	private static Queue<Integer> queue = new LinkedList<>();
	private static final Logger LOGGER = LogManager.getLogger(ClientQueue.class);

	public static Queue<Integer> createQueue(int n) {
		for (int i = 1; i <= n; i++) {
			queue.add(i);
		}
		LOGGER.info(queue);
		return queue;
	}

	public static void recieveClientQueue(int args) throws IdTooLongException, NoStockException, AgeNotIntException {
		Queue<Integer> queue1 = createQueue(args);
		Librarian librarian1 = new Librarian();

		while (!queue1.isEmpty()) {
			librarian1.recieveNewClient();
			queue1.remove();
		}

	}

}
