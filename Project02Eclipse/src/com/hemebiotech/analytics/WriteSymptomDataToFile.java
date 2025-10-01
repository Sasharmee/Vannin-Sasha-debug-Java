package com.hemebiotech.analytics;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class WriteSymptomDataToFile implements ISymptomWriter {

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		
		try(BufferedWriter writer = new BufferedWriter(new FileWriter("result.out"))){
			for(Map.Entry<String, Integer> Symptoms : symptoms.entrySet()) {
				writer.write(Symptoms.getKey() + " : " + Symptoms.getValue());
			}
				
		}
		catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
	}
}
