package ie.gmit.sw.io;

import java.io.File;

public interface Parser {
	
	public void chooseFile();
	public void chooseUrl();
	public void parseText(File chosenFile);
}