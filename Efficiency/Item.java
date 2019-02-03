package Efficiency;

public class Item {

	protected char ch;
	protected int amount;

	public Item(char ch, int amount) {
		this.ch = ch;
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "ch: " + this.ch + ", amount: " + this.amount + " ";
	}

	public static void main(String[] args) {
		Queue<Character> q = new Queue<Character>();
		q.insert('a');
		q.insert('a');
		q.insert('a');
		q.insert('f');
		q.insert('b');
		q.insert('b');
	}

}
