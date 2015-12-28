package ie.gmit.sw.image;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Map;
import java.util.Map.Entry;

import ie.gmit.sw.io.IgnoredWords;
import ie.gmit.sw.io.WordMap;

public class PaintWordCloud {
	
	private IgnoredWords ignoredWords;
	private WordMap wordMap;
	
	public PaintWordCloud(IgnoredWords ignoredWords, WordMap wordMap) {
		this.ignoredWords = ignoredWords;
		this.wordMap = wordMap;
		
		getMostFrequent(ignoredWords, wordMap);
	}
	
	private void getMostFrequent(IgnoredWords ignoredWords, WordMap wordMap) {
		Map.Entry<String, Integer> maxEntry = null;

		for (Map.Entry<String, Integer> entry : wordMap.entrySet())
		{
		    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
		    {
		        maxEntry = entry;
		        System.out.println(maxEntry);
		    }
		}
		
		paint(maxEntry);
	}

	private void paint(Entry<String, Integer> maxEntry) {
		 BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);
		 Graphics graphics = image.getGraphics();
		
	}
}
