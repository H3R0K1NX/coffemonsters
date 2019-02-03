package Ido_Stack;

import java.util.Scanner;

public class Stacks_Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

//		Stack<Character> s1 = new Stack();
		Stack<Character> s2 = new Stack<Character>();
		Character ch = 'c';
		s2.push('e');
		s2.push('d');
		s2.push('b');
		s2.push('a');

		System.out.println(s2.getClass().getEnclosingClass());

		System.out.println(s2 + "\n");

		serviceStack.sortedInsert(s2, ch);
		System.out.println(s2 + "\n");

	}

}
