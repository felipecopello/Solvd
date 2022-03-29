package com.solvd.library.util;

public interface IHelp {
	default void helpClient() {
		System.out.format("%nProvide help to the client");
	}
}