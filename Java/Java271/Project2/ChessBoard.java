package edu.miamioh.wilfonjv;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.Timer;

/**
 * @author James Wilfong
 * Dr. Stephan
 * CSE 271, Section C
 */
public class ChessBoard extends JFrame{

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ChessBoard frame = new ChessBoard();
		frame.setTitle("n-Queens problem");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setVisible(true);
	}//end main

	//instance variables
	private JButton tip;
	private JTextArea inputResponse;
	private ArrayList<JButton> boardSpaces = new ArrayList<JButton>();
	private ArrayList<Queen> positions = new ArrayList<Queen>();
	private JButton checkSolution;
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 400;
	private int b =0;
	private boolean a = true;

	/**
	 * ChessBoard constructor
	 */
	public ChessBoard(){
		createComponents();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
	}//end ChessBoard constructor

	/**
	 * creates the components of the chess board
	 */
	public void createComponents(){

		inputResponse = new JTextArea();
		inputResponse.setEditable(false);
		inputResponse.setColumns(10);
		inputResponse.setRows(10);
		inputResponse.setLineWrap(true);
		inputResponse.setWrapStyleWord(true);

		tip = new JButton("Tip");
		ActionListener listener2 =  new TipListener();
		tip.addActionListener(listener2);

		ActionListener listener3 = new TipListener2();
		Timer t = new Timer(100,listener3);
		t.start();

		checkSolution = new JButton("Check Solution");
		ActionListener listener = new CheckListener();
		checkSolution.addActionListener(listener);

		JPanel chessBoard = new JPanel();
		chessBoard.setLayout(new GridLayout(8, 8));
		for(int j=1;j<=8;j++){
			for(int i=1;i<=8;i++){
				if(a==true){
					if(i%2==0)
						chessBoard.add(magentaSpace());
					else
						chessBoard.add(pinkSpace());
				}//end if
				else{
					if(i%2==0)
						chessBoard.add(pinkSpace());
					else
						chessBoard.add(magentaSpace());
				}//end else
			}//end for loop
			if(a==true)
				a=false;
			else
				a=true;
		}//end for loop

		JPanel board2 = new JPanel();
		board2.setLayout(new GridLayout(1,2));
		board2.add(checkSolution);
		board2.add(tip);

		JPanel board = new JPanel();
		board.setLayout(new BorderLayout());
		board.add(board2, BorderLayout.SOUTH);
		board.add(inputResponse,BorderLayout.EAST);
		board.add(chessBoard, BorderLayout.CENTER);

		add(board);
	}//end createComponents

	/**
	 * @param obj Queen 
	 * @return the column that the Queen object is in based on it's
	 * x coordinate
	 */
	public int column(Queen obj){
		if(obj.getX()==0)
			return 1;
		else if(obj.getX()==48)
			return 2;
		else if(obj.getX()==96)
			return 3;
		else if(obj.getX()==144)
			return 4;
		else if(obj.getX()==192)
			return 5;
		else if(obj.getX()==240)
			return 6;
		else if(obj.getX()==288)
			return 7;
		else if(obj.getX()==336)
			return 8;
		else
			return 0;
	}//end column

	/**
	 * @param obj Queen
	 * @return the row that the Queen object is in based on it's
	 * y coordinate
	 */
	public int row(Queen obj){
		if(obj.getY()==0)
			return 1;
		else if(obj.getY()==43)
			return 2;
		else if(obj.getY()==86)
			return 3;
		else if(obj.getY()==129)
			return 4;
		else if(obj.getY()==172)
			return 5;
		else if(obj.getY()==215)
			return 6;
		else if(obj.getY()==258)
			return 7;
		else if(obj.getY()==301)
			return 8;
		else
			return 0;
	}//end row

	/**
	 * @return creates pink JButton board spaces
	 */
	private Component pinkSpace() {

		final JButton button = new JButton();
		ImageIcon empty = new ImageIcon();
		ImageIcon queen = new ImageIcon("images/queen.png");
		Image image = queen.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		queen = new ImageIcon(image);
		final ImageIcon icon = queen;

		button.setName("");
		button.setIcon(empty);
		button.setBackground(Color.PINK);
		button.setPreferredSize(new Dimension(40, 40));
		boardSpaces.add(button);

		/**
		 * ActionListener for pink JButton
		 * places queen Icon to pressed JButton if there is not one on the pressed JButton,
		 * and there are less than 8 queen Icons on the board
		 * Otherwise removes the queen Icon from the pressed JButton
		 */
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(button.getIcon().equals(empty)&&b<8){
					button.setIcon(icon);
					button.setBackground(Color.PINK);
					positions.add(new Queen(button.getX(),button.getY()));
					b++;
				}//end if
				else if(button.getIcon().equals(icon)){
					b--;
					Queen temp = new Queen(button.getX(),button.getY());
					for(int i = 0;i<positions.size();i++){
						if(positions.get(i).equals(temp))
							positions.remove(i);
					}//end for loop
					button.setIcon(empty); 
					button.setBackground(Color.PINK);
					button.repaint();
				}//end else if
			}//end actionPerformed
		}//end ClickListener class
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		return button;
	}//end pinkSpace 

	/**
	 * @return creates magenta JButton board spaces
	 */
	private Component magentaSpace() {

		final JButton button = new JButton();
		ImageIcon empty = new ImageIcon();
		ImageIcon queen = new ImageIcon("images/queen.png");
		Image image = queen.getImage().getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH);
		queen = new ImageIcon(image);
		final ImageIcon icon = queen;


		button.setName("");
		button.setIcon(empty);
		button.setBackground(Color.MAGENTA);
		button.setPreferredSize(new Dimension(40, 40));
		boardSpaces.add(button);

		/**
		 * ActionListener for magenta JButton
		 * places queen Icon to pressed JButton if there is not one on the pressed JButton,
		 * and there are less than 8 queen Icons on the board
		 * Otherwise removes the queen Icon from the pressed JButton
		 */
		class ClickListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if(button.getIcon().equals(empty)&&b<8){
					button.setIcon(icon);
					button.setBackground(Color.MAGENTA);
					positions.add(new Queen(button.getX(),button.getY()));
					b++;
				}//end if
				else if(button.getIcon().equals(icon)){
					b--;
					Queen temp = new Queen(button.getX(),button.getY());
					for(int i = 0;i<positions.size();i++){
						if(positions.get(i).equals(temp))
							positions.remove(i);
					}//end for loop
					button.setIcon(empty); 
					button.setBackground(Color.MAGENTA);
					button.repaint();
				}//end else if
			}//end actionPerformed
		} //end ClickListener class
		ActionListener listener = new ClickListener();
		button.addActionListener(listener);
		return button;
	}//end magentaSpace

	/**
	 * ActionListener attached to the "check solution" button
	 * that appends text to the textArea telling the user the location of
	 * queens that are in bad positions, and modifies the background color
	 * of the JButton board space containing a queen able to be attacked
	 * to Red.
	 */
	class CheckListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			inputResponse.setText("");
			for(int i=0;i<positions.size();i++){
				for(int j = i+1;j<positions.size();j++){
					if(positions.get(j).getX()==positions.get(i).getX()||
							positions.get(j).getY()==positions.get(i).getY()||
							Math.abs(row(positions.get(j))-row(positions.get(i)))==
							Math.abs(column(positions.get(j))-column(positions.get(i)))){
						inputResponse.append("Queen at Row "+ row(positions.get(j))+", Column "+ column(positions.get(j))+
								" can be hit by Queen at Row "+ row(positions.get(i))+", Column "+ column(positions.get(i))+".\n");
						for(int a=0;a<boardSpaces.size();a++){
							if(boardSpaces.get(a).getX()==positions.get(j).getX()&&boardSpaces.get(a).getY()==positions.get(j).getY())
								boardSpaces.get(a).setBackground(Color.RED);
						}//end for loop
					}//end if
				}//end for loop
			}//end for loop
		}//end actionPerformed
	}//end CheckListener class

	/**
	 * ActionListener attached to  the "Tip" button
	 * that looks at each board space until it finds one that
	 * can not be attacked by any queens placed on the board
	 * and changes that board space's background color to yellow
	 */
	class TipListener implements ActionListener{
		public void actionPerformed(ActionEvent event){
			for(int c = 0;c<boardSpaces.size();c++){
				boardSpaces.get(c).setName("");
			}//end for loop
			for(int i = 0;i<boardSpaces.size();i++){
				Queen  a = new Queen(boardSpaces.get(i).getX(),boardSpaces.get(i).getY());
				for(int j=0;j<positions.size();j++){
					if(boardSpaces.get(i).getX()==positions.get(j).getX()||boardSpaces.get(i).getY()==positions.get(j).getY()||
							Math.abs(row(positions.get(j))-row(a))==
							Math.abs(column(positions.get(j))-column(a)))
						boardSpaces.get(i).setName("Attackable");
				}//end for loop
			}//end for loop
			for(int b = 0;b<boardSpaces.size();b++){
				if(boardSpaces.get(b).getName().equals("Attackable"))
					continue;
				else{
					boardSpaces.get(b).setBackground(Color.YELLOW);
					break;
				}//end else
			}//end for loop
		}//end actionPerformed
	}//end TipListener class

	/**
	 * ActionListener that enables the "Tip" button when there are less than 8 queens
	 * place on the board, and disables the "Tip" button when there are 8 queens on
	 * the board. This is set to a 100 millisecond Timer.
	 */
	class TipListener2 implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(positions.size()>=8)
				tip.setEnabled(false);
			else
				tip.setEnabled(true);
		}//end actionPerformed
	}//end TipListener2 class
}//end ChessBoard class
