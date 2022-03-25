package com.solvd.loggerExample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
	private static final Logger LOGGER = LogManager.getLogger(Main.class);

	public static void main(String[] args) {
		LOGGER.debug("Hello debug");
		LOGGER.info("Hello info");
		LOGGER.warn("Hello warn");
		LOGGER.error("Hello error");
	}
}
