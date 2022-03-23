package com.solvd.util;

public interface IRead {
	default void read() {
		System.out.format("%nReading...");
	}
}