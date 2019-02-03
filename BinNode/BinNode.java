package BinNode;

public class BinNode<T> {

	// עץ בינארי זהו מבנה נתונים שלכל צומת (איבר) בו יש לכל היותר שני תתי עצים שהם
	// זרים זה לזה.

	private BinNode<T> left;
	private T value;
	private BinNode<T> right;

	public BinNode(T value) {
		this.left = null;
		this.value = value;
		this.right = null;
	}

	public BinNode(BinNode<T> left, T value, BinNode<T> right) {
		this.left = left;
		this.value = value;
		this.right = right;
	}

	public T getValue() {
		return this.value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public BinNode<T> getLeft() {
		return left;
	}

	public void setLeft(BinNode<T> left) {
		this.left = left;
	}

	public BinNode<T> getRight() {
		return right;
	}

	public void setRight(BinNode<T> right) {
		this.right = right;
	}

	public boolean hasRight() {
		return this.right != null;
	}

	public boolean hasLeft() {
		return this.left != null;
	}

	public void printValue() {
		System.out.println("   <" + this.value + ">   ");
	}

	public void printLeft() {
		System.out.println("(" + this.left + ")");
	}

	public void printRight() {
		System.out.println("(" + this.left + ")");
	}

	@Override
	public String toString() {
		return "(" + left + " " + value + " " + right + ")";
	}

}
