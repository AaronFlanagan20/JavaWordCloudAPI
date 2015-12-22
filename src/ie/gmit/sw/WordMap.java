package ie.gmit.sw;

import java.util.HashMap;

public class WordMap {
	
	private HashMap<String, Integer> wordMap;
	
	public WordMap() {
		wordMap = new HashMap<String, Integer>();
	}
	
	public void addWord(String word, int frequency){
		if(!wordMap.containsKey(word)){
			wordMap.put(word, frequency);
		}
	}
	
	public void removeWord(String word){
		if(wordMap.containsKey(word)){
			wordMap.remove(word);
		}
	}
	
	public void printMap(){
		for (String name: wordMap.keySet()){

            String key =name.toString();
            String value = wordMap.get(name).toString();  
            System.out.println(key + " " + value);  
		}	
	}
}
