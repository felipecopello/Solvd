package com.solvd.library.util;

public interface IRead {
	default void read() {
		System.out.format("%nReading...");
	}
}