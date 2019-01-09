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
		// int len = Integer.toString(num).length(); //****OPTION 2****
		// String n = String.valueOf(num);
		// for (int i = 0; i < len; i++) {
		// s.push(Character.digit(n.charAt(i), 10));
		// }
		int temp = 0;
		while (num > 0) {
			temp = num % 10;
			s.push(temp);
			num = num / 10;
		}
		Stack<Integer> backup = copyStack(s);
		System.out.println("S " + s);
		// Stack<Integer> c = new Stack<Integer>();
		Stack<Integer> reversed = copyStack(s);
		reversed = reverseStack(reversed);
		System.out.println("REVERSED " + reversed);
		while (!s.isEmpty() && length(s) > 1) {
			if (s.top() == reversed.top()) {
				b = true;
				// c.push(s.pop());
				s.pop();
				s = removeButtomVal(s);
				reversed.pop();
				reversed = removeButtomVal(reversed);
//				if (length(s) == 1 && length(reversed) == 1)
//					break;
			} else {
//				while (!c.isEmpty()) {
//					s.push(c.pop());
//				}
				s = backup;
				return false;
			}
		}
//		while (!c.isEmpty()) {
//			s.push(c.pop());
//		}
		s = backup;
		return b;
	}

	public static Stack<Integer> beLikeBonus(Stack<Integer> a, Stack<Integer> b) {
		Stack<Integer> copyA = copyStack(a);
		Stack<Integer> copyB = copyStack(b);
		Stack<Integer> RESULT = new Stack<Integer>();
		Stack<Integer> RevA = reverseStack(a);
		Stack<Integer> RevB = reverseStack(b);
		int cal, rem;
		int remA;
		if (length(a) > length(b)) {

		}
		if (length(b) > length(a)) {

		}
		if (length(b) == length(a)) {
			while (!RevA.isEmpty()) {
				// remA = RevA.top();
				cal = RevA.pop() + RevB.pop();
				if (cal > 10) {
					rem = RevA.pop();
					System.out.println("REM " + rem);
					RESULT.push(9);
					System.out.println("ADD " + cal);
					cal = 9 - rem;

					System.out.println("SUB " + cal);
				} else if (cal == 10) {
					rem = RevA.pop();
					RESULT.push(0);
					cal = rem + 1;
				}

				RESULT.push(cal);
			}
		}

		RESULT = reverseStack(RESULT);
		return RESULT;
	}

	public static void main(String[] args) {
		Stack<Integer> c = fillStackInteger();
		System.out.println("C " + c);
		Stack<Integer> k = fillStackInteger();
		System.out.println("K " + k);
		Stack<Integer> RESULT = beLikeBonus(c, k);
		System.out.println("RESULT " + RESULT);

	}

}
