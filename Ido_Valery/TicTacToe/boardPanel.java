package TicTacToe;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import Shape.Circle;
import Shape.Line;

public class boardPanel extends JPanel implements MouseListener {
	private MyGrid grid;
	private static int counter = 0;
	private Graphics gr;

	public boardPanel() {
		super();
		grid = new MyGrid();
		this.addMouseListener(this);
	}

	@Override
	public void paintComponent(Graphics g) {
		gr = g;
		super.paintComponent(gr);
		Graphics2D g2 = (Graphics2D) gr;
		Line l1 = new Line(0, 0, 270, 270);
		Line l2 = new Line(0, 270, 270, 0);
		Circle c1 = new Circle(270, 0, 135);
		if (counter == 0)
			grid.draw(g2);
		else if (counter % 2 == 0) {
			grid.draw(g2);
			l1.draw(g2);
			System.out.println(".");
			l2.draw(g2);
			System.out.println(".");
		} else if (counter % 2 != 0) {
			grid.draw(g2);
			c1.draw(g2);
			System.out.println(".");
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		System.out.println(grid.pick(e.getX(), e.getY()));
		System.out.println(counter);
		this.repaint();
		System.out.println("Repainted");
		counter++;
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
