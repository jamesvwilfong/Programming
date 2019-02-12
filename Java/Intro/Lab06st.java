// James Wilfong
// Lab06st.java
// Student Version

import java.awt.*;
import java.applet.*;
import java.util.*; 
import java.awt.GradientPaint;
import java.awt.Graphics2D;																

public class Lab06st extends Applet
{
	public void paint(Graphics g) 	
	{
		// Draw Grid
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp4 = new GradientPaint(25, 25, Color.white, 15, 25, Color.black, true);
		g2d.setPaint(gp4); g2d.fillRect(10,10,780,580);
		g.drawLine(400,10,400,590);
		g.drawLine(10,300,790,300);
		// Draw Random Lines
		for(int c = 1; c <= 10000; c++)
		{
		for(int k = 1; k <= 100; k++)
		{
		    int x1 = (int) (Math.random() * 390 + 10);
		    int y1 = (int) (Math.random() * 290 + 10);
		    int x2 = (int) (Math.random() * 390 + 10);
		    int y2 = (int) (Math.random() * 290 + 10);
		    int red = (int) (Math.random() * 256);
		    int green = (int) (Math.random() * 256);
		    int blue = (int) (Math.random() * 256);
		    Color randomColor = new Color(red, green, blue);
		    g.setColor(randomColor);
		    g.drawLine(x1,y1,x2,y2); 
	    }
	    // Draw Random Squares
	    for(int k=1; k <= 100; k++)
	    {
	        int x3 = (int) (Math.random() * 340 + 400);
	        int y3 = (int) (Math.random() * 240 + 10);
	        int x4 = 50;
	        int y4 = 50;
	        int red = (int) (Math.random() * 256);
		    int green = (int) (Math.random() * 256);
		    int blue = (int) (Math.random() * 256);
	        Color randomColor = new Color(red, green, blue);
	        g.setColor(randomColor);
	        g.fillRect(x3,y3,x4,y4);
	    }
        // Draw Random Circles
        for(int k=1; k <= 100; k++)
        {
            int x6 = (int) (Math.random() * 201);
            int y6 = x6;
            int x5 = (int) (Math.random() * (390-x6) + 10);
            int y5 = (int) (Math.random() * (290-y6) + 300);
            int red = (int) (Math.random() * 256);
		    int green = (int) (Math.random() * 256);
		    int blue = (int) (Math.random() * 256);
	        Color randomColor = new Color(red, green, blue);
	        g.setColor(randomColor);
	        g.fillOval(x5,y5,x6,y6);
	    }
        // Draw 3-D Box
        Polygon poly = new Polygon();
        poly.addPoint(541,350);
        poly.addPoint(541,450);
        poly.addPoint(591,500);
        poly.addPoint(591,400);
        g.setColor(Color.green);
        g.fillPolygon(poly);
        
        Polygon trap = new Polygon();
        trap.addPoint(541,350);
        trap.addPoint(591,400);
        trap.addPoint(641,400);
        trap.addPoint(641,350);
        g.setColor(Color.yellow);
        g.fillPolygon(trap);
        
        Polygon tri = new Polygon();
        tri.addPoint(641,350);
        tri.addPoint(641,400);
        tri.addPoint(691,400);
        g.setColor(Color.blue);
        g.fillPolygon(tri);
        
        Polygon sq = new Polygon();
        sq.addPoint(691,400);
        sq.addPoint(691,500);
        sq.addPoint(591,500);
        sq.addPoint(591,400);
        g.setColor(Color.red);
        g.fillPolygon(sq);
	}
}
}
