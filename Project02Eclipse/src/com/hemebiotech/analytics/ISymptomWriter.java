package com.hemebiotech.analytics;

import java.util.TreeMap;

/**
 * Write symptoms data to a file from a Map
 * The Map contains Strings which are the symptoms and Integers which are their occurrences
 * The String in the Map are sorted alphabetically
 */
public interface ISymptomWriter {

	/**
	 * Writes in a TreeMap the symptoms and their occurrences line per line in a file
	 * Sorted alphabetically
	 * 
	 * @param The TreeMap symptoms contains Strings which are the symptoms and Integers which are their occurrences 
	 */
	void writeSymptoms(TreeMap<String, Integer> symptoms);

}
