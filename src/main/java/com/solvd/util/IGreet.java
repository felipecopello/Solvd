package com.solvd.util;

public interface IGreet {
	default void greet(String name) {
		System.out.format("%nHello! my name is " + name);
	}
}