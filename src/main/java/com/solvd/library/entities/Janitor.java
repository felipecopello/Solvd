package com.solvd.library.entities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.solvd.library.enums.Sex;
import com.solvd.library.util.IHelp;
import com.solvd.library.util.IWork;

public class Janitor extends Person implements IHelp, IWork {
	private static final Logger LOGGER = LogManager.getLogger(Janitor.class);

	public Janitor() {
	};

	public Janitor(String name, int age, int id, Sex gender) {
		super(name, age, id, gender);
	}

	@Override
	public void work() {
		LOGGER.info("%nCleaning the library");
	}

	@Override
	public void helpClient() {
		LOGGER.info("%nThe book you are looking for is over here");
	}

	@Override
	public void interact() {
		LOGGER.info("Be careful the floor is wet.");
	}

}