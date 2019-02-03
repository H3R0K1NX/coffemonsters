package TicTacToe;

import java.awt.Dimension;

import javax.swing.JFrame;

public class TicTacToe_Main {

	public static void main(String[] args) {
		JFrame f1 = new JFrame();
		f1.setSize(new Dimension(810, 810));
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		boardPanel b = new boardPanel();
		f1.add(b);
		f1.setVisible(true);

	}

}
