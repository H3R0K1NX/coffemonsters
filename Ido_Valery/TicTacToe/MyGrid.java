package TicTacToe;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;

public class MyGrid {
	private int xLoc;
	private int yLoc;
	private int width;
	private int height;
	private Color color;
	private int cols;
	private int rows;

	public MyGrid() {
		this.xLoc = 0;
		this.yLoc = 0;
		this.width = 270;
		this.height = 270;
		this.color = color.BLACK;
		this.cols = 3;
		this.rows = 3;
	}

	public void draw(Graphics2D g2) {
		g2.setColor(this.color);
		for (int i = 0; i < rows; i++) {
			g2.drawLine(xLoc, yLoc + i * height, xLoc + cols * width, yLoc + i * height);
		}
		for (int i = 0; i < cols; i++) {
			g2.drawLine(xLoc + i * width, yLoc, xLoc + i * width, yLoc + rows * height);
		}
	}

	public Point pick(int x, int y) {
		int row = (y - yLoc) / height;
		int col = (x - xLoc) / width;
		if (row < 0 || row >= rows || col < 0 || col >= cols)
			return null;
		return new Point(col, row);
	}

}
