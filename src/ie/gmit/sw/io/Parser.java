package ie.gmit.sw.io;

import java.io.File;

/*
 * Our interface Parser for any pbject that needs to parse files
 * It contains methods for choosing a file and url and parsing them
 */
public interface Parser {
	
	public void chooseFile();
	public void chooseUrl();
	public void parseText(File chosenFile);
}