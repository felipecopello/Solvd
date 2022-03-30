package com.solvd.library.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App {
	
	private static final Logger LOGGER = LogManager.getLogger(App.class);

	public static void main(String[] args) {

		LOGGER.debug("Hello from Log4j 2");
		LOGGER.debug("This is a Debug Message!");
		LOGGER.info("This is an Info Message!");
		LOGGER.error("And here comes the Error Message!", new RuntimeException("RunRunRun"));
		
	}
}