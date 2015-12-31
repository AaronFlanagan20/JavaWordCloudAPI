package ie.gmit.sw.runner;

import ie.gmit.sw.image.PaintWordCloud;
import ie.gmit.sw.utils.*;

public class Runner {
	
	public static void main(String[] args) {
		IgnoredWords ignoredWords = new IgnoredWords("res/stopwords.txt");
		WordMap wordMap = new WordMap();
		
		Parser parser = new ParserImpl(ignoredWords, wordMap);
		PaintWordCloud paintWordCloud = new PaintWordCloud(ignoredWords, wordMap);
		
	}

}
