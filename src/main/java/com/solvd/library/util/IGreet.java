package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IGreet {
	static final Logger LOGGER = LogManager.getLogger(IGreet.class);

	default void greet(String name) {
		LOGGER.info("%nHello! my name is " + name);
	}
}