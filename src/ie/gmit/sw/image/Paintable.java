package ie.gmit.sw.image;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ie.gmit.sw.io.WordMap;

public interface Paintable {

	/*
	 * Step 1 Strip most frequent words and store them.
	 */
	void getMostFrequent(WordMap wordMap);

	/*
	 * Step 2: Sort these words by frequency.
	 */
	void sortEntries(Map<String, Integer> entries);

	/*
	 * Step 3: Take the words and paint them in to a word cloud image to be outputted.
	 */
	void paint(List<Entry<String, Integer>> sortedValues);

}