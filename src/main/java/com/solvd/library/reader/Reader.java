package com.solvd.library.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader {
	private static final Logger LOGGER = LogManager.getLogger(Reader.class);
	private static final File INPUT_FILE = new File("src/main/resources/article.txt");
	private static final File OUTPUT_FILE = new File("output.txt");
	private static Map<String, Integer> mapOutput = new TreeMap<>();

	private static Pattern pattern = Pattern.compile("[^a-zA-Z]");

	public static void main(String[] arg) {
		try {
			String fileAsString = FileUtils.readFileToString(INPUT_FILE, StandardCharsets.UTF_8);
			String lowerFileString = fileAsString.toLowerCase();
			String[] fileAsStrArray = pattern.split(lowerFileString);

			for (int i = 0; i < fileAsStrArray.length; i++) {
				if (!fileAsStrArray[i].isBlank()) {
					if (mapOutput.containsKey(fileAsStrArray[i])) {
						int n = mapOutput.get(fileAsStrArray[i]);
						n++;
						mapOutput.replace(fileAsStrArray[i], n);
					} else {
						mapOutput.put(fileAsStrArray[i], 1);
					}
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		mapOutput.entrySet().forEach(entry -> {
			try {
				FileUtils.writeStringToFile(OUTPUT_FILE,
						entry.getKey() + " = " + entry.getValue() + System.lineSeparator(), StandardCharsets.UTF_8,
						true);
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		LOGGER.info("The program exited without error.");
	}
}
