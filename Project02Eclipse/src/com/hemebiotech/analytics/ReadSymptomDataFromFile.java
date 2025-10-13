package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation of ISymptomReader.
 * 
 * Reads data from a file and return a List of Strings which are the symptoms.
 * List is not sorted and may contain duplications. 
 * 
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filePath;

	/**
	 * Gives a path toward the file. 
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line.
	 */
	public ReadSymptomDataFromFile(String filePath) {
		this.filePath = filePath;
	}

	/**
	 * Reads the symptoms from a given file.
	 * 
	 * if an IOException occurs, the stack trace is printed
	 * 
	 * @return a List of Strings which are the symptoms. 
	 * 
	 */
	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filePath != null) {
			try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
