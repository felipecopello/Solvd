package com.solvd.library.util;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public interface IWork {
	static final Logger LOGGER = LogManager.getLogger(IWork.class);

	default void work() {
		LOGGER.info("%nPerforming a job");
	}
}