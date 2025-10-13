package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * This class reads data, counts and sorts occurrences and writes them on a new file
 */
public class AnalyticsCounter {

	private ISymptomReader reader;
	private ISymptomWriter writer;

	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
	}
	/**
	 * Gets the List of symptoms data thanks to the reader from ISymptomReader
	 * 
	 * @return a List of Strings which are the symptoms
	 */
	public List<String> getSymptoms() {
		return reader.getSymptoms();
	}
	
	/**
	 * Gets the Strings from the List symptoms.
	 * Counts the occurrences from the Strings which are symptoms in the List.
	 * Writes and associates the symptoms and their occurrences in an HashMap.
	 * 
	 * @param symptoms the List of Strings which are the symptoms.
	 * @return an HashMap of the symptoms associated with their occurrences.
	 */
	public HashMap<String, Integer> countSymptoms(List<String> symptoms) {
		HashMap<String, Integer> countSymptoms = new HashMap<String, Integer>();
		for (String symptom : getSymptoms()) {
			int count = countSymptoms.getOrDefault(symptom, 0);
			countSymptoms.put(symptom, count + 1);
		}
		return countSymptoms;
	}

	/**
	 * Gets symptoms an HashMap of Strings and Integers which are the symptoms and their occurrences
	 * Sorts the Strings in the TreeMap alphabetically
	 * 
	 * @param symptoms an HashMap of symptoms and their occurrences
	 * @return an alphabetically sorted TreeMap of symptoms and their occurrences 
	 */
	public TreeMap<String, Integer> sortSymptoms(HashMap<String, Integer> symptoms) {
		return new TreeMap<String, Integer>(symptoms);
	}
	 /**
	  * Writes the symptoms and their occurrences using ISymptomWriter
	  * 
	  * @param symptoms a sorted TreeMap of symptoms and their occurrences 
	  */
	public void writeSymptoms(TreeMap<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
	}

	public static void main(String[] args) {

	}

}
