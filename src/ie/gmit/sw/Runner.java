package ie.gmit.sw;

import ie.gmit.sw.factory.IgnoredWordFactory;
import ie.gmit.sw.factory.WordMapFactory;
import ie.gmit.sw.image.PaintWordCloud;
import ie.gmit.sw.image.Paintable;
import ie.gmit.sw.io.*;
/*
 * Runner class just starts everything up and ceates the objects.
 */
public class Runner {
	
	public static void main(String[] args) {
				
		WordMap wordMap = WordMapFactory.createWordMap();
		IgnoredWords ignoredWords = IgnoredWordFactory.createIgnoredWords();//use when running an ant build
		
		Parser parser = new ParserImpl(ignoredWords, wordMap);
		Paintable paintWordCloud = new PaintWordCloud(wordMap);
		
	}

}
