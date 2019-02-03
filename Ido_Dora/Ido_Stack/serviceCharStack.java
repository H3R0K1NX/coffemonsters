package Ido_Stack;

import java.util.Scanner;

public class serviceCharStack {

	public static Scanner in = new Scanner(System.in);

	public static Stack<Character> fill() {
		char ch;
		Stack<Character> s = new Stack<Character>();
		System.out.println("Enter a character");
		ch = in.next().charAt(0);
		while (ch != '+') {
			s.push(ch);
			System.out.println("Enter a character (enter '+' to stop)");
			ch = in.next().charAt(0);
		}
		return s;
	}

	public static Stack<Character> copy(Stack<Character> s) {
		Stack<Character> help = new Stack<Character>();
		Stack<Character> h = new Stack<Character>();
		while (!s.isEmpty()) {
			help.push(s.top());
		}
		while (!help.isEmpty()) {
			s.push(help.top());
			h.push(help.pop());
		}
		return h;
	}

//	public static <T> Stack<Character> convertGenericToChar(Stack<T> s1, Stack<Character> s2) {
//		Stack<Character> help = new Stack<Character>();
//		Stack<Character> h = new Stack<Character>();
//		while (!s1.isEmpty()) {
//			help.push((Character) s1.top());
//		}
//		while (!help.isEmpty()) {
//			s1.push((T) help.top());
//			s2.push(help.pop());
//		}
//		return s2;
//	}

	// Checks whether two Stacks of characters are identical
	public static boolean areIdenticalCharStacks(Stack<Character> s1, Stack<Character> s2) {
		Stack<Character> help1 = copy(s1);
		Stack<Character> help2 = copy(s2);

		while (!help1.isEmpty() && !help2.isEmpty()) {
			if (help1.pop().equals(help2.pop()))
				return false;
		}

		return help1.isEmpty() && help2.isEmpty();
	}

	// Inserts a character in a sorted manner
	public static void sortedInsertChar(Stack<Character> s, char ch) {
		Stack<Character> help = new Stack<Character>();
		while (!s.isEmpty() && s.top() < ch) {
			help.push(s.pop());
		}
		s.push(ch);
		while (!help.isEmpty())
			s.push(help.pop());
	}

}
