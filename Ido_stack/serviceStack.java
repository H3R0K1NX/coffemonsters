package Ido_stack;

import java.util.Scanner;

public class serviceStack {

	public static Scanner in = new Scanner(System.in);

	public static <T> Stack<T> copy(Stack<T> s) {
		Stack<T> help = new Stack<T>();
		Stack<T> h = new Stack<T>();
		while (!s.isEmpty()) {
			help.push(s.top());
		}
		while (!help.isEmpty()) {
			s.push(help.top());
			h.push(help.pop());
		}
		return h;
	}

	// Inserts in a sorted manner
	public static <T> void sortedInsert(Stack<T> s, T x) {
		Stack<T> help = new Stack<T>();
		String str = "";
		if (s.top() instanceof Character)
			str = "Character";
		else if (s.top() instanceof Integer)
			str = "Integer";

		switch (str) {
		case "Character":
			while (!s.isEmpty() && (Character) s.top() < (char) x) {
				help.push(s.pop());
			}
			s.push(x);
			while (!help.isEmpty())
				s.push(help.pop());
			break;

		case "Integer":
			while (!s.isEmpty() && (Integer) s.top() < (int) x) {
				help.push(s.pop());
			}
			s.push(x);
			while (!help.isEmpty())
				s.push(help.pop());
			break;

		case "Long":
			while (!s.isEmpty() && (Long) s.top() < (long) x) {
				help.push(s.pop());
			}
			s.push(x);
			while (!help.isEmpty())
				s.push(help.pop());
			break;
		}
	}

}
