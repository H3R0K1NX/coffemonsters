package Node;

import java.util.Arrays;
import java.util.Scanner;

public class ServiceNode {

	public static Scanner in = new Scanner(System.in);

	public static <T> void counterOfValue(Node<T> k, T c) {
		Node<T> j = k;
		int count = 0;
		while (j != null) {
			if (j.getValue() == (c))
				count++;

			j = j.getNext();
		}
		System.out.println(count);
	}

	public static <T> int len(Node<T> c) {
		int count = 0;
		while (c != null) {
			count++;
			c = c.getNext();
		}
		return count;
	}

	public static void createAndCountCharacters() {
		Node<Character> c = null;
		char ch = in.next().charAt(0);
		while (ch != 'x') {
			c = new Node<Character>(ch, c);
			ch = in.next().charAt(0);
		}
		for (char i = 'a'; i <= 'z'; i++) {

			System.out.print(i + "=");

		}
		for (char j = 'A'; j <= 'Z'; j++) {
			System.out.print(j + "=");
		}
		System.out.println(len(c));
	}

	public static <T> boolean exist(Node<T> k, T num) { // EX6

		Node<T> n = k;
		while (n.getNext() != null) {
			if (n.getValue() == num)
				return true;
			else
				n = n.getNext();
		}
		return false;
	}

	public static Node<Integer> makeMathFromChar(Node<Character> C) { // EX17
		Node<Character> k = C;
		Node<Integer> I = null;
		int math = 0;

		while (k != null && k.getNext() != null) {
			if (k.getNext().getValue() == '+') {
				math = Character.getNumericValue(k.getValue())
						+ Character.getNumericValue(k.getNext().getNext().getValue());
				I = new Node<Integer>(math, I);
			}
			if (k.getNext().getValue() == '-') {
				math = Character.getNumericValue(k.getValue())
						- Character.getNumericValue(k.getNext().getNext().getValue());
				I = new Node<Integer>(math, I);
			}
			if (k.getNext().getValue() == '/') {
				math = Character.getNumericValue(k.getValue())
						/ Character.getNumericValue(k.getNext().getNext().getValue());
				I = new Node<Integer>(math, I);
			}
			if (k.getNext().getValue() == '*') {
				math = Character.getNumericValue(k.getValue())
						* Character.getNumericValue(k.getNext().getNext().getValue());
				I = new Node<Integer>(math, I);
			}
			k = k.getNext().getNext().getNext();
		}
		return I;
	}

	public static <T> Node<T> createReversedByGivenNode(Node<T> n) {
		T[] arr = convertNodeToArray(n);
		Node<T> c = null;
		for (int i = arr.length - 1; i >= 0; i--) {
			c = new Node<T>(arr[i], c);
		}
		return c;
	}

	public static <T> Node<T> createReversed(Node<T> chain) {
		Node<T> chainRev = null;
		while (chain != null) {
			chainRev = new Node<T>(chain.getValue(), chainRev);
			chain = chain.getNext();
		}
		return chainRev;
	}

	public static <T> T[] convertNodeToArray(Node<T> n) {
		T[] arr = (T[]) new Object[len(n)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n.getValue();
			n = n.getNext();
		}
		return arr;
	}

	public static Integer[] convertNodeToIntegerArray(Node<Integer> n) {
		Integer[] arr = new Integer[len(n)];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = n.getValue();
			System.out.println(Arrays.toString(arr)); // Ma'akav
			System.out.println();
			n = n.getNext();
		}
		return arr;
	}

	public static <T> Node<T> createAnyTypeOfNode(String str) {
		Node<T> n = null;
		if (str.equalsIgnoreCase("int")) {
			Node<Integer> p = (Node<Integer>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter an int");
					n = (Node<T>) new Node<Integer>(in.nextInt(), (Node<Integer>) n);
					p = (Node<Integer>) n;
				} else {
					System.out.println("Enter an int");
					p.setNext(new Node<Integer>(in.nextInt()));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("char")) {
			Node<Character> p = (Node<Character>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a char");
					n = (Node<T>) new Node<Character>(in.next().charAt(0), (Node<Character>) n);
					p = (Node<Character>) n;
				} else {
					System.out.println("Enter a char");
					p.setNext(new Node<Character>(in.next().charAt(0)));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("String")) {
			Node<String> p = (Node<String>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a String");
					n = (Node<T>) new Node<String>(in.next(), (Node<String>) n);
					p = (Node<String>) n;
				} else {
					System.out.println("Enter a String");
					p.setNext(new Node<String>(in.next()));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("double")) {
			Node<Double> p = (Node<Double>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a double");
					n = (Node<T>) new Node<Double>(in.nextDouble(), (Node<Double>) n);
					p = (Node<Double>) n;
				} else {
					System.out.println("Enter a double");
					p.setNext(new Node<Double>(in.nextDouble()));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("long")) {
			Node<Long> p = (Node<Long>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a long");
					n = (Node<T>) new Node<Long>(in.nextLong(), (Node<Long>) n);
					p = (Node<Long>) n;
				} else {
					System.out.println("Enter a long");
					p.setNext(new Node<Long>(in.nextLong()));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("float")) {
			Node<Float> p = (Node<Float>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a float");
					n = (Node<T>) new Node<Float>(in.nextFloat(), (Node<Float>) n);
					p = (Node<Float>) n;
				} else {
					System.out.println("Enter a float");
					p.setNext(new Node<Float>(in.nextFloat()));
					p = p.getNext();
				}
			}
		}
		if (str.equalsIgnoreCase("short")) {
			Node<Short> p = (Node<Short>) n;
			System.out.println("Enter the length");
			int leng = in.nextInt();
			for (int i = 0; i < leng; i++) {
				if (n == null) {
					System.out.println("Enter a short");
					n = (Node<T>) new Node<Short>(in.nextShort(), (Node<Short>) n);
					p = (Node<Short>) n;
				} else {
					System.out.println("Enter a short");
					p.setNext(new Node<Short>(in.nextShort()));
					p = p.getNext();
				}
			}
		}
		return n;
	}

	public static <T> Node<T> createAnyTypeOfNode() {
		System.out.println("Enter the type of the Node (int/char/String/double/long/float/short): ");
		String str = in.next();
		System.out.println("Build reversed or straight ? (r / s)");
		String question = in.next();
		System.out.println();
		Node<T> n = null;
		if (question.equalsIgnoreCase("r")) {
			if (str.equalsIgnoreCase("int")) {

				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter an int");
					n = (Node<T>) new Node<Integer>(in.nextInt(), (Node<Integer>) n);
				}
			}
			if (str.equalsIgnoreCase("char")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a char");
					n = (Node<T>) new Node<Character>(in.next().charAt(0), (Node<Character>) n);
				}
			}
			if (str.equalsIgnoreCase("String")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a String");
					n = (Node<T>) new Node<String>(in.next(), (Node<String>) n);
				}
			}
			if (str.equalsIgnoreCase("double")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a double");
					n = (Node<T>) new Node<Double>(in.nextDouble(), (Node<Double>) n);
				}
			}
			if (str.equalsIgnoreCase("long")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a long");
					n = (Node<T>) new Node<Long>(in.nextLong(), (Node<Long>) n);
				}
			}
			if (str.equalsIgnoreCase("float")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a float");
					n = (Node<T>) new Node<Float>(in.nextFloat(), (Node<Float>) n);
				}
			}
			if (str.equalsIgnoreCase("short")) {
				System.out.println("Enter the length");
				int leng = in.nextInt();
				for (int i = 0; i < leng; i++) {
					System.out.println("Enter a short");
					n = (Node<T>) new Node<Short>(in.nextShort(), (Node<Short>) n);
				}
			}
		} else {
			n = createAnyTypeOfNode(str);
		}
		return n;

	}

	public static int ex32(Node<Integer> list1, Node<Integer> list2) {
		long len1 = len(list1);
		long len2 = len(list2);

		int val = 0;

		if (len1 == len2) {
			if (list1.getValue() > list2.getValue())
				val = 2;
			if (list2.getValue() > list1.getValue())
				val = 1;
			if (list1.getValue() == list2.getValue())
				val = 0;
		}
		if (len1 > len2) {
			val = 2;
		}
		if (len1 < len2) {
			val = 0;
		}
		return val;
	}

	public static Integer[] copyArrayToArrayWithGreaterLength(Integer[] a, Integer[] b) {
		Integer[] c = new Integer[b.length];
		for (int i = 0; i < a.length; i++) {
			c[i] = a[i];
			System.out.println("Copying");// Ma'akav
			System.out.println();
			System.out.println(Arrays.toString(c));// Ma'akav
			System.out.println();
		}
		c = ArrayIntializer(c);
		return c;
	}

	public static Node<Integer> ex34(Node<Integer> list1, Node<Integer> list2) {
		Integer[] a = null;
		Integer[] b = null;
		Integer[] c = null;
		if (len(list1) == len(list2)) {
			c = new Integer[len(list1)];
			a = new Integer[len(list1)];
			b = new Integer[len(list1)];
			for (int i = 0; i < c.length; i++) {
				a[i] = list1.getValue();
				System.out.println(Arrays.toString(a));
				b[i] = list2.getValue();
				System.out.println(Arrays.toString(b));
				if (list1.getNext() != null && list2.getNext() != null) {
					list1 = list1.getNext();
					list2 = list2.getNext();
				}
				c[i] = a[i] + b[i];
			}
		}
		if (len(list1) > len(list2)) {
			c = new Integer[len(list1)];
			c = ArrayIntializer(c);

			a = convertNodeToIntegerArray(list1);
			b = convertNodeToIntegerArray(list2);
			b = copyArrayToArrayWithGreaterLength(b, a);

			for (int i = 0; i < c.length; i++)
				c[i] = a[i] + b[i];
			System.out.println("In C");
			System.out.println(Arrays.toString(c));
		} else

		{
			c = new Integer[len(list2)];
			c = ArrayIntializer(c);
			a = convertNodeToIntegerArray(list1);
			b = convertNodeToIntegerArray(list2);
			a = copyArrayToArrayWithGreaterLength(a, b);

			for (int i = 0; i < c.length; i++) {

				System.out.println("In C else");
				System.out.println(Arrays.toString(c));
				c[i] = b[i] + a[i];
			}
		}
		Node<Integer> n = convertArrayToNodeInteger(c);
		System.out.println("Final");
		System.out.println(Arrays.toString(a));// Ma'akav
		System.out.println(Arrays.toString(b));// Ma'akav
		System.out.println(Arrays.toString(c));// Ma'akav
		System.out.println(n);
		return n;
	}

	public static Integer[] ArrayIntializer(Integer[] a) {
		System.out.println("Intializing");
		for (int i = 0; i < a.length; i++) {
			if (a[i] == null) {
				a[i] = 0;
			}

		}
		return a;
	}

	public static Node<Integer> convertArrayToNodeInteger(Integer[] a) {
		Node<Integer> n = null;
		Node<Integer> p = null;
		if (n == null) {
			n = new Node<Integer>(a[0]);
			p = n;
			for (int i = 1; i < a.length; i++) {
				p.setNext(new Node<Integer>(a[i]));
				p = p.getNext();
			}
		}
		return n;
	}

	public static Node<Integer> ex35(Node<Integer> headA, Node<Integer> headB) {
		Node<Integer> headC = null;
		if (headA == null) {
			return headB;
		}
		if (headB == null) {
			return headB;
		}
		if (headA.getValue() <= headB.getValue()) {
			headC = headA;
			headC.setNext(ex35(headA.getNext(), headB));
		} else {
			headC = headB;
			headC.setNext(ex35(headA, headB.getNext()));
		}
		return headC;
	}

	// Recursion Methods :
	public static int sumOfNodeValues(Node<Integer> n) {
		if (n == null) {
			return 0;
		}
		return sumOfNodeValues(n.getNext()) + n.getValue();
	}

	public static int ex43(Node<Integer> head) {
		if (head == null) {
			return 0;
		}
		if (head.getValue() % 2 == 0)
			return ex43(head.getNext()) + 1;
		return ex43(head.getNext());
	}

	public static <T> void ex44(Node<T> head) {
		if (head != null && head.getNext() != null) {
			System.out.println(head.getNext().getValue());
			ex44(head.getNext().getNext());
		}
	}

	public static int ex46(Node<Integer> lst1, Node<Integer> lst2) {

		if (lst1 == null && lst2 == null) {
			return 0;
		}
		if (lst1 == null) {
			return ex46(lst1, lst2.getNext()) - 1;
		}
		if (lst2 == null) {
			return ex46(lst1.getNext(), lst2) + 1;
		}
		return ex46(lst1.getNext(), lst2.getNext());

	}

	public static Node<Integer> direct(int num, int len) { // Creates a node
		Node<Integer> chain = null, p = null;
		System.out.println("Enter a value");
		for (int i = 0; i < len; i++) {
			if (chain == null) {
				chain = new Node<Integer>(num);
				p = chain;
			} else {
				p.setNext(new Node<Integer>(num));
				p = p.getNext();
			}
		}
		return chain;
	}

	public static Node<Integer> ex34VersionB(Node<Integer> lst1, Node<Integer> lst2) {
		Node<Integer> c = null;
		int carrier = 0;
		int base = 0;

		int len1 = len(lst1);
		int len2 = len(lst2);
		if (len1 > len2)
			while (len1 > len2) {
				c = new Node<Integer>((lst1.getValue()), c);
				lst1 = lst1.getNext();
				len1--;
			}
		else if (len1 < len2)
			while (len1 < len2) {
				c = new Node<Integer>((lst2.getValue()), c);
				lst2 = lst2.getNext();
				len2--;
			}
		if (len1 == len2) {
			while (len1 > 0) {
				if (lst1.getValue() + lst2.getValue() > 9) {
					carrier = (lst1.getValue() + lst2.getValue()) / 10;
					base = (lst1.getValue() + lst2.getValue()) % 10;
					if (c == null)
						c = new Node<Integer>(carrier, c);
					c.setValue(c.getValue() + carrier);
					c = new Node<Integer>(base, c);
					lst1 = lst1.getNext();
					lst2 = lst2.getNext();
					len1--;
				} else {
					c = new Node<Integer>(lst1.getValue() + lst2.getValue(), c);
					lst1 = lst1.getNext();
					lst2 = lst2.getNext();
					len1--;
				}

			}
		}

		c = reverseToStaright(c);

		return c;
	}

	public static Node<Integer> ex35VersionB(Node<Integer> n1, Node<Integer> n2) {
		Node<Integer> n = null, p = null, p1 = n1, p2 = n2;
		int num = 0;
		if (p1.getValue() < p2.getValue()) {
			num = p1.getValue();
			p1 = p1.getNext();
		}
		if (p1.getValue() > p2.getValue()) {
			num = p2.getValue();
			p2 = p2.getNext();
		}
		if (n == null) {
			n = new Node<Integer>(num);
			p = n;
		}

		while (p1 != null) {
			p.setNext(new Node<Integer>(p1.getValue()));
			p1 = p1.getNext();
			p = p.getNext();
		}

		while (p2 != null) {
			p.setNext(new Node<Integer>(p2.getValue()));
			p2 = p2.getNext();
			p = p.getNext();
		}
		System.out.println(n);
		return n;
	}

	public static Node<Integer> reverseToStaright(Node<Integer> c) {
		Node<Integer> chain = null;
		while (c != null) {
			chain = new Node<Integer>(c.getValue(), chain);
			c = c.getNext();
		}
		return chain;
	}

	public static int findMax(Node<Integer> n) {
		Node<Integer> p = n;
		if (p == null)
			return -1;
		int max = p.getValue();
		p = p.getNext();

		while (p != null) {

			if (p.getValue() > max) {
				max = p.getValue();
				p = p.getNext();
			} else {
				p = p.getNext();
			}
		}
		return max;
	}

	public static int findMin(Node<Integer> n) {
		Node<Integer> p = n;
		if (p == null)
			return -1;
		int min = p.getValue();
		p = p.getNext();

		while (p != null) {

			if (p.getValue() < min) {
				min = p.getValue();
				p = p.getNext();
			} else {
				p = p.getNext();
			}
		}
		return min;
	}

	public static Node<Integer> deleteByValue(Node<Integer> c, int val) {
		if (c.getValue() == val) {
			c = c.getNext();
			return c.getNext();
		}

		Node<Integer> p = c;
		while (p.hasNext()) {
			if (p.getNext().getValue() == val) {
				p.setNext(p.getNext().getNext());
				System.out.println("DELETED");
				System.out.println(c);
				return c;
			}
			p = p.getNext();
		}

		return null;
	}

	public static Node<Integer> delMax(Node<Integer> c, int n) { // Ex14 page 76
		int max;
		for (int i = 0; i < n; i++) {
			max = findMax(c);
			c = delMax(c, max);
		}
		return c;
	}

	public static void delEven(Node<Integer> c) {
		// The length is at least 4
		/*
		 * FROM THE MIDDLE ONLY
		 */
		Node<Integer> p = c;
		int n = len(c);
		n = n / 2;
		for (int i = 1; i < n - 1; i++) {
			p = p.getNext();
		}
		if (p.getNext().getValue() < p.getNext().getNext().getValue())
			p = p.getNext();
		p.setNext(p.getNext().getNext());

	}

	public static <T> Node<T> delFirstLast(Node<T> c) {
		Node<T> p = c;
		while (p.getNext().getNext() != null) {
			p = p.getNext();
		}
		p.setNext(null);
		c = c.getNext();
		return c;
	}

	public static Node<Integer> del(Node<Integer> c) {
		int n = len(c);
		if (n == 2)
			if (c.getValue() > c.getNext().getValue()) {
				c = c.getNext();
				return c;
			} else {
				c.setNext(null);
				return c;
			}
		if (n == 1)
			return null;
		if (n % 2 == 0) {
			delEven(c);
			return c;
		}
		return delFirstLast(c);
	}

	// EX36 PAGE 96

	public static Node<Integer> ex36() {
		Node<Integer> p = null;
		System.out.println("ENTER A NUMBER");
		int num = in.nextInt();
		if (num != -999)
			p = new Node<Integer>(num);
		else
			return null;
		while (num != -999) {
			while (p != null) {
				System.out.println("ENTER A NUMBER");
				num = in.nextInt();
				if (p.hasNext())
					p = p.getNext();
				else
					p.setNext(new Node<Integer>(num));
			}
		}
		return p;
	}

	public static Node<Integer> sort(Node<Integer> p) {
		Node<Integer> head = p;
		Node<Integer> backup = null;
		Node<Integer> sorted = null;
		if (p == null)
			return null;
		// CASE 2: NODE IS ONLY OF 2:
		// ##########################
		// 2 --> 1 ==> 1 --> 2
		if (p.getNext().getNext() == null)
			if (p.getValue() > p.getNext().getValue()) {
				int temp = p.getNext().getValue();
				p.getNext().setValue(p.getValue());
				p.setValue(temp);
				return p;
			}

		// int min = findMin(head);
		// head = deleteByValue(head, min);
//		if (sorted == null) {
//			sorted = new Node<Integer>(min);
//			backup = sorted;
//		}

		while (head.hasNext()) {
			int min = findMin(head);
			head = deleteByValue(head, min);
			if (sorted == null) {
				sorted = new Node<Integer>(min);
				backup = sorted;
			} else {

				backup.setNext(new Node<Integer>(min));
				backup = backup.getNext();
			}
		}

//		backup.setNext(new Node<Integer>(head.getValue()));
		System.out.println("SORTED");
		System.out.println(sorted);
		return sorted;
	}

	public static void invertNodeRecursion(Node<Integer> p, Node<Integer> q) {
		int x, y;
		if ((p != q) && (q.getNext() != p)) {
			x = p.getValue();
			y = q.getValue();
			if (x != y) {
				p.setValue(y);
				q.setValue(x);
			}
			Node<Integer> prev = p;
			while (prev.getNext() != q)
				prev = prev.getNext();
			invertNodeRecursion(p.getNext(), prev);
		}
	}

	// RECURSION

	public static <T> Node<T> copy(Node<T> t) {
		Node<T> k = t;
		Node<T> j = null;
		while (k != null) {
			if (j == null) {
				j = new Node<T>(k.getValue());
				k = k.getNext();
			}
			j.setNext(new Node<T>(k.getValue(), j.getNext()));
			k = k.getNext();
		} // 1->null
			// 1->2->null
			//
		return j;
	}

	public static Node<Character> s(Node<Character> c) {
//		while (c != null && c.hasNext()) {
//			c = sex(c);
//		}
		return c;

	}

	public static void main(String[] args) {
		Node<Character> first = createAnyTypeOfNode();
		System.out.println(first);
		first = copy(first);
		System.out.println(first);

	}

}
