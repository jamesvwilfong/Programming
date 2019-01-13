
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import javax.swing.JComponent;
import javax.swing.JFrame;

public class OlympicRings {

    public static void main(String[] args) {

        JFrame frame = new JFrame();

        frame.setSize(500, 500);
        frame.setTitle("Olympic Rings");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent component = new RingComponent();
        frame.add(component);

        frame.setVisible(true);
    }//end main
}//end OlympicRings class
