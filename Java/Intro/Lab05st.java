// James Wilfong
// Lab05st.java
// This is the student, starting version of the Lab05 assignment.


import java.awt.*;
import java.applet.*;
import java.awt.GradientPaint;
import java.awt.Graphics2D;


public class Lab05st extends Applet
{
	public void paint(Graphics g)
	{
		int width = 980;
		int height = 630;
		int x1 = 10;
		int y1 = 640;
		int x2 = 990;
		int y2 = 640;
		Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp4 = new GradientPaint(25, 25, Color.white, 15, 25, Color.black, true);
		g2d.setPaint(gp4); g2d.fillRect(10,10,width,height);
		//Draw bottom-right corner
		for(x1 = 10; x1 <= 990;)
		{
		    g.setColor(Color.green); g.drawLine(x1,y1,x2,y2);
		    y2 -= 10;
		    x1 += 16;
		   }
		//Draw bottom-left corner
		int x3 = 990;
		int y3 = 640;
		int x4 = 10;
		int y4 = 640;
		for(x3 = 990; x3 >= 10;)
		{
		    g.setColor(Color.green); g.drawLine(x3,y3,x4,y4);
		    y4 -= 10;
		    x3 -= 16;
		}
		//Draw top-right corner
		int x5 = 10;
		int y5 = 10;
		int x6 = 990;
		int y6 = 10;
		for(x5 = 10; x5 <= 990;)
		{
		    g.setColor(Color.green); g.drawLine(x5,y5,x6,y6);
		    y6 += 10;
		    x5 += 16;
		}
		//Draw top-left corner
		int x7 = 990;
		int y7 = 10;
		int x8 = 10;
		int y8 = 10;
		for(x7 = 990; x7 >= 10;)
		{
		    g.setColor(Color.green); g.drawLine(x7,y7,x8,y8);
		    y8 += 10;
		    x7 -= 16;
		}
		//Draw small bottom-right corner
		int x9 = 248;
		int y9 = 483;
		int x10 = 750;
		int y10 = 483;
		g.setColor(Color.black); g.fillRect(248,168,502,315);
		for(x9 = 248; x9 <= 750;)
		{
		    g.setColor(Color.green); g.drawLine(x9,y9,x10,y10);
		    y10 -= 6;
		    x9 += 10;
		}
		//Draw small bottom-left corner
		int x11 = 750;
		int y11 = 483;
		int x12 = 248;
		int y12 = 483;
		for(x11 = 750; x11 >= 248;)
		{
		    g.setColor(Color.green); g.drawLine(x11,y11,x12,y12);
		    y12 -= 6;
		    x11 -= 10;
		}
		//Draw small top-right corner
		int x13 = 248;
		int y13 = 168;
		int x14 = 750;
		int y14 = 168;
		for(x13 = 248; x13 <= 750;)
		{
		    g.setColor(Color.green); g.drawLine(x13,y13,x14,y14);
		    y14 += 6;
		    x13 += 10;
		}
		//Draw small top-left corner
		int x15 = 750;
		int y15 = 168;
		int x16 = 248;
		int y16 = 168;
		for(x15 = 750; x15 >= 248;)
		{
		    g.setColor(Color.green); g.drawLine(x15,y15,x16,y16);
		    y16 += 6;
		    x15 -= 10;
		}
    }
}
