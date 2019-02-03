/**
 * 
 */
package Ido_Queue;

/**
 * The {@code Queue} class represents a queue of values of a generic type.
 * 
 * @author Ido Israeli
 * @see Node
 */
public class Queue<T> {
	private Node<T> first;
	private Node<T> last;

	/**
	 * Constructs an empty Queue
	 */
	public Queue() {
		this.first = null;
		this.last = null;
	}

	/**
	 * Constructs a Queue with a first value
	 * 
	 * @param T x
	 */
	public Queue(T x) {
		this.first = new Node<T>(x);
		this.last = first;
	}

	/**
	 * The method inserts the value "x" to the end of the Queue
	 */
	public void insert(T x) {
		Node<T> temp = new Node<T>(x);
		if (first == null)
			first = temp;
		else // if (last != null)
			last.setNext(temp);
		last = temp;
	}

	/**
	 * The method takes out and returns the first value in the Queue
	 */
	public T remove() {
		T x = first.getValue();
		first = first.getNext();
		if (first == null)
			last = null;
		return x;
	}

	/**
	 * The method returns the first value of the Queue
	 * 
	 * @return the first value of the Queue
	 */
	public T head() {
		return first.getValue();
	}

	/**
	 * The method returns whether the Queue is empty or not
	 * 
	 * @return {@code true} if the Queue is empty and {@code false} if the Queue is
	 *         not empty
	 */
	public boolean isEmpty() {
		return first == null;
	}

	/**
	 * The method describes the Queue as a String
	 * 
	 * @return {@code String} object that describes the Queue
	 */
	@Override
	public String toString() {
		if (this.isEmpty())
			return "[]";
		this.insert(null);
		String s = "[";
		T temp = this.remove();
		while (temp != null) {
			s = s + temp + ",";
			this.insert(temp);
			temp = this.remove();
		}
		s = s.substring(0, s.length() - 1) + "]";
		return s;
	}

}
