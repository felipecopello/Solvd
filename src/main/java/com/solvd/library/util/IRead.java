package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IRead {
	static final Logger LOGGER = LogManager.getLogger(IRead.class);

	default void read() {
		LOGGER.info("%nReading...");
	}
}