package Shapes;

import java.awt.Color;
import java.awt.Graphics2D;

public class Line extends Shape {
	protected int x;
	protected int y;

	public Line(int x1, int y1, int x2, int y2) {
		super(x1, y1);
		this.x = x2;
		this.y = y2;
	}

	public Color getColor() {
		return this.frameColor;
	}

	public double getLength() {
		return 70;
	}

	public void setColor(Color c) {
		this.frameColor = c;
	}

	@Override
	public void draw(Graphics2D g) {
		g.setColor(this.frameColor);
		g.drawLine(super.x, super.y, this.x, this.y);
	}

	@Override
	public boolean pick(int x, int y) {
		return false;
	}

	@Override
	public void move(int dx, int dy) {
		super.move(dx, dy);
		this.x += dx;
		this.y += dy;
	}

//	@Override
//	public String toString() {
//		return "The first point : " + p1.toString() + "\n" + "The second point : " + p2.toString() + "\n"
//				+ "The length : " + getLength();
//	}

}
