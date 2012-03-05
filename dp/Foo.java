package dp;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Foo extends JPanel 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	BufferedImage buffer;
	int x1, x2, y1, y2;

	//Machade³ko
	@Override
	    public void paintComponent(Graphics g) 
	 {
		 Graphics2D g2d = (Graphics2D) g;       
	        g2d.setColor(Color.white);
	        g2d.fillRect(0, 0, 800, 600);
	        g2d.setPaint(Color.black);
	        g2d.drawLine(330, 220, x1, y1);
	        g2d.drawLine(x1, y1, x2, y2);
	        g2d.setPaint(Color.GREEN);
	        g2d.fillOval(x1-10, y1-10, 20, 20);
	        g2d.setPaint(Color.YELLOW);
	        g2d.fillOval(x2-10, y2-10, 20, 20);
	    }
	public void setCoord(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1;
		this.y1 = y1;
		this.x2 = x2;
		this.y2 = y2;
	}
	    
}
