package ie.gmit.sw.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import ie.gmit.sw.utils.IgnoredWords;
import ie.gmit.sw.utils.WordMap;

public class PaintWordCloud {
	
	private IgnoredWords ignoredWords;
	private WordMap wordMap;
	private BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);

	
	public PaintWordCloud(IgnoredWords ignoredWords, WordMap wordMap) {
		this.ignoredWords = ignoredWords;
		this.wordMap = wordMap;
		
		paint(ignoredWords, wordMap);
	}
	
	private void paint(IgnoredWords ignoredWords, WordMap wordMap) {
		Graphics graphics = image.getGraphics();
		Font font;
		
		Map.Entry<String, Integer> maxEntry = null;
		
		if(!wordMap.isEmpty()){
			for (Map.Entry<String, Integer> entry : wordMap.entrySet())
			{
			    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
			    	maxEntry = entry;
			    	
			    	if(maxEntry.getValue() >= 50000 && maxEntry.getValue() >= 40000){
						System.out.println("once " + maxEntry);
						font = new Font(Font.SANS_SERIF, Font.BOLD, 62);
						graphics.setColor(Color.blue);
						graphics.setFont(font);
						graphics.drawString(maxEntry.getKey(), 0, 100);
					}
			    	
					if(maxEntry.getValue() <= 39999 && maxEntry.getValue() >= 24000){
						System.out.println("twice " + maxEntry);
						font = new Font(Font.MONOSPACED, Font.ITALIC, 54);
						graphics.setColor(Color.green);
						graphics.setFont(font);
						graphics.drawString(maxEntry.getKey(), 0, 150);
					}
					
					if(maxEntry.getValue() <= 5 && maxEntry.getValue() >= 1){
						font = new Font(Font.MONOSPACED, Font.ITALIC, 32);
						graphics.setColor(Color.yellow);
						graphics.setFont(font);
						graphics.drawString(maxEntry.getKey(), 0, 200);
					}
					
					wordMap.removeWord(maxEntry.getKey());
			    }
			}
		}	
		try {
			graphics.dispose();
			ImageIO.write(image, "png", new File("image.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Your word cloud has been generated..");
	}
}
