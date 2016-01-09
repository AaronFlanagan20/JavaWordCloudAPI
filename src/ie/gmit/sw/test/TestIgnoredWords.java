package ie.gmit.sw.test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import org.junit.*;

import ie.gmit.sw.io.IgnoredWords;

public class TestIgnoredWords {
		
	private IgnoredWords ignoredWords;
	
	@Before
	public void setup(){
		ignoredWords = new IgnoredWords();
	}
	
	@After
	public void finish(){
		ignoredWords = null;
	}

	@Test(expected = NullPointerException.class)
	public void testAddingNullToList(){
		ignoredWords.addWord(null);
	}
	
	@Test
	public void testAddWordToList(){
		String word = "hello";
		ignoredWords.addWord(word);
		assertNotNull(word, ignoredWords.contains(word));
	}
	
	@Test
	public void testAddWordListHas(){
		ignoredWords.addWord("the");//reponds via command prompt
	}
	
	@Test
	public void testRemoveWordFromList(){
		ignoredWords.removeWord("a");
		assertFalse(ignoredWords.contains("a"));
	}
	
	@Test
	public void testRemoveWordNotInList(){
		ignoredWords.removeWord("assignment");//reponds via command prompt
		assertFalse(ignoredWords.contains("assignment"));
	}

}
