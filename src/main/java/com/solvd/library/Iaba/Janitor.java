package com.solvd.library.Iaba;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class Janitor extends Person implements IHelp, IWork {
	private static final Logger LOGGER = LogManager.getLogger(Janitor.class);

	public Janitor() {
	};

	public Janitor(String name, int age, int id) {
		super(name, age, id);
	}

	@Override
	public void work() {
		LOGGER.info("%nCleaning the library");
	}

	@Override
	public void helpClient() {
		LOGGER.info("%nThe book you are looking for is over here");
	}

}