package Shape;

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
		double x1 = super.x - x;
		double y1 = super.y - y;
		double x2 = this.x - x;
		double y2 = this.y - y;
		double r = 3;

		// Checking whether one of the
		if (x1 * x1 + y1 * y1 <= r * r)
			return true;
		if (x2 * x2 + y2 * y2 <= r * r)
			return true;

		double dx = x2 - x1;
		double dy = y2 - y1;
		double a = dx * dx + dy * dy;
		double b = 2 * (x1 * dx + y1 * dy);
		double c = x1 * x1 + y1 * y1 - r * r;

		double d = b * b - 4 * a * c;
		if (d < 0)
			return false;

		double t = -b - Math.sqrt(d) / (2 * a);

		return t >= 0 && t <= 1;
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
