package Shape;

import java.awt.Color;
import java.awt.Graphics2D;

public class Rectangle extends Shape {
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int getArea() {
		return height * width;
	}

	public int getPerimiter() {
		return height * 2 + width * 2;
	}

	@Override
	public void draw(Graphics2D g) {
		Color saveColor = g.getColor();
		if (this.fillColor != null) {
			g.setColor(this.fillColor);
			g.fillRect(super.x, super.y, this.width, this.height);
//			g.drawRect(super.x, super.y, this.width, this.height);
		}
		if (this.frameColor != null) {
			g.setColor(this.frameColor);
			g.drawRect(super.x, super.y, this.width, this.height);
		}
		g.setColor(saveColor);
	}

	@Override
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}

	@Override
	boolean pick(int x, int y) {
		int dx = x - this.x;
		int dy = y - this.y;

		return (dx >= 0 && dy >= 0 && dx <= this.width && dy < this.height);
	}

}
