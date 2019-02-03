package Shape;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JPanel;

public class MyPanel extends JPanel implements MouseListener, MouseMotionListener {
	private int xStart, yStart;
	private Scene scene;
	private boolean drag;

	public MyPanel() {
		super();
		scene = new Scene();
		this.setPreferredSize(new Dimension(800, 800));
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		scene.draw(g2);
		this.repaint();
	}

	@Override
	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			xStart = e.getX();
			yStart = e.getY();
			drag = scene.pick(xStart, yStart);
			if (drag)
				this.repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		drag = false;
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (drag) {
			int dx = e.getX() - xStart;
			int dy = e.getY() - yStart;
			xStart = e.getX();
			yStart = e.getY();
			scene.move(dx, dy);
			this.repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}
