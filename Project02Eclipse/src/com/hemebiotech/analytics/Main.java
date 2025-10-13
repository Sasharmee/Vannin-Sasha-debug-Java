package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.TreeMap;

/**
 * Entry point of the application.
 * 
 * This class initializes the components needed to read symptom data, count and
 * sort symptoms by occurrence, and write the results to a file.
 */
public class Main {

	/**
	 * Main method which orchestrates the reading, counting, sorting, and writing of
	 * symptom data.
	 * 
	 * @param args command line arguments (not used).
	 */
	public static void main(String[] args) {

		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out");
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);

		List<String> symptoms = reader.getSymptoms();

		HashMap<String, Integer> countSymptoms = counter.countSymptoms(symptoms);

		TreeMap<String, Integer> sortSymptoms = counter.sortSymptoms(countSymptoms);

		writer.writeSymptoms(sortSymptoms);

	}

}
