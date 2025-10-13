package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map.Entry;
import java.util.TreeMap;


/**
 * Simple brute force implementation of ISymptomWriter
 * 
 * Writes symptoms data from a TreeMap to a file sorted in alphabetic order
 * The file will contains the symptoms with their occurrences in the format :"symptoms : occurrence"
 */
public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filePath;

	/**
	 * Gives a path toward the file. 
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it, one per line.
	 */
	public WriteSymptomDataToFile(String filePath) {
		this.filePath = filePath;
	}
	
	/**
	 * Writes the given TreeMap symptoms in a file.
	 * 
	 * The TreeMap contains String which are the symptoms and Integers which are their occurrences
	 * The symptoms and occurrences are written line per line 
	 * The symptoms are sorted alphabetically
	 * 
	 * if an IOException occurs, the stack trace is printed
	 * 
	 * @param the TreeMap symptoms contains symptoms and their occurrences
	 */
	@Override
	public void writeSymptoms(TreeMap<String, Integer> symptoms) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
			for (Entry<String, Integer> symptomEntry : symptoms.entrySet()) {
				writer.write(symptomEntry.getKey() + " : " + symptomEntry.getValue());
				writer.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
