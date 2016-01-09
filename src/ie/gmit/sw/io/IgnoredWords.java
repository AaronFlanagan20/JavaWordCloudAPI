package ie.gmit.sw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

import javax.swing.JFileChooser;

/*
 * IgnoredWords is a Treeset of words to ignore when parsing.
 * These are frequent;y used words like a, the and but.
 */
public class IgnoredWords {
	
	private TreeSet<String> wordsToIgnore;
	private String filename;
	/*
	 * On creation the treeset is initialized a filechooser is opened and the filename is passed in to be parsed.
	 */
	public IgnoredWords() {
		wordsToIgnore = new TreeSet<String>();
		chooseFile();
		parse(filename);
	}
	
	/*
	 * Choose a file to be passed in for parsing
	 */
	private String chooseFile(){
		JFileChooser fileChooser = new JFileChooser();
		int returnedFile = fileChooser.showOpenDialog(null);
		File chosenFile;
		
		if(returnedFile == JFileChooser.APPROVE_OPTION){
			chosenFile = new File(""+fileChooser.getSelectedFile());
			filename = chosenFile.getPath();
			System.out.println(filename);
		}
		return filename;
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
