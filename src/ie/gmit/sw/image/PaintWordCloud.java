package ie.gmit.sw.image;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.imageio.ImageIO;

import ie.gmit.sw.io.WordMap;

/*
 * PaintWordCloud is a 3 step process.
 * 1. Strip out the most frequent words from the WordMap
 * 2. Take these words and sort tem be frequency 
 * 3. Paint the words into a cloud
 */
public class PaintWordCloud implements Paintable {
	
	@SuppressWarnings("unused")
	private WordMap wordMap;
	private BufferedImage image = new BufferedImage(600, 300, BufferedImage.TYPE_4BYTE_ABGR);

	public PaintWordCloud(WordMap wordMap) {
		this.wordMap = wordMap;
		
		getMostFrequent(wordMap);
	}
	
	/*
	 * Step 1 Strip most frequent words and store
	 */
	public void getMostFrequent(WordMap wordMap) {
		
		Map<String, Integer> entries = new HashMap<String, Integer>();
								
		if(!wordMap.isEmpty()){
			Map.Entry<String, Integer> maxEntry = null;
			for (Map.Entry<String, Integer> entry : wordMap.entrySet())
			{
			    if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0)
			    {
			    	maxEntry = entry;
			    	entries.put(maxEntry.getKey(), maxEntry.getValue());	    				    	
			    }
			}
		}
		
		sortEntries(entries);
	}
	
	/*
	 * Step 2: Sort these words by frequency
	 */
	public void sortEntries(Map<String, Integer> entries){
		
		Comparator<Map.Entry<String, Integer>> byMapValues = new Comparator<Map.Entry<String, Integer>>() {
	        public int compare(Map.Entry<String, Integer> left, Map.Entry<String, Integer> right) {
	            return left.getValue().compareTo(right.getValue());
	        }
	    };
		
		List<Map.Entry<String, Integer>> sortedValues = new ArrayList<Map.Entry<String, Integer>>();
	    
	    sortedValues.addAll((Collection<? extends Entry<String, Integer>>) entries.entrySet());
	 
	    Collections.sort(sortedValues, byMapValues);//sorts lowest to highest
	    Collections.reverse(sortedValues);//take sorted values and reverse
	    	    
	    paint(sortedValues);
	}
	
	/*
	 * Step 3: Take the words and paint them to an word cloud image to be outputted
	 */
	public void paint(List<Entry<String, Integer>> sortedValues){
		Graphics2D graphics = (Graphics2D) image.getGraphics();
		Font font;
		
		graphics.setColor(Color.WHITE);
		graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
		
		int loop = 0;
		
		while(loop <= 5){
			if(loop >= sortedValues.size())
				break;
			Map.Entry<String, Integer> entry = sortedValues.get(loop);
			
			if(loop == 0){
				font = new Font(Font.DIALOG_INPUT, Font.ITALIC, 100);
				graphics.setColor(Color.blue);
				graphics.setFont(font);
				graphics.drawString(entry.getKey(), 200, 100);
			}
			
			if(loop == 1){
				font = new Font(Font.SANS_SERIF, Font.ITALIC, 90);
				graphics.setColor(Color.green);
				graphics.setFont(font);
				graphics.drawString(entry.getKey(), 100, 220);
			}
			
			if(loop == 2){
				font = new Font(Font.MONOSPACED, Font.BOLD, 80);
				graphics.setColor(Color.red);
				graphics.setFont(font);
				graphics.drawString(entry.getKey(), 300, 220);
			}
			
			if(loop == 3){
				font = new Font(Font.SERIF, Font.ITALIC, 70);
				graphics.setColor(Color.yellow);
				graphics.setFont(font);
				graphics.drawString(entry.getKey(), 220, 155);
			}
			
			if(loop == 4){
				Graphics2D g2 = (Graphics2D) image.getGraphics();
				font = new Font(Font.SANS_SERIF, Font.BOLD, 60);
				g2.setColor(Color.cyan);
				g2.setFont(font);
				AffineTransform at = g2.getTransform();
				at.rotate(Math.PI / 2);
				g2.setTransform(at);
				g2.drawString(entry.getKey(), 30, -10);
				g2.dispose();
			}
			
			if(loop == 5){
				Graphics2D g2 = (Graphics2D) image.getGraphics();
				font = new Font(Font.MONOSPACED, Font.ITALIC, 40);
				g2.setColor(Color.black);
				g2.setFont(font);
				AffineTransform at = g2.getTransform();
				at.rotate(Math.PI / 4);
				g2.setTransform(at);
				g2.drawString(entry.getKey(), 295, -270);
				g2.dispose();
			}
			
			loop++;
		}
		
		try {
			graphics.dispose();
			ImageIO.write(image, "png", new File("wordcloud.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Your word cloud has been generated..");

	}
}
