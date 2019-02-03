package Ido_Stack;

import java.util.Scanner;

public class serviceIntStack {

	public static Scanner in = new Scanner(System.in);

	public static Stack<Integer> fill() {
		int num;
		Stack<Integer> s = new Stack<Integer>();
		System.out.println("Enter an integer");
		num = in.nextInt();
		while (num != -1) {
			s.push(num);
			System.out.println("Enter an integer");
			num = in.nextInt();
		}
		return s;
	}

	public static Stack<Integer> copy(Stack<Integer> s) {
		Stack<Integer> help = new Stack<Integer>();
		Stack<Integer> h = new Stack<Integer>();
		while (!s.isEmpty()) {
			help.push(s.top());
		}
		while (!help.isEmpty()) {
			s.push(help.top());
			h.push(help.pop());
		}
		return h;
	}

	// Checks whether two Stacks of Integers are identical
	public static boolean areIdenticalIntStacks(Stack<Integer> s1, Stack<Integer> s2) {
		Stack<Integer> help1 = copy(s1);
		Stack<Integer> help2 = copy(s2);

		while (!help1.isEmpty() && !help2.isEmpty()) {
			if (help1.pop() != help2.pop())
				return false;
		}

		return help1.isEmpty() && help2.isEmpty();
	}

	// Deletes all the odd numbers
	public static void delOdd(Stack<Integer> s) {
		Stack<Integer> help = new Stack<Integer>();
		while (!s.isEmpty()) {
			if (s.top() % 2 != 0)
				s.pop();
			else
				help.push(s.pop());
		}
		while (!help.isEmpty())
			s.push(help.pop());
	}

	// Inserts an integer in a sorted manner
	public static void sortedInsertInt(Stack<Integer> s, int x) {
		Stack<Integer> help = new Stack<Integer>();
		while (!s.isEmpty() && s.top() < x) {
			help.push(s.pop());
		}
		s.push(x);
		while (!help.isEmpty())
			s.push(help.pop());
	}

	public static boolean isPolNum(int num) {
		Stack<Integer> s1 = new Stack<Integer>();
		Stack<Integer> s2 = new Stack<Integer>();
		Stack<Integer> s3 = new Stack<Integer>();

		while (num != 0) {
			s1.push(num % 10);
			s2.push(num % 10);
			num /= 10;
		}
		while (!s2.isEmpty()) {
			s3.push(s2.pop());
		}
		return areIdenticalIntStacks(s1, s3);
	}

}
