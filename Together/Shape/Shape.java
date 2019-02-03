package Shape;

import java.awt.Color;
import java.awt.Graphics2D;

public abstract class Shape {
	protected int x;
	protected int y;
	protected Color fillColor;
	protected Color frameColor;

	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
		this.fillColor = Color.WHITE;
		this.frameColor = Color.BLACK;
	}

	public Shape() {
		this(0, 0);
		this.fillColor = Color.WHITE;
		this.frameColor = Color.BLACK;
	}

	abstract void draw(Graphics2D g);

	abstract boolean pick(int x, int y);

	public int getX() {
		return this.x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return this.y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Color getFillColor() {
		return this.fillColor;
	}

	public void setFillColor(Color fillColor) {
		this.fillColor = fillColor;
	}

	public Color getFrameColor() {
		return this.frameColor;
	}

	public void setFrameColor(Color frameColor) {
		this.frameColor = frameColor;
	}

	public void move(int dx, int dy) {
		this.x += dx;
		this.y += dy;
	}

	public void moveTo(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	public void initializePlace() {
		this.x = 0;
		this.y = 0;
	}

	@Override
	public String toString() {
		return "The 'x' coordinate : " + this.x + ". The 'y' coordinate : " + this.y + ". ";
	}

}
