package ie.gmit.sw.factory;

import ie.gmit.sw.io.WordMap;

public class WordMapFactory {

	private static WordMap map;
	
	private WordMapFactory(){}
	
	public static WordMap createWordMap(){
		map = new WordMap();
		
		return map;
	}
}
