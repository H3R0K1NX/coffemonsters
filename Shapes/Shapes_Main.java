package Shapes;

public class Shapes_Main {

	public static void main(String[] args) {
		Point p1 = new Point(5, 10);
		Point p2 = new Point(6, 5);
		Line l1 = new Line(p1, p2);

		System.out.println(l1 + "\n");
		p2.move(10, 81);
		System.out.println(l1 + "\n");
		l1.move(7, 9);
		System.out.println(l1 + "\n");

	}

}
