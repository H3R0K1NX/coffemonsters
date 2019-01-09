package Queue;

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

	public static void main(String[] args) {
		Queue<Integer> q = new Queue<Integer>();
		q.insert(1);
		q.insert(3);
		q.insert(4);

		Queue<Integer> w = new Queue<Integer>();
		q.insert(5);
		q.insert(7);
		q.insert(2);
		System.out.println(intersectionOfTwoQueues(q, w));

	}

}
