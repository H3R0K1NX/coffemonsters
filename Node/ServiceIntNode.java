package Node;

import java.util.Random;
import java.util.Scanner;

public class ServiceIntNode {

	public static Scanner in = new Scanner(System.in);

	public static IntNode direct() { // Creates a node
		int num;
		IntNode chain = null, p = null;
		System.out.println("Enter a value");
		num = in.nextInt();
		while (num != -1) {
			if (chain == null) {
				chain = new IntNode(num);
				p = chain;
			} else {
				p.setNext(new IntNode(num));
				p = p.getNext();
			}
			System.out.println("Enter a value");
			num = in.nextInt();
		}
		return chain;
	}

	public static IntNode directRandom() { // Creates a node with a certain length
		Random r = new Random();
		int num = r.nextInt(20) + 10;
		System.out.println("Enter a number for a length");
		int n = in.nextInt();

		IntNode chain = null, p = null;
		// System.out.println("Enter a value")
		for (int i = 0; i < n; i++) {
			num = r.nextInt(20) + 10;
			if (chain == null) {
				chain = new IntNode(num);
				p = chain;
			} else {
				p.setNext(new IntNode(num));
				p = p.getNext();
			}
		}
		return chain;
	}

	public static IntNode rev() { // Creates A node in a reversed way
		int num;
		IntNode chain = null;
		System.out.println("Enter a number: ");
		num = in.nextInt();
		while (num != -1) {
			chain = new IntNode(num, chain);
			num = in.nextInt();
		}
		return chain;
	}

	public static IntNode reve() {

		IntNode head = null;
		IntNode curr = head;
		int num = in.nextInt();
		while (num != -1) {
			head = new IntNode(num, curr);
			curr = head;
			num = in.nextInt();
		}
		return head;
	}

	public static IntNode methodEx1(int n) { // בונה חוליה עד הפרמטר או כולל אם הוא מתחלק בשלוש
		IntNode chain = null;
		IntNode p = null;
		if (n % 3 == 0) {
			for (int i = 0; i <= n; i += 3) {

				if (chain == null) {
					chain = new IntNode(i);
					p = chain;
				} else {
					p.setNext(new IntNode(i));
					p = p.getNext();
				}
			}
		} else {
			for (int i = 0; i < n; i += 3) {
				if (chain == null) {
					chain = new IntNode(i);
					p = chain;
				} else {
					p.setNext(new IntNode(i));
					p = p.getNext();
				}
			}
		}
		return chain;
	}

	public static void delEven(IntNode c) {
		IntNode p = c;
		while (p != null && p.getNext() != null) {
			p.setNext(p.getNext().getNext());
			p = p.getNext();
		}
	}

	public static IntNode delOdd(IntNode c) {
		IntNode p = c;
		c = c.getNext();
		p = c;
		while (p != null && p.getNext() != null) {
			p.setNext(p.getNext().getNext());
			p = p.getNext();
		}
		return c;
	}

	public static IntNode delOdd2(IntNode c) {
		c = c.getNext();
		delEven(c);
		return c;
	}

	public static IntNode deleteByValue(IntNode c, int val) {
		if (c.getValue() == val) {
			if (c.getNext() == null) {
				c = null;
				return c;
			}
			c = c.getNext();
			return deleteByValue(c, val);
		} else {
			return deleteByValue(c.getNext(), val);
		}

	}
	/*
	 * public static IntNode methodEx2(int num, int amount) { IntNode chain = null;
	 * if (num == 0) { chain = new IntNode(num); } for(int i = 0 ; i < amount < i++)
	 * {
	 * 
	 * } return chain; }
	 */

}
