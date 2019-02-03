package Shape;

import java.awt.Color;
import java.awt.Graphics2D;

public class Circle extends Shape {
	protected int r;

	public Circle(int r) {
		super(0, 0);
		this.r = r;
	}

	public Circle(int x1, int y1, int r) {
		super(x1, y1);
		this.r = r;
	}

	@Override
	public void draw(Graphics2D g) {
		Color saveColor = g.getColor();
		g.setColor(fillColor);
		g.fillOval(this.x, this.y, 2 * this.r, 2 * this.r);
		g.setColor(this.frameColor);
		g.drawOval(this.x, this.y, 2 * this.r, 2 * this.r);
		g.setColor(saveColor);
	}

	@Override
	public boolean pick(int x, int y) {
		int dx = x - (this.x + this.r);
		int dy = y - (this.y + this.r);
		return (dx * dx + dy * dy) <= this.r * this.r;
	}

}
