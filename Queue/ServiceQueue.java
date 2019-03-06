package Queue;

import java.util.Scanner;

public class ServiceQueue {
	public static Scanner in = new Scanner(System.in);

	public static <T> int length(Queue<T> a) {
		Queue<T> k = copy(a);
		int count = 0;
		while (!k.isEmpty()) {
			k.remove();
			count++;
		}
		return count;
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

	public static void InsertNumberIntoSortedQueue(Queue<Integer> q, int num) {
		Queue<Integer> backup = new Queue<Integer>();
		while (!q.isEmpty() && num > q.head()) {
			backup.insert(q.remove());
		}
		backup.insert(num);
		while (!q.isEmpty())
			backup.insert(q.remove());

		while (!backup.isEmpty())
			q.insert(backup.remove());
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

	public static boolean ex3(Queue<Character> q, int n) {
		int l = length(q);
		int x = n % l;
		if (x == 0)
			return true;
		for (int i = l - x; i > 0; i--) {
			q.insert(q.remove());
		}
		return false;
	}

	public static void shiftRight(Queue<Character> q, int n) {
		Queue<Character> h = copy(q);
		Queue<Character> help = new Queue<Character>();
		char x = 0;
		while (!h.isEmpty())
			x = h.remove();
		help.insert(x);
		while (!q.isEmpty()) {
			x = q.remove();
			if (!q.isEmpty())
				help.insert(x);
		}
		while (!help.isEmpty())
			q.insert(help.remove());
	}

	public static void main(String[] args) {
		Queue<Character> q = new Queue<Character>();
		q.insert('a');
		q.insert('s');
		q.insert('r');
		q.insert('t');
		System.out.println("Q=" + q);
		q.insert('Z');
		System.out.println("Q=" + q);
		// System.out.println(length(q));
		// System.out.println(ex3(q, 1));
		// shiftRight(q, 1);
		// System.out.println("Q afterparty=" + q);
	}

}
