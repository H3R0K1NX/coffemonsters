package Shapes;

import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

public class CanvasPanel extends JPanel {
	private Scene scene;

	public CanvasPanel() {
		super();
		scene = new Scene();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHints();
	}

}
