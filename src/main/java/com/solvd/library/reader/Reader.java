package com.solvd.library.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.TreeSet;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Reader {
	private static final Logger LOGGER = LogManager.getLogger(Reader.class);
	private static final File INPUT_FILE = new File("src/main/resources/article.txt");
	private static final File OUTPUT_FILE = new File("output.txt");
	private static TreeSet<String> arrayOutput = new TreeSet<>();

	private static Pattern pattern = Pattern.compile("\\s|,|\\.|\\(|\\)");;

	public static void main(String[] arg) {
		try {
			String fileAsString = FileUtils.readFileToString(INPUT_FILE, StandardCharsets.UTF_8);
			String lowerFileString = fileAsString.toLowerCase();
			String[] fileAsStrArray = pattern.split(lowerFileString);

			for (int i = 0; i < fileAsStrArray.length; i++) {
				int n = StringUtils.countMatches(lowerFileString, fileAsStrArray[i]);
				arrayOutput.add(fileAsStrArray[i] + "__" + n);
			}
			FileUtils.writeLines(OUTPUT_FILE, arrayOutput);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		LOGGER.info("The program exited without error.");
	}
}
