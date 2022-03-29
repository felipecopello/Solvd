package com.solvd.library.util;

public interface IWork {
	default void work() {
		System.out.format("%nPerforming a job");
	}
}