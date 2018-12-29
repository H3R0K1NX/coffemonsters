package page133;

import Stack.Stack;
import Stack.StackService;

public class Couple {

	private int num;
	private int appears;

	public Couple(int num, int appears) {
		this.num = num;
		this.appears = appears;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getAppears() {
		return appears;
	}

	public void setAppears(int appears) {
		this.appears = appears;
	}

	@Override
	public String toString() {
		return "Couple [num=" + num + ", appears=" + appears + "]";
	}

	public static Stack<Integer> convert(Stack<Couple> s) {
		int n, times;

		Stack<Integer> h = new Stack<Integer>();
		Stack<Couple> help = new Stack<Couple>();

		while (!s.isEmpty()) {
			n = s.top().getNum();
			times = s.top().getAppears();
			help.push(s.pop());
			for (int i = 1; i <= times; i++)
				StackService.insert(h, n);
		}
		while (!h.isEmpty())
			s.push(help.pop());
		return h;
	}

	public static int counter(Stack<Integer> s, int x) {
		Stack<Integer> p = new Stack<Integer>();
		int count = 0;
		while (!s.isEmpty()) {
			if (s.top() == x)
				count++;

			p.push(s.pop());
		}
		while (!p.isEmpty())
			s.push(p.pop());
		System.out.println(count);
		return count;
	}

	public static Stack<Couple> reverse(Stack<Integer> s) {
		Stack<Integer> h = new Stack<Integer>();
		Stack<Couple> help = new Stack<Couple>();
		int n = 0;
		int times = 0;
		while (!s.isEmpty()) {
			n = s.top();
			times = counter(s, s.top());
			help.push(new Couple(n, times));
			h.push(s.pop());
		}
		while (!h.isEmpty())
			s.push(h.pop());
		System.out.println(help);
		return help;
	}

	public static void main(String[] args) {
		Stack<Integer> s = new Stack<Integer>();
		s.push(2);
		s.push(2);
		s.push(2);
		s.push(4);
		s.push(4);
		s.push(6);

		System.out.println(s);
		Stack<Couple> c = reverse(s);

		// System.out.println(c);

	}
}
