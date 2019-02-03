package Ido_Queue;

/**
 * The {@code Node} represents a node, part of a chain of nodes. Each Node holds
 * a value and holds a reference to the next node in the chain.
 * 
 * @author Ido Israeli
 *
 * @param <T>
 */
public class Node<T> {
	private T value;
	private Node<T> next;

	public Node() {
		this.value = null;
		this.next = null;
	}

	public Node(T value, Node<T> next) {
		this.value = value;
		this.next = next;
	}

	public Node(T value) {
		this.value = value;
		this.next = null;
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

	public boolean hasNext() {
		return (this.next == null) ? false : true;
	}

	@Override
	public String toString() {
		if (this.next == null)
			return this.value + "";
		return this.value + "-->" + this.next;
	}

	public static void main(String[] args) {

	}

}
