package Shapes;

public class Point extends Shape {

	public Point(int x, int y) {
		super(x, y);
	}

	public int getX() {
		return this.x;
	}

	public int getY() {
		return this.y;
	}

	@Override
	public void draw() {
		System.out.print("*");

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

}
