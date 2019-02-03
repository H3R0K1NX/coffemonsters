package Ido_Queue;

import java.util.Scanner;

import Ido_Stack.Stack;

public class serviceQueue {

	public static Scanner in = new Scanner(System.in);

	public static void insertSortedChar(Queue<Character> q, char x) {
		Queue<Character> help = new Queue<Character>();
		while (!q.isEmpty() && q.head() < x)
			help.insert(q.remove());
		help.insert(x);
		while (!q.isEmpty())
			help.insert(q.remove());
		while (!help.isEmpty())
			q.insert(help.remove());
	}

	/**
	 * This is the answer for exercise number #5 on page 152
	 * <p>
	 * This method gets a Queue of <b>different</b> integers and returns a Stack of
	 * integers that is sorted from the smallest to the largest number (with the
	 * largest one being on the top of the Stack). The method does that without
	 * taking out of the Stack and using only one Queue (except the Queue that is
	 * given to the method). The method also keeps the given Queue unchanged.
	 * 
	 * @param {@code Queue<Integer> q}
	 * @return {@code Stack<Integer> s}
	 * @author Dora
	 */

	public static Stack<Integer> ex5(Queue<Integer> q) {
		Stack<Integer> s = new Stack<Integer>();
		int x = 0, min = q.head();
		Queue<Integer> help = new Queue<Integer>();
		while (!q.isEmpty()) {
			help.insert(q.head());
			if (q.head() < min)
				min = q.head();
			q.remove();
		}
		s.push(min);

		x = help.remove();
		q.insert(x);
		help.insert(x);
		while (help.head() != x) {
			q.insert(help.head());
			if (help.head() != min)
				help.insert(help.remove());
			else
				help.remove();
		}

		while (!help.isEmpty()) {
			x = help.head();
			min = help.remove();
			help.insert(x);
			while (x != help.head()) {
				if (help.head() < min)
					min = help.head();
				help.insert(help.remove());
			}
			s.push(min);
			if (help.head() == min)
				help.remove();
			else {
				x = help.remove();
				help.insert(x);
				while (help.head() != x) {
					if (help.head() != min)
						help.insert(help.remove());
					else
						help.remove();
				}
			}
		}
		return s;
	}

}
