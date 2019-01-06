package Shapes;

import java.awt.Graphics2D;

public class Scene {
	private Shape[] shapes;

	public Scene() {
		this.shapes = new Shape[5];
	}

	public void draw(Graphics2D g) {
		for (int i = 0; i < shapes.length; i++) {
			shapes[i].draw(g);
		}
	}

	public int pick(int x, int y) {
		for (int i = 0; i < shapes.length; i++) {
			if (shapes[shapes.length - 1 - i].pick(x, y))
				return i;
		}
		return -1;
	}

}
