package ie.gmit.sw.test;

import org.junit.Test;
import static org.junit.Assert.*;

import ie.gmit.sw.factory.IgnoredWordFactory;
import ie.gmit.sw.factory.WordMapFactory;
import ie.gmit.sw.io.IgnoredWords;
import ie.gmit.sw.io.WordMap;

public class TestFactorys {
	
	private IgnoredWords ignoredWords;
	private WordMap wordMap;
	
	@Test
	public void testIgnoredWordsInstance(){
		ignoredWords = IgnoredWordFactory.createIgnoredWords("res/stopwords.txt");
		IgnoredWords ign = new IgnoredWords("res/stopwords.txt");
		
		assertTrue(ignoredWords != ign);
		assertFalse(ignoredWords == null);
	}
	
	@Test
	public void testWordMapInstance(){
		wordMap = WordMapFactory.createWordMap();
		WordMap wo = new WordMap();
		assertTrue(wordMap != wo);

		assertFalse(wordMap == null);
		
	}

}
