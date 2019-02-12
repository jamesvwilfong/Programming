// Lab04bst.java
// The AWT Graphics Program
// This is the student, starting version of Lab04b.


import java.awt.*;
import java.applet.*;


public class Lab04bst extends Applet
{

    public void paint(Graphics g)
    {
        // DRAW CUBE
        g.drawRect(30,30,225,225);
        g.drawLine(30,30,100,100);
        g.drawLine(255,30,325,100);
        g.drawLine(100,100,325,100);
        g.drawLine(30,255,100,325);
        g.drawLine(255,255,325,325);
        g.drawLine(100,325,325,325);
        g.drawLine(100,100,100,325);
        g.drawLine(325,325,325,100);
        // DRAW SPHERE
        g.drawOval(62,62,230,230);
        g.drawOval(62,153,230,50);
        g.drawOval(62,120,230,115);
        g.drawOval(62,90,230,175);
        g.drawOval(153,62,50,230);
        g.drawOval(120,62,115,230);
        g.drawOval(90,62,175,230);
        // DRAW INSCRIBED/CIRCUMSCRIBED TRIANGLE
        g.drawOval(750,375,200,200);
        g.drawLine(750,475,925,410);
        g.drawLine(925,410,845,575);
        g.drawLine(845,575,750,475);
        g.drawOval(786,448,93,93);
        // DRAW APCS
        g.fillRect(30,475,20,100);
        g.fillRect(30,475,60,20);
        g.fillRect(70,475,20,100);
        g.fillRect(30,515,60,20);
        
        g.fillRect(110,475,20,100);
        g.fillRect(110,475,60,20);
        g.fillRect(110,515,60,20);
        g.fillRect(150,475,20,50);
        
        g.fillRect(190,475,20,100);
        g.fillRect(190,475,60,20);
        g.fillRect(190,555,60,20);
        
        g.fillRect(270,475,20,60);
        g.fillRect(270,475,60,20);
        g.fillRect(270,515,60,20);
        g.fillRect(270,555,60,20);
        g.fillRect(310,515,20,60);
        // DRAW PACMEN FLOWER
        g.fillArc(345,325,90,90,225,270);
        g.fillArc(405,265,90,90,135,270);
        g.fillArc(465,325,90,90,45,270);
        g.fillArc(405,385,90,90,315,270);
        



    }
}
