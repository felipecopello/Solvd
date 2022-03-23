package com.solvd.Iaba;

import com.solvd.util.IHelp;
import com.solvd.util.IWork;

public class Janitor extends People implements IHelp, IWork {
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