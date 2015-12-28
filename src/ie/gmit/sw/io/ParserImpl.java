package ie.gmit.sw.io;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class ParserImpl implements Parser {
	
	private String choice;
	private IgnoredWords ignoredWords;
	private WordMap wordMap;
	private volatile Elements[] all;
		
	public ParserImpl(IgnoredWords ignoredWords, WordMap wordMap) {	
		this.ignoredWords = ignoredWords;
		this.wordMap = wordMap;
		
		while(choice == null){
			choice = JOptionPane.showInputDialog("Enter if you want to parse a file or a url");

			if(choice.equalsIgnoreCase("file")){
				chooseFile();
			}else if(choice.equalsIgnoreCase("url")){
				chooseUrl();
			}else{
				System.out.println("Error: You must select either a file or url");
				choice = null;
				continue;
			}
		}
	}
	
	public void chooseFile(){
		System.out.println("Option Chosen: File");
		
		JFileChooser fileChooser = new JFileChooser();
		int returnedFile = fileChooser.showOpenDialog(null);
		
		if(returnedFile == JFileChooser.APPROVE_OPTION){
			File chosenFile = new File(""+fileChooser.getSelectedFile());
			parseText(chosenFile);
		}
	}
	
	//url still isn't parsing right
	public void chooseUrl(){
		System.out.println("Option Chosen: Url");
		
		File file = new File("UrlFile");
		PrintWriter ot = null;

		String url = JOptionPane.showInputDialog("Please enter in the url", "http://en.wikipedia.org/wiki/Big_data");
		try {
			Document doc = Jsoup.connect(url).get();
			System.out.println("Url title: " + doc.title());
						
			all = new Elements[10];
			all[0] = doc.select("p");
			all[1] = doc.select("a");
			all[2] = doc.select("span");
			all[3] = doc.select("h1");
			all[4] = doc.select("h2");
			all[5] = doc.select("h3");
						
			ot = new PrintWriter(file);

			for(Elements e : all){
				if(e == null)
					break;
				ot.write(e.toString());
			}
			
			ot.close();
		} catch (IOException e) {
			e.printStackTrace();
		}catch(NullPointerException ne){
			ne.printStackTrace();
		}
		
		parseText(file);		
	}
	
	public void parseText(File chosenFile) {
		System.out.println("Now parsing file");
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(chosenFile)));
			String line;
			while((line = br.readLine()) != null){
				String[] split = line.toLowerCase().replaceAll("[^a-zA-Z']", " ").replace("&nbsp", "").split("\\s");//strip specials and return words
				for(String s: split){
					int frequency = 0;
					if(!ignoredWords.contains(s) && !s.equals("") && s.length() >= 2){

						if(wordMap.contains(s)){
							frequency = wordMap.get(s);
						}
						
						frequency++;
						wordMap.addWord(s, frequency);
					}
				}
			}
			//wordMap.printMap();
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			//e.printStackTrace();
		}
	}
}
