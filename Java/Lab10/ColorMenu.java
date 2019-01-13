package edu.miamioh.wilfonjv;
//James Wilfong
//Dr. Stephan
//CSE 271, Section C
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class ColorMenu extends JFrame{

	public static void main(String[] args) {
		ColorMenu frame = new ColorMenu();
		frame.setTitle("Color Menu");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setVisible(true);
	}//end main
	
	//instance variables
	private JMenuBar menuBar;
	private JMenu colorMenu;
	private JMenuItem red;
	private JMenuItem green;
	private JMenuItem blue;
	private Color colorName;
	private JPanel panel;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	
	public ColorMenu(){
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}//end ColorMenu constructor
	
	//creates and adds components to frame
	private void createComponents(){
		menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		colorMenu = new JMenu("Color");
		menuBar.add(colorMenu);
		red = new JMenuItem("Red");
		ActionListener listener = new ColorListener(Color.RED);
		red.addActionListener(listener);
		green = new JMenuItem("Green");
		ActionListener listener1 = new ColorListener(Color.GREEN);
		green.addActionListener(listener1);
		blue = new JMenuItem("Blue");
		ActionListener listener2 = new ColorListener(Color.BLUE);
		blue.addActionListener(listener2);
		colorMenu.add(blue);
		colorMenu.add(red);
		colorMenu.add(green);
		colorName = Color.RED;
		
		panel = new JPanel();
		panel.setBackground(colorName);
		MouseListener listener3 = new MyMouseListener();
		panel.addMouseListener(listener3);
		add(panel);
	}//end createComponents
	
	//controls the color of the panel based on which menu
	//item is selected
	class ColorListener implements ActionListener{
		
		private Color color;
		
		public ColorListener(Color newColor){
			color = newColor;
		}//end ColorListener constructor
		public void actionPerformed(ActionEvent event){
			colorName = color;
			setPanelColor();
		}//end actionPerformed
	}//end ColorListener inner class
	
	public void setPanelColor(){
		panel.setBackground(colorName);
	}//end setPanelColor

	//cycles the color of the panel when mouse is clicked
	public class MyMouseListener implements MouseListener{

		public void mouseClicked(MouseEvent e) {
			if(colorName.equals(Color.RED)){
				panel.setBackground(Color.GREEN);
				colorName = Color.GREEN;
			}//end if
			else if(colorName.equals(Color.GREEN)){
				panel.setBackground(Color.BLUE);
				colorName = Color.BLUE;
			}//end else if
			else if(colorName.equals(Color.BLUE)){
				panel.setBackground(Color.RED);
				colorName = Color.RED;
			}//end else if
		}//end mouseClicked
		//DO-NOTHING Method stubs
		public void mouseEntered(MouseEvent e) {
		}
		public void mouseExited(MouseEvent e) {
		}
		public void mousePressed(MouseEvent e) {
		}
		public void mouseReleased(MouseEvent e) {
		}
	}//end MyMouseListener inner class
}//end ColorMenu class
