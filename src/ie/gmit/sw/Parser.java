package ie.gmit.sw;

import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Parser {
	
	private String choice;
		
	public Parser(IgnoredWords ignoredWords, WordMap wordMap) {
		ignoredWords = new IgnoredWords();
		wordMap = new WordMap();
				
		while(choice == null){
			choice = JOptionPane.showInputDialog("Enter if you want to parse a file or a url");

			if(choice.equalsIgnoreCase("file")){
				chooseFile();
			}else if(choice.equalsIgnoreCase("url")){
				chooseUrl();
				parseUrl();
			}else{
				System.out.println("Error: You must select either a file or url");
				choice = null;
				continue;
			}
		}
	}
	
	private void chooseFile(){
		System.out.println("Option Chosen: File");
		
		JFileChooser fileChooser = new JFileChooser();
		int returnedFile = fileChooser.showOpenDialog(null);
		
		if(returnedFile == JFileChooser.APPROVE_OPTION){
			File chosenFile = new File(""+fileChooser.getSelectedFile());
			parseFile(chosenFile);
		}
	}
	
	private void chooseUrl(){

	}
	
	private void parseFile(File chosenFile) {
		System.out.println("Now parsing file");
	}
	
	private void parseUrl() {
		
	}
}
