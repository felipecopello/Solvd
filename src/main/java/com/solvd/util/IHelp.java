package com.solvd.util;

public interface IHelp {
	default void helpClient() {
		System.out.format("%nProvide help to the client");
	}
}