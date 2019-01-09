package Shape;

import java.awt.Graphics2D;

public class Point extends Shape {

	public Point(int x, int y) {
		super(x, y);
	}

	@Override
	public int getX() {
		return this.x;
	}

	@Override
	public int getY() {
		return this.y;
	}

	@Override
	public void move(int dx, int dy) {
		this.x = dx;
		this.y = dy;
	}

	public double distance(Point p) {
		return Math.sqrt((Math.pow((x - p.x), 2) + Math.pow((y - p.y), 2)));
	}

	public int distanceX(int x2) {
		return x2 - this.x;
	}

	public int distanceY(int y2) {
		return y2 - this.y;
	}

	@Override
	public String toString() {
		return "The coordinates are {" + this.x + "," + this.y + "}.";
	}

	@Override
	void draw(Graphics2D g) {
		// TODO Auto-generated method stub

	}

	@Override
	boolean pick(int x, int y) {
		// TODO Auto-generated method stub
		return false;
	}

}
