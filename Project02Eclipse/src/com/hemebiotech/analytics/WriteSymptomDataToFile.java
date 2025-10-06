package com.hemebiotech.analytics;

import java.util.HashMap;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;


public class WriteSymptomDataToFile implements ISymptomWriter {

	private String filepath;
	
	public WriteSymptomDataToFile(String filepath) {
		this.filepath=filepath;
	}

	@Override
	public void writeSymptoms(Map<String, Integer> symptoms) {
		try(BufferedWriter writer = new BufferedWriter(new FileWriter(filepath))){
			for(HashMap.Entry<String, Integer> Symptoms : symptoms.entrySet()) { 
				writer.write(Symptoms.getKey() + " : " + Symptoms.getValue());
				writer.newLine(); //revenir à la ligne
			}
				
		}
		catch(IOException e) { //exception In/Out avec fileWriter
			e.printStackTrace(); //affiche le message d'erreur dans la console 
		}
		
	}
}


//HashMap au lieu de Map