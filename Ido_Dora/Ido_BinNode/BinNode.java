package Ido_BinNode;

public class BinNode<T> {
	private T value;
	private BinNode<T> left;
	private BinNode<T> right;

	public BinNode(T value) {
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public BinNode(T value, BinNode<T> left, BinNode<T> right) {
		this.value = value;
		this.left = left;
		this.right = right;
	}

	public BinNode(T value, T leftVal, T rightVal) {
		this.value = value;
		this.left = new BinNode<T>(leftVal);
		this.right = new BinNode<T>(rightVal);
	}

	public BinNode(T value, T leftVal, BinNode<T> right) {
		this.value = value;
		this.left = new BinNode<T>(leftVal);
		this.right = right;
	}

	public BinNode(T value, BinNode<T> left, T rightVal) {
		this.value = value;
		this.left = left;
		this.right = new BinNode<T>(rightVal);
	}

	public T getValue() {
		return value;
	}

	public BinNode<T> getLeft() {
		return left;
	}

	public BinNode<T> getRight() {
		return right;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public void setLeft(BinNode<T> left) {
		this.left = left;
	}

	public void setRight(BinNode<T> right) {
		this.right = right;
	}

	public String printBranches() {
		return "\n" + left + right;
	}

	@Override
	public String toString() {
		String str = "      (" + value + ")      " + printBranches();
		return str;
	}

	public void printTree() {
		System.out.println("      (");
	}

}
