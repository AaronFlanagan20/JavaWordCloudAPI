package ie.gmit.sw.utils;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class WordMap{
	
	private HashMap<String, Integer> wordMap;
	
	public WordMap() {
		wordMap = new HashMap<String, Integer>();
	}
	
	public void addWord(String word, int frequency){
		wordMap.put(word, frequency);
	}
	
	public void removeWord(String word){
		if(wordMap.containsKey(word)){
			wordMap.remove(word);
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
