package Ido_Stack;

public class Ring {
	private String color;
	private double size;

	public Ring(String color, double size) {
		this.color = color;
		this.size = size;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getSize() {
		return size;
	}

	public void setSize(double size) {
		this.size = size;
	}

	public static String compareSizes(Ring r1, Ring r2) {
		if (r1.getSize() > r2.getSize())
			return "bigger";
		if (r1.getSize() < r2.getSize())
			return "smaller";
		return "equal";
	}

	@Override
	public String toString() {
		return "Color : " + this.color + ". Size : " + this.size + "\n";
	}

}
