package ie.gmit.sw.io;

import ie.gmit.sw.image.PaintWordCloud;

public class Runner {
	
	public static void main(String[] args) {
		IgnoredWords ignoredWords = new IgnoredWords("res/stopwords.txt");
		WordMap wordMap = new WordMap();
		
		Parser parser = new ParserImpl(ignoredWords, wordMap);
		PaintWordCloud paintWordCloud = new PaintWordCloud(ignoredWords, wordMap);
		
	}

}
