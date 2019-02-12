package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ConversionFrame extends JFrame{

	public static void main(String[] args) {
		ConversionFrame frame = new ConversionFrame();
		frame.setTitle("Money Conversion");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.setVisible(true);
	}//end main

	//instance variables
	private JComboBox comboBox1;
	private JComboBox comboBox2;
	private JButton button1;
	private JTextField field1;
	private JLabel label1;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	//https://www.mkyong.com/java/java-display-double-in-2-decimal-points/
	private static DecimalFormat df = new DecimalFormat(".##");

	public ConversionFrame(){
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}//end ConversionFrame constructor

	//creates and adds components to a panel
	//then adds the panel to the frame
	private void createComponents(){

		field1 = new JTextField(12);

		comboBox1 = new JComboBox();
		comboBox1.addItem("USD");
		comboBox1.addItem("EUR");
		comboBox1.addItem("GBP");
		comboBox2 = new JComboBox();
		comboBox2.addItem("USD");
		comboBox2.addItem("EUR");
		comboBox2.addItem("GBP");

		button1 = new JButton("Convert");
		ActionListener listener = new ClickListener();
		button1.addActionListener(listener);

		label1 = new JLabel();

		JPanel panel = new JPanel();
		panel.add(field1);
		panel.add(comboBox1);
		panel.add(comboBox2);
		panel.add(button1);
		panel.add(label1);
		add(panel);
	}//end createComponents

	//once button is pressed, computes the result based on the
	//selections of each combo box
	class ClickListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(event.getSource() instanceof JButton){
				if(comboBox1.getSelectedItem().equals(comboBox2.getSelectedItem())){
					label1.setText("ERROR: Must choose different currencies.");
				}//end if
				else{
					double a = Double.parseDouble(field1.getText());
					if(comboBox1.getSelectedItem().equals("USD")&&comboBox2.getSelectedItem().equals("EUR")){
						a = a*.94;
						label1.setText(df.format(a));
					}//end if
					else if(comboBox1.getSelectedItem().equals("USD")&&comboBox2.getSelectedItem().equals("GBP")){
						a = a*.8;
						label1.setText(df.format(a));
					}//end else if
					else if(comboBox1.getSelectedItem().equals("EUR")&&comboBox2.getSelectedItem().equals("USD")){
						a = a*1.42;
						label1.setText(df.format(a));
					}//end else if
					else if(comboBox1.getSelectedItem().equals("EUR")&&comboBox2.getSelectedItem().equals("GBP")){
						a = a*.85;
						label1.setText(df.format(a));
					}//end else if
					else if(comboBox1.getSelectedItem().equals("GBP")&&comboBox2.getSelectedItem().equals("EUR")){
						a = a*1.13;
						label1.setText(df.format(a));
					}//end else if
					else if(comboBox1.getSelectedItem().equals("GBP")&&comboBox2.getSelectedItem().equals("USD")){
						a = a*1.64;
						label1.setText(df.format(a));
					}//end else if
				}//end else
			}//end if
		}//end actionPerformed
	}//end ClickListener inner class
}//end ConversionFrame class
