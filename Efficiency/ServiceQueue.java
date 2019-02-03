package Efficiency;

import java.util.Scanner;

public class ServiceQueue {
	public static Scanner in = new Scanner(System.in);

	public static <T> int length(Queue<T> a) {
		int count = 0;
		while (!a.isEmpty()) {
			count++;
		}
		return count;
	}

	public static <T> boolean isInQueue(Queue<T> q, T val) {
		if (length(q) < 2) {
			return false;
		}
		Queue<T> help = new Queue<T>();
		T temp = q.remove();
		help.insert(temp);
		boolean bool = false;
		while (!q.isEmpty() && !bool) {
			T t = q.remove();
			help.insert(t);
			if (temp == t) {
				bool = true;
			}

		}
		while (!help.isEmpty()) {
			q.insert(help.remove());
		}
		return bool;

	}

	public static <T> Queue<T> copy(Queue<T> a) {
		Queue<T> c = new Queue<T>();
		Queue<T> g = new Queue<T>();
		while (!a.isEmpty()) {
			c.insert(a.head());
			g.insert(a.remove());
		}
		while (!g.isEmpty()) {
			a.insert(g.remove());
		}
		return c;
	}

	public static boolean exist(Queue<Integer> a, int num) {
		Queue<Integer> c = copy(a);
		while (!c.isEmpty()) {
			if (c.head() == num) {
				return true;
			}
			c.remove();
		}
		return false;
	}

	public static Queue<Integer> InsertNumberIntoSortedQueue(Queue<Integer> qi, int val) {
		Queue<Integer> help = new Queue<Integer>(), q = copy(qi);
		boolean on = false;
		while (!q.isEmpty()) {
			if (val <= q.head() && !on) {
				help.insert(val);
				on = true;
			}
			help.insert(q.remove());
		}
		if (!on) {
			help.insert(val);
		}
		return help;
	}

	public static <T> Queue<T> removeDoubles(Queue<T> q) {
		Queue<T> ret = new Queue<T>(), help = new Queue<T>();
		while (!q.isEmpty()) {
			boolean in = true;
			T val = q.remove();
			boolean retFull = true;
			if (ret.isEmpty()) {
				retFull = false;
			}
			if (retFull) {
				while (!ret.isEmpty()) {
					if (val == ret.head()) {
						in = false;
					}
					help.insert(ret.remove());
				}
				if (in) {
					help.insert(val);
				}
			} else {
				while (!help.isEmpty()) {
					if (val == help.head()) {
						in = false;
					}
					ret.insert(help.remove());
				}
				if (in) {
					ret.insert(val);
				}
			}
		}
		if (ret.isEmpty()) {
			return help;
		}
		return ret;
	}

	public static boolean guessIsRight(Queue<String> q, int num) {
		int count = 0;
		String s = "";
		while (!q.head().equals("Gold")) {
			s = q.remove();
			count++;
			q.insert(s);
		}
		if (count == num)
			return true;
		return false;
	}

	public static Queue<Integer> intersectionOfTwoQueues(Queue<Integer> q, Queue<Integer> w) {
		Queue<Integer> copyQ = copy(q);
		Queue<Integer> copyW = copy(w);
		Queue<Integer> New = new Queue<Integer>();
		while (!q.isEmpty())
			New.insert(q.remove());
		while (!w.isEmpty())
			New.insert(w.remove());
		q = copyQ;
		w = copyW;
		return New;
	}

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.insert(1);
		q.insert(3);
		q.insert(4);

		System.out.println(q);
		q = InsertNumberIntoSortedQueue(q, 2);
		System.out.println(q);
	}

	public static Queue<Item> convert(Queue<Character> q) {
		Queue<Character> h = copy(q);
		Queue<Item> q1 = new Queue<Item>();
		int count = 1;
		char ch = h.remove();
		while (!h.isEmpty()) {
			if (h.head() == ch) {
				count++;
				h.remove();
			} else {
				q1.insert(new Item(ch, count));
				ch = h.remove();
				count = 1;
			}
		}
		q1.insert(new Item(ch, count));
		return q1;

	}

	public static Queue<Item> convertV2(Queue<Character> q) {
		Queue<Character> h = copy(q);
		Queue<Item> q1 = new Queue<Item>();
		int count = 1;
		char ch = h.remove();
		while (!h.isEmpty()) {

			while (!h.isEmpty() && ch == h.head()) {
				count++;
				h.remove();
			}
			q1.insert(new Item(ch, count));
			count = 1;
			ch = h.remove();
		}
		return q1;
		// O(n)
	}

//		public Time ex2A(Queue<Time> t) {
//		}

}
