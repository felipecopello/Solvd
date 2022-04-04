package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IHelp {
	static final Logger LOGGER = LogManager.getLogger(IHelp.class);

	default void helpClient() {
		LOGGER.info("%nProvide help to the client");
	}
}