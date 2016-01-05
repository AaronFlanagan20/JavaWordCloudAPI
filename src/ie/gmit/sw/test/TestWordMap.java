package ie.gmit.sw.test;

import ie.gmit.sw.utils.WordMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import org.junit.*;

public class TestWordMap {
	
	private WordMap wordMap;
			
	@Before
	public void setup(){
		wordMap = new WordMap();
	}
	
	@After
	public void finish(){
		wordMap = null;
	}
	
	@Test
	public void testAddWord(){
		String word = "Hello";
		int frequency = 5;
		wordMap.addWord(word, frequency);
		assertEquals(frequency, wordMap.get(word));
	}
	
	@Test(expected = NullPointerException.class)
	public void testAddingNull(){
		wordMap.addWord(null, 5);
	}
	
	@Test
	public void testRemoveWord(){
		String word = "Hello";
		int frequency = 5;
		wordMap.addWord(word, frequency);
		
		wordMap.removeWord(word);
		assertFalse(wordMap.contains(word));
	}
	
	@Test
	public void testRemoveNull(){
		wordMap.removeWord(null);
	}
	

}
