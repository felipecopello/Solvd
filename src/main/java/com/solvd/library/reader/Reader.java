package com.solvd.library.reader;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

public class Reader {
	private static File file1 = new File(
			"C:\\Users\\Felipe\\eclipse-workspace\\Library\\src\\main\\resource\\article.txt");
	private static File outputFile = new File(
			"C:\\Users\\Felipe\\eclipse-workspace\\Library\\src\\main\\java\\com\\solvd\\library\\reader\\output.txt");
	private static ArrayList<String> arrayOutput = new ArrayList<>();

	public static void main(String[] arg) throws IOException {
		String fileAsString = FileUtils.readFileToString(file1, StandardCharsets.UTF_8);
		String[] fileAsStrArray = StringUtils.split(fileAsString);

		for (int i = 0; i < fileAsStrArray.length; i++) {
			int n = StringUtils.countMatches(fileAsString, fileAsStrArray[i]);
			String str = fileAsStrArray[i] + "__" + n;
			arrayOutput.add(str);
		}
		FileUtils.writeLines(outputFile, arrayOutput);
	}
}
