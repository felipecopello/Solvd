package com.solvd.library.deadlock;

public class DeadlockTest {
	public static void main(String[] args) {
		final String resource1 = "First";
		final String resource2 = "Second";

		Thread firstThread = new Thread() {
			public void run() {
				synchronized (resource1) {
					System.out.println("Thread 1: locked resource 1");
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}

					synchronized (resource2) {
						System.out.println("Thread 1: locked resource 2");
					}
				}
			}
		};

		Thread secondThread = new Thread() {
			public void run() {
				synchronized (resource2) {
					System.out.println("Thread 2: locked resource 2");
					try {
						Thread.sleep(10);
					} catch (Exception e) {
					}

					synchronized (resource1) {
						System.out.println("Thread 2: locked resource 1");
					}
				}
			}
		};

		firstThread.start();
		secondThread.start();
	}
}
