package ie.gmit.sw.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

/*
 * IgnoredWords is a Treeset of words to ignore when parsing.
 * These are frequent;y used words like a, the and but.
 */
public class IgnoredWords {
	
	private TreeSet<String> wordsToIgnore;
	/*
	 * On creation the treeset is initialized and the filename is passe in to be parsed.
	 */
	public IgnoredWords(String filename) {
		wordsToIgnore = new TreeSet<String>();
		parse(filename);
	}
	
	/*
	 * Reading through the file line by line, ignoredwords takes each word to ignore and passes it in.
	 */
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
	
	/*
	 * Below is some delegate methods for adding and removing if needed.
	 */
	public void addWord(String word){
		if(!wordsToIgnore.contains(word)){
			wordsToIgnore.add(word);
		}else{
			System.out.println("Word already in list");
		}
	}
	
	public void removeWord(String word){
		if(wordsToIgnore.contains(word)){
			wordsToIgnore.remove(word);
		}else{
			System.out.println("Word not in list");
		}
	}
	
	public boolean contains(String word){
		return wordsToIgnore.contains(word);
	}
}
