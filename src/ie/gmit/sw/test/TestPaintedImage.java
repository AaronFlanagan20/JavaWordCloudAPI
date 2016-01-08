package ie.gmit.sw.test;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import static org.junit.Assert.*;

import org.junit.Test;


public class TestPaintedImage {
	
	@Test
	public void testGeneratedImageNotNull() throws IOException{
		BufferedImage bufferedImage = ImageIO.read(new File("image.png"));
		
		assertNotNull(bufferedImage);
	}

}
