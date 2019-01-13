
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JComponent;

public class RingComponent extends JComponent {

    @Override
    public void paintComponent(Graphics g) {
        this.drawRing(50, 50, Color.BLUE, g);
        this.drawRing(100, 50, Color.BLACK, g);
        this.drawRing(150, 50, Color.RED, g);
        this.drawRing(75, 75, Color.YELLOW, g);
        this.drawRing(125, 75, Color.GREEN, g);
    }//end paintComponent

    public void drawRing(int xPosition, int yPosition, Color a, Graphics g) {
        g.setColor(a);
        g.drawOval(xPosition, yPosition, 50, 50);
    }//end drawRing
}//end RingComponent class
