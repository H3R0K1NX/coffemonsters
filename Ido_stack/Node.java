package Ido_stack;

public class Node<T> {
	private T value;
	private Node<T> next;

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public Node(T value) {
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	public String toString() {
		if (this.next == null)
			return this.value + "";
		return this.value + "-->" + this.next;
	}

	public static void main(String[] args) {

	}

}
