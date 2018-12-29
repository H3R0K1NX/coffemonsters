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
		System.out.println("Done filling the Stack");
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
		System.out.println("Done filling the Stack");
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

	public static <T> Stack<T> reverseStack(Stack<T> t) {
		Stack<T> c = new Stack<T>();
		while (!t.isEmpty())
			c.push(t.pop());
		return c;
	}

	public static <T> Stack<T> copyStack(Stack<T> t) {
		Stack<T> copy = new Stack<T>();
		Stack<T> other = new Stack<T>();
		while (!t.isEmpty()) {
			Object val = t.top();
			copy.push(t.pop());
			other.push((T) val);
		}
		copy = reverseStack(copy);
		while (!other.isEmpty())
			t.push(other.pop());

		return copy;
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

	public static <T> boolean targil3(Stack<T> s1, Stack<T> s2) {
		boolean b = false;
		Stack<T> s3 = new Stack<T>();
		Stack<T> s4 = new Stack<T>();
		while (!s1.isEmpty() && !s2.isEmpty()) {
			if (s1.top() == s2.top()) {
				b = true;
				s3.push(s1.pop());
				s4.push(s2.pop());
			}
			b = false;
			s3.push(s1.pop());
			s4.push(s2.pop());
		}
		return b;
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

	public static Stack<Integer> removeButtomVal(Stack<Integer> s) {
		Stack<Integer> k = reverseStack(s);
		// System.out.println("K");
		// System.out.println(k);
		// while (!k.isEmpty())

		k.pop();
		// System.out.println("K - POP");
		// System.out.println(k);
		s = reverseStack(k);
		return s;
	}

	public static boolean isPalindrom(Stack<Integer> s, int num) {
		boolean b = false;
		int len = Integer.toString(num).length();
		String n = Integer.toString(num);
		for (int i = 0; i < len; i++) {
			s.push((int) n.charAt(i));
		}
		System.out.println(s);
		Stack<Integer> c = new Stack<Integer>();
		Stack<Integer> reversed = copyStack(s);
		reversed = reverseStack(reversed);
		System.out.println(reversed);
		while (!s.isEmpty()) {
			if (s.top() == reversed.top()) {
				b = true;
				c.push(s.pop());
				s = removeButtomVal(s);
				reversed.pop();
				reversed = removeButtomVal(reversed);
				System.out.println("S" + s);
				System.out.println("REV" + reversed);
				if (length(s) == 1 && length(reversed) == 1)
					break;
			}
			while (!c.isEmpty()) {
				s.push(c.pop());
			}
			return false;
		}
		while (!c.isEmpty()) {
			s.push(c.pop());
		}
		return b;
	}

	public static void main(String[] args) {
		// Stack<Integer> c = fillStackInteger();
		Stack<Integer> c = new Stack<Integer>();
		System.out.println("C");
		System.out.println(c);
//		Stack<Integer> k = fillStackInteger();
//		System.out.println("K");
//		System.out.println(k);
		System.out.println(isPalindrom(c, 12322));
		System.out.println(c);

	}

}
