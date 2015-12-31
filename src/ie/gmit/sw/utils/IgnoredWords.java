package ie.gmit.sw.utils;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class IgnoredWords {
	
	private TreeSet<String> wordsToIgnore;
	
	public IgnoredWords(String filename) {
		wordsToIgnore = new TreeSet<String>();
		parse(filename);
	}
	
	private void parse(String fileName){
		BufferedReader br;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
			String line;
			while((line = br.readLine()) != null){
				if(!wordsToIgnore.contains(line)){
					wordsToIgnore.add(line);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void addWord(String word){
		if(!wordsToIgnore.contains(word))
			wordsToIgnore.add(word);
	}
	
	public void removeWord(String word){
		if(wordsToIgnore.contains(word))
			wordsToIgnore.remove(word);
	}
	
	public boolean contains(String word){
		return wordsToIgnore.contains(word);
	}
}
