package ie.gmit.sw.factory;

import ie.gmit.sw.io.IgnoredWords;

public class IgnoredWordFactory {
	
	private static IgnoredWords ignoredWords;
	
	public static IgnoredWords createIgnoredWords(){
		ignoredWords = new IgnoredWords();
		
		return ignoredWords;
	}
}
