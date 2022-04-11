package com.solvd.library.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader {
	private static final Logger LOGGER = LogManager.getLogger(Reader.class);
	private static final File INPUT_FILE = new File("src/main/resources/article.txt");
	private static final File OUTPUT_FILE = new File("output.txt");
	private static TreeSet<String> arrayOutput = new TreeSet<>();

	private static Pattern pattern = Pattern.compile("[^a-zA-Z0-9]");

	public static void main(String[] arg) {
		try {
			String fileAsString = FileUtils.readFileToString(INPUT_FILE, StandardCharsets.UTF_8);
			String lowerFileString = fileAsString.toLowerCase();
			String[] fileAsStrArray = pattern.split(lowerFileString);
			int n = 0;

			for (int i = 0; i < fileAsStrArray.length; i++) {
				for (int j = 1; j < fileAsStrArray.length; j++) {
					if (fileAsStrArray[i].equals(fileAsStrArray[j])) {
						n++;
					}
				}
				arrayOutput.add(fileAsStrArray[i] + "__" + n);
				n = 0;
			}
			FileUtils.writeLines(OUTPUT_FILE, arrayOutput);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		LOGGER.info("The program exited without error.");
	}
}
