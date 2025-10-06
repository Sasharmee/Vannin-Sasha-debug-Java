package com.hemebiotech.analytics;

import java.util.List;
import java.util.Map;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ISymptomReader reader = new ReadSymptomDataFromFile("symptoms.txt");
		ISymptomWriter writer = new WriteSymptomDataToFile("result.out"); 
		AnalyticsCounter counter = new AnalyticsCounter(reader, writer);
		
		List<String> symptoms = reader.getSymptoms();
		
		Map<String, Integer> countSymptoms = counter.countSymptoms(symptoms);
		
		Map<String, Integer> sortSymptoms = counter.sortSymptoms(countSymptoms);
		
		writer.writeSymptoms(sortSymptoms);
		
	}
	

}
