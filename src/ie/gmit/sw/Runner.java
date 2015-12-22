package ie.gmit.sw;

public class Runner {
	
	public static void main(String[] args) {
		IgnoredWords ignoredWords = new IgnoredWords();
		WordMap wordMap = new WordMap();
		
		Parser parser = new Parser(ignoredWords, wordMap);
		
	}

}
