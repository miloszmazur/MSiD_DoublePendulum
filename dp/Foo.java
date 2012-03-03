package dp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Foo extends JPanel 
{
	BufferedImage buffer;
	int w, h;
	Foo(int w, int h)
	{
		buffer = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
		
	}
	//TODO Ÿle. Nie rysuje, pewnie jakiœ g³upi b³¹d - popraw plz 0.o
	 @Override
	    public void paint(Graphics g) 
	 {
	        if(buffer!=null)
	        {
	            Graphics g2 = buffer.getGraphics();
	            g2.setColor(Color.blue);
	            g2.drawImage(buffer, 0, 0,Color.blue,this);
	            g2.drawLine(50, 50, 800, 600);
	            if(buffer.getWidth()!=getWidth()||buffer.getHeight()!=getHeight())
	            {
	                buffer = new BufferedImage(getWidth(),getHeight(),BufferedImage.TYPE_INT_RGB);
	            }
	        }
	    }
	    
}
