// James Wilfong, Brad Zust 
// Lab07st.java
// Student Version

import java.awt.*;
import java.applet.*;
import java.util.*; 
															
public class Lab07st extends Applet
{	
	public void paint(Graphics g) 	
	{	
	    Background.drawWall(g);
	    Background.drawFloor(g);
	    Couch.drawBack(g);
	    Couch.drawSeat(g);
	    Couch.drawArms(g);
	    Couch.drawLegs(g);
	    Lamp.drawBase(g);
	    Lamp.drawPole(g);
	    Lamp.drawShade(g);
	    Table.drawTable(g);
	    Clock.drawClock(g);
	    Tv.drawTv(g);
	    Tvstand.drawTvstand(g);
	    Tvscreen.drawScreen(g);
	}	
}
class Background
{
    public static void drawWall(Graphics g)
    {
        g.setColor(new Color(192,192,192));
        // silver
        g.fillRect(0,0,1000,325);
    }
    public static void drawFloor(Graphics g)
    {
        g.setColor(new Color(128,128,0));
        // olive
        g.fillRect(0,325,1000,325);
    }
}
class Couch
{
    public static void drawBack(Graphics g)
    {
        g.setColor (new Color(200,46,41));
        // salmon
        g.fillRect(325,225,175,75);
        g.fillRect(520,225,175,75);
        g.fillOval(510,225,25,75);
        g.fillOval(485,225,25,75);
        g.fillOval(312,225,25,75);
        g.fillOval(683,225,25,75);
    }
    public static void drawSeat(Graphics g)
    {
        g.setColor (new Color(210,46,41));
        //lighter salmon
        g.fillRect(312,300,395,75);
    }
    public static void drawArms(Graphics g)
    {
        g.setColor (new Color(190,46,41));
        //darker salmon
        g.fillRect(292,280,20,95);
        g.fillRect(707,280,20,95);    
    }
    public static void drawLegs(Graphics g)
    {
        g.setColor (new Color(32,32,32));
        //dark gray
        Polygon trap = new Polygon();
        trap.addPoint(292,375);
        trap.addPoint(297,380);
        trap.addPoint(307,380);
        trap.addPoint(312,375);
        g.fillPolygon(trap);
        
        g.setColor(new Color(32,32,32));
        //dark gray
        Polygon tra = new Polygon();
        tra.addPoint(707,375);
        tra.addPoint(712,380);
        tra.addPoint(722,380);
        tra.addPoint(727,375);
        g.fillPolygon(tra);
    }   
}
class Lamp
{
    public static void drawBase(Graphics g)
    {
         g.fillRect(35,325,40,5);
         g.setColor(Color.red);
    }
    public static void drawPole(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
		GradientPaint gp4 = new GradientPaint(25, 25, Color.white, 15, 25, Color.black, true);
		g2d.setPaint(gp4);
		g.fillRect(50,325,10,-175);
    }
    public static void drawShade(Graphics g)
    {
        g.setColor(Color.red);
        Polygon Lshade = new Polygon();
        Lshade.addPoint(25,200);
        Lshade.addPoint(85,200);
        Lshade.addPoint(70,150);
        Lshade.addPoint(40,150);
        Lshade.addPoint(25,200);
        g.fillPolygon(Lshade);
    }
}
class Table
{
    public static void drawTable(Graphics g)
    {
        Color Brown = new Color(153,76,1);
        g.setColor(Brown);
        g.fillRect(800,325,10,-50);
        g.fillRect(900,325,10,-50);
        g.fillRect(800,275,100,10);
    }
}
class Clock
{
    public static void drawClock(Graphics g)
    {
        //Red Base
        g.setColor(Color.red);
        g.fillOval(830,225,50,50);
        //White Face
        g.setColor(Color.white);
        g.fillOval(835,230,40,40);
        //12, 3, 6, and 9 O' clock notches + hands of clock
        g.setColor(Color.black);
        g.fillRect(853,230,5,10);
        g.fillRect(853,260,5,10);
        g.fillRect(835,248,10,5);
        g.fillRect(865,248,10,5);
        g.drawLine(855,250,850,235);
        g.drawLine(855,250,855,240);
        //gray bells
        Color DG = new Color(130,130,130);
        g.setColor(DG);
        g.fillOval(831,215,20,20);
        g.fillOval(859,215,20,20);
    }
}
class Tv
{
    public static void drawTv(Graphics g)
    {
        g.setColor(Color.black);
        g.fillRect(120,220,134,95);
        Polygon antenna1 = new Polygon();
        antenna1.addPoint(182,220);
        antenna1.addPoint(187,220);
        antenna1.addPoint(182,200);
        antenna1.addPoint(177,200);
        g.fillPolygon(antenna1);
        
        Polygon antenna2 = new Polygon();
        antenna2.addPoint(187,220);
        antenna2.addPoint(192,220);
        antenna2.addPoint(197,200);
        antenna2.addPoint(192,200);
        g.fillPolygon(antenna2);     
    }
}
class Tvstand
{
    public static void drawTvstand(Graphics g)
    {
        Color Brown = new Color(153,76,1);
        g.setColor(Brown);
        g.fillRect(115,300,15,76);
        g.fillRect(115,300,150,15);
        g.fillRect(250,300,15,76);
    }
}
class Tvscreen
{
    public static void drawScreen(Graphics g)
    {
        for (int c = 1; c <= 100000; c++)
	    {
	     for(int k = 1; k <= 100; k++)
	     {
	         int x1 = (int) (Math.random() * 112 + 130);
	         int y1 = (int) (Math.random() * 55 + 230);
	         int x2 = (int) (Math.random() * 112 + 130);
	         int y2 = (int) (Math.random() * 55 + 230);
	         int red = (int) (Math.random() * 256);
	         int green = red;
	         int blue = red; 
	         Color randomColor = new Color(red, green, blue);
	         g.setColor(randomColor);
	         g.drawLine(x1,y1,x2,y2);
	     }
	   }
    }
}
