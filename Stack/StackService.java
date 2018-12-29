package Stack;

import java.util.Scanner;

public class StackService {

	public static Scanner in = new Scanner(System.in);

	public static Stack<Integer> fillStackInteger() {
		Stack<Integer> s = new Stack<Integer>();
		System.out.println("Enter an value");
		int num = in.nextInt();
		while (num != -1) {
			s.push(num);
			System.out.println("Enter an value");
			num = in.nextInt();
		}
		return s;
	}

	public static Stack<Character> fillStackCharcter() {
		Stack<Character> s = new Stack<Character>();
		System.out.println("Enter an value");
		char num = in.next().charAt(0);
		while (num != '1') {
			s.push(num);
			System.out.println("Enter an value");
			num = in.next().charAt(0);
		}
		return s;
	}

	public static Stack<Character> removeSmallLetters(Stack<Character> s) {
		Stack<Character> backup = new Stack<Character>();
		while (!s.isEmpty()) {
			if (s.top() <= 'Z' && s.top() >= 'A')
				backup.push(s.pop());
			else
				s.pop();
		}
		while (!backup.isEmpty())
			s.push(backup.pop());
		return s;
	}

	public static void InsertNumberInSortedArray(Stack<Integer> c, int num) {
		Stack<Integer> backup = new Stack<Integer>();
		while (!c.isEmpty() && c.top() <= num) {
			backup.push(c.pop());
		}
		c.push(num);
		while (!backup.isEmpty())
			c.push(backup.pop());
	}

	public static <T> Stack<T> copyStack(Stack<T> t) {
		Stack<T> c = new Stack<T>();
		Stack<T> k = new Stack<T>();
		while (!t.isEmpty())
			c.push(t.pop());
		while (!c.isEmpty())
			k.push(c.pop());
		return k;
	}

	public static boolean targil1(Stack<Integer> s, int num) {
		Stack<Integer> c = new Stack<Integer>();
		s = copyStack(c);
		while (!s.isEmpty()) {
			if (s.top() == num) {
				return true;
			} else {
				c.push(s.pop());
			}
		}
		return false;
	}

	public static <T> int length(Stack<T> s) {
		int count = 0;
		Stack<T> p = new Stack<T>();
		while (!s.isEmpty()) {
			p.push(s.pop());
			count++;
		}
		while (!p.isEmpty())
			s.push(p.pop());

		return count;
	}

	public static <T> boolean targil3(Stack<T> s1, Stack<T> p1) {
		Stack<T> ss = new Stack<T>();
		Stack<T> sa = new Stack<T>();
		while (!s1.isEmpty() && !p1.isEmpty()) {
			if (s1.top() == p1.top())
				return true;
			ss.push(s1.pop());
			sa.push(p1.pop());
		}
		while (!ss.isEmpty())
			s1.push(ss.pop());
		while (!sa.isEmpty())
			p1.push(sa.pop());
		return false;
	}

	public static <T> Stack<T> shiftUp(Stack<T> s, int amount) {
		Stack<T> help = new Stack<>(), vals = new Stack<T>();
		amount = amount % length(s);
		amount = length(s) - amount;
		int c = 0;
		while (!s.isEmpty()) {
			if (c < amount) {
				help.push(s.pop());
			} else {
				vals.push(s.pop());
			}
			c++;
		}
		while (!help.isEmpty()) {
			s.push(help.pop());
		}
		while (!vals.isEmpty()) {
			s.push(vals.pop());
		}

		return s;
	}

	public static boolean isSorted(Stack<Integer> s) {
		Stack<Integer> help = new Stack<Integer>();
		boolean t = true;
		while (length(s) > 1 && t) {
			help.push(s.pop());
			if (help.top() > s.top()) {
				t = false;
			}
		}
		while (!help.isEmpty()) {
			s.push(help.pop());
		}
		return t;
	}

	public static void insert(Stack<Integer> s, int x) { // פעולת עזר המכניסה לתוך מחסנית ממויינת בסדר יורד
		Stack<Integer> h = new Stack<Integer>();
		while (!s.isEmpty() && x < s.top()) {
			h.push(s.pop());
		}
		s.push(x);
		while (!h.isEmpty())
			s.push(h.pop());
	}

	public static void main(String[] args) {
		Stack<Integer> c = fillStackInteger();

	}

}
