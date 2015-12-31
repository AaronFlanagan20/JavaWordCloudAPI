package ie.gmit.sw;

import ie.gmit.sw.image.PaintWordCloud;
import ie.gmit.sw.utils.*;

public class Runner {
	
	public static void main(String[] args) {
		IgnoredWords ignoredWords = new IgnoredWords("res/stopwords.txt");//use when running in eclipse
		//IgnoredWords ignoredWords = new IgnoredWords("./stopwords.txt");//use when running from command prompt
		WordMap wordMap = new WordMap();
		
		Parser parser = new ParserImpl(ignoredWords, wordMap);
		PaintWordCloud paintWordCloud = new PaintWordCloud(ignoredWords, wordMap);
		
	}

}
