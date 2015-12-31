package ie.gmit.sw.utils;

import java.io.File;

public interface Parser {
	
	public void chooseFile();
	public void chooseUrl();
	public void parseText(File chosenFile);
}