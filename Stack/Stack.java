package Stack;

import Node.Node;

public class Stack<T> {

	private Node<T> first;

	public Stack() {
		this.first = null;
	}

	public void push(T x) {
		this.first = new Node<T>(x, this.first);
	}

	public T pop() {
		T x = this.first.getValue();
		this.first = this.first.getNext();
		return x;
	}

	public boolean isEmpty() {
		return this.first == null;
	}

	public T top() {
		return this.first.getValue();
	}

	public String toString() {
		String str = "▲" + "\n";

		Node<T> pos = this.first;
		while (pos != null) {
			str = "\n" + str + pos.getValue().toString() + "\n";
			if (pos.getNext() != null)
				str = str + "\n";
			pos = pos.getNext();
		}
		str = str + "▼";

		return str;
	}

	public static void main(String[] args) {
		Stack<String> stk = new Stack<String>();
		System.out.println(stk);
		stk.push("lelz");
		System.out.println(stk);
		stk.push("nyaaaaa");
		System.out.println(stk);
		stk.push("boiiii");
		System.out.println(stk);
		stk.pop();
		System.out.println(stk);
		System.out.println(stk.top());

	}
}
