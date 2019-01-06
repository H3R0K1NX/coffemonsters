package Shapes;

public class Rectangle extends Shape {
//	private Point TL; // TL = Top Left
	private int width;
	private int height;

	public Rectangle(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	public Point getTopLeftPoint() {
		return TL;
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
	public void draw() {

	}

	@Override
	public void move(int dx, int dy) {
		super.move(dx, dy);
	}

}
