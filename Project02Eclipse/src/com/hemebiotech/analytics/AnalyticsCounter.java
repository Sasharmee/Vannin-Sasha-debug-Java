package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class AnalyticsCounter {
	
	private ISymptomReader reader;
	private ISymptomWriter writer;
	
	public AnalyticsCounter(ISymptomReader reader, ISymptomWriter writer) {
		this.reader = reader;
		this.writer = writer;
}

	public List<String> getSymptoms(){
		return reader.getSymptoms();
	
}

	public Map<String, Integer> countSymptoms(){
		Map<String, Integer> countSymptoms = new HashMap<String, Integer>(); 
		for(String symptom : getSymptoms()) { 
			int count = countSymptoms.getOrDefault(symptom, 0);
			countSymptoms.put(symptom, count +1);
	}
	return countSymptoms;
}
	

	public Map<String, Integer> sortSymptoms(Map<String, Integer>symptoms){
		return new TreeMap<String, Integer>(symptoms);
}
	

	public void writeSymptoms(Map<String, Integer> symptoms) {
		writer.writeSymptoms(symptoms);
}



	public static void main(String[] args) {
		
		

	}

}
