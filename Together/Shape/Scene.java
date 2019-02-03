package Shape;

import java.awt.Graphics2D;

public class Scene {
	private Shape[] shapes;
	private Shape currentShape;

	public Scene() {
		this.shapes = new Shape[5];
		shapes[0] = new Rectangle(50, 70);
		shapes[1] = new Line(0, 0, 50, 50);
		shapes[2] = new Circle(40);
		shapes[3] = new Rectangle(90, 20);
		shapes[4] = new Circle(20);
	}

	public void addShape(Shape s) {
		int i = 0;
		while (shapes[i] != null && i < shapes.length) {
			i++;
		}
		if (i == shapes.length - 1)
			return;
		shapes[i] = s;
	}

	public void draw(Graphics2D g) {
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw(g);
		}
	}

	public int pickNum(int x, int y) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[shapes.length - 1 - i].pick(x, y))
				return i;
		}
		return -1;
	}

	public boolean pick(int x, int y) {
		for (int i = shapes.length - 1; i >= 0; i--) {
			if (shapes[i].pick(x, y)) {
				currentShape = shapes[i];
				for (int j = i + 1; j < shapes.length; j++)
					shapes[j - 1] = shapes[j];
			}
		}
		shapes[shapes.length - 1] = currentShape;
		return true;
	}

	public void move(int dx, int dy) {
		if (currentShape != null) {
			currentShape.move(dx, dy);
		}
	}

}
