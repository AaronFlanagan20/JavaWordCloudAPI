package ie.gmit.sw.io;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;
/*
 * WordMap is hashmap mapping wors to there frequency.
 * Parserimpl will parse text and insert a word and frequency into our wordmap.
 */
public class WordMap{
	
	private HashMap<String, Integer> wordMap;
	
	public WordMap() {
		wordMap = new HashMap<String, Integer>();
	}
	
	public void addWord(String word, int frequency){
		if(!word.equals("") || word != null){
			wordMap.put(word, frequency);
		}
	}
	
	public void removeWord(String word){
		if(wordMap.containsKey(word)){
				wordMap.remove(word);
		}else{
			System.out.println("WordMap doesn't contain that word");
		}
	}
	
	public boolean contains(String word){
		return wordMap.containsKey(word);
	}
	
	public int get(String s){
		HashMap<String, Integer> copy = (HashMap<String, Integer>) wordMap.clone();
		return copy.get(s);
	}
		
	public Set<Entry<String, Integer>> entrySet() {
		HashMap<String, Integer> copy = (HashMap<String, Integer>) wordMap.clone();
		return copy.entrySet();
	}
	
	public boolean isEmpty(){
		return wordMap.isEmpty();
	}

	public void printMap(){
		for(String name: wordMap.keySet()){
			
            String key = name.toString();
            String value = wordMap.get(name).toString();  
            System.out.println(key + " " + value);  
		}
		System.out.println("Word cloud size is: " + wordMap.size());
	}
}
