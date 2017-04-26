package com.vcompany.app.word_counter;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {

	private BufferedReader bufferedReader;

	public String readFile(String path) {
		try {
			bufferedReader = new BufferedReader(new FileReader(path));
			StringBuilder stringBuilder = new StringBuilder();
			String line = bufferedReader.readLine();

			while (line != null) {
				stringBuilder.append(line);
				stringBuilder.append(" ");
				line = bufferedReader.readLine();
			}
			bufferedReader.close();
			return stringBuilder.toString();
		} catch (IOException e) {
			return null;
		}
		
	}
}
