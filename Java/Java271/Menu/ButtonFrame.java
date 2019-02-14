
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ButtonFrame extends JFrame {

    public static void main(String[] args) {
        ButtonFrame frame = new ButtonFrame();
        frame.setTitle("Restaurant");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setVisible(true);
    }//end main

    // instance variables
    private JButton button;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button10;
    private JButton itemButton;
    private JButton totalButton;
    private JLabel label;
    private JLabel label2;
    private JLabel label3;
    private JLabel label4;
    private JLabel label5;
    private JLabel label6;
    private JLabel label7;
    private JLabel label8;
    private JLabel label9;
    private JLabel label10;
    private JLabel label11;
    private JLabel label12;
    private JTextArea order;
    private JTextField newItem;
    private JTextField newPrice;
    private double tip = 1.00;
    private double tax;
    private double total;
    private boolean finish = false;
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 400;

    public ButtonFrame() {
        this.createComponents();
        this.setSize(FRAME_WIDTH, FRAME_HEIGHT);
    }//end ButtonFrame constructor

    class ClickListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent event) {
            //if finish returns true, this means the order has been finished, 
            //preventing this code from adding anything else to the order
            if (ButtonFrame.this.finish == false) {
                if (event.getSource() instanceof MenuButton) {
                    MenuButton a = (MenuButton) event.getSource();
                    if (a.equals(ButtonFrame.this.itemButton)) {
                        //appends the price input from the user in the newPrice
                        // textField to the order textArea
                        ButtonFrame.this.order
                                .append(ButtonFrame.this.newItem.getText() + " "
                                        + ButtonFrame.this.newPrice.getText()
                                        + "\n");
                        ButtonFrame.this.total += Double.parseDouble(
                                ButtonFrame.this.newPrice.getText());
                    } //end if
                    else {
                        //appends the price of the item associated 
                        //with the MenuButton that was pressed
                        //to the order textArea
                        ButtonFrame.this.order.append(
                                (a.getItem()) + " " + (a.getPrice()) + "\n");
                        ButtonFrame.this.total += Double
                                .parseDouble(a.getPrice());
                    } //end else
                } //end if
                else {
                    ButtonFrame.this.tax = (ButtonFrame.this.total * 3) / 100.0;
                    ButtonFrame.this.total = ButtonFrame.this.total
                            + ButtonFrame.this.tax + ButtonFrame.this.tip;
                    ButtonFrame.this.order.append("Tax: $"
                            + Double.toString(ButtonFrame.this.tax) + "\n");
                    ButtonFrame.this.order.append("Tip: $"
                            + Double.toString(ButtonFrame.this.tip) + "\n");
                    ButtonFrame.this.order.append("Total: $"
                            + Double.toString(ButtonFrame.this.total));
                    ButtonFrame.this.finish = true;
                } //end else
            } //end if
        }//end actionPerformed
    }//end ClickListener class

    private void createComponents() {

        this.newItem = new JTextField(12);
        this.newPrice = new JTextField(12);

        this.order = new JTextArea();
        this.order.setEditable(false);
        this.order.setColumns(10);
        this.order.setRows(10);

        this.itemButton = new MenuButton("Added Item", this.newPrice.getText());
        ActionListener listener11 = new ClickListener();
        this.itemButton.addActionListener(listener11);

        this.totalButton = new JButton("Finish");
        ActionListener finishListener = new ClickListener();
        this.totalButton.addActionListener(finishListener);

        this.button = new MenuButton("Pizza", "10.00");
        ActionListener listener = new ClickListener();
        this.button.addActionListener(listener);

        this.button3 = new MenuButton("Grilled Cheese", "6.00");
        ActionListener listener3 = new ClickListener();
        this.button3.addActionListener(listener3);

        this.button4 = new MenuButton("Soda", "3.00");
        ActionListener listener4 = new ClickListener();
        this.button4.addActionListener(listener4);

        this.button5 = new MenuButton("Spaghetti", "9.00");
        ActionListener listener5 = new ClickListener();
        this.button5.addActionListener(listener5);

        this.button6 = new MenuButton("Hamburger", "7.00");
        ActionListener listener6 = new ClickListener();
        this.button6.addActionListener(listener6);

        this.button7 = new MenuButton("Hot Dog", "6.50");
        ActionListener listener7 = new ClickListener();
        this.button7.addActionListener(listener7);

        this.button8 = new MenuButton("Ice Cream", "3.50");
        ActionListener listener8 = new ClickListener();
        this.button8.addActionListener(listener8);

        this.button9 = new MenuButton("Cookie", "2.50");
        ActionListener listener9 = new ClickListener();
        this.button9.addActionListener(listener9);

        this.button10 = new MenuButton("Steak", "12.00");
        ActionListener listener10 = new ClickListener();
        this.button10.addActionListener(listener10);

        this.button2 = new MenuButton("Chicken", "8.00");
        ActionListener listener2 = new ClickListener();
        this.button2.addActionListener(listener2);

        this.label = new JLabel("$10.00");
        this.label2 = new JLabel("$8.00");
        this.label3 = new JLabel("$6.00");
        this.label4 = new JLabel("$3.00");
        this.label5 = new JLabel("$9.00");
        this.label6 = new JLabel("$7.00");
        this.label7 = new JLabel("$6.50");
        this.label8 = new JLabel("$3.50");
        this.label9 = new JLabel("$2.50");
        this.label10 = new JLabel("$12.00");
        this.label11 = new JLabel("Item:");
        this.label12 = new JLabel("Price:");

        JPanel panel = new JPanel();
        panel.add(this.button);
        panel.add(this.label);
        panel.add(this.button2);
        panel.add(this.label2);
        panel.add(this.button3);
        panel.add(this.label3);
        panel.add(this.button4);
        panel.add(this.label4);
        panel.add(this.button5);
        panel.add(this.label5);
        panel.add(this.button6);
        panel.add(this.label6);
        panel.add(this.button7);
        panel.add(this.label7);
        panel.add(this.button8);
        panel.add(this.label8);
        panel.add(this.button9);
        panel.add(this.label9);
        panel.add(this.button10);
        panel.add(this.label10);
        panel.add(this.label11);
        panel.add(this.newItem);
        panel.add(this.label12);
        panel.add(this.newPrice);
        panel.add(this.itemButton);
        panel.add(this.totalButton);
        panel.add(this.order);
        this.add(panel);
    }//end createComponents
}//end ButtonFrame class
