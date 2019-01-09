package Shape;

import java.awt.Dimension;

import javax.swing.JFrame;

public class Shapes_Main {

	public static void main(String[] args) {

		JFrame f1 = new JFrame();
		f1.setSize(new Dimension(1000, 800));
		f1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

//		CanvasPanel cp = new CanvasPanel();
		MyPanel mp = new MyPanel();
		f1.add(mp);
		f1.setVisible(true);
	}

}
