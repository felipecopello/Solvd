package com.solvd.library.Iaba;

import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class Janitor extends Person implements IHelp, IWork {
	public Janitor() {
	};

	public Janitor(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void work() {
		System.out.format("%nCleaning the library");
	}

	@Override
	public void helpClient() {
		System.out.format("%nThe book you are looking for is over here");
	}

}