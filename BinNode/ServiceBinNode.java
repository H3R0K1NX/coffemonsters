package BinNode;

import java.util.ArrayList;
import java.util.Scanner;

import Node.Node;

public class ServiceBinNode {

	public static Scanner in = new Scanner(System.in);
	private static int count;

	public static BinNode<Integer> buildIntegerBinTree() {
		String question = "";
		System.out.println("Enter the value of the root"); // (null) (1) (null)
		BinNode<Integer> bin = new BinNode<Integer>(in.nextInt());
		BinNode<Integer> pointer = null;
		System.out.println("Write " + ("yes") + " in order to continue");
		String whileQuestion = in.next();
		String tempQuestion = null;
		String Qleft = null, QRight = null;

		if (bin.getLeft() == null) {
			System.out.println("Do you want to have a left Node from the root? (yes/no)");
			if (in.next().equals("yes")) {
				System.out.println("Enter a value");
				bin.setLeft(new BinNode<Integer>(in.nextInt()));
			}
		}
		if (bin.getRight() == null) {
			System.out.println("Do you want to have a right Node from the root? (yes/no)");
			if (in.next().equals("yes")) {
				System.out.println("Enter a value");
				bin.setRight(new BinNode<Integer>(in.nextInt()));
			}
		}
		pointer = bin;
		while (whileQuestion.equals("yes")) {
			System.out.println("Which direction? (left/right)");
			question = in.next();
			if (question.equals("left")) {
				System.out.println("Enter the value of the left leaf");
				pointer = pointer.getLeft();
				pointer.setLeft(new BinNode<Integer>(in.nextInt()));
				System.out.println("Continue? (no/yes)");
				tempQuestion = in.next();
				if (tempQuestion.equals("no"))
					whileQuestion = "no";
				if (tempQuestion.equals("yes")) {

				}
			}
			if (question.equals("right")) {
				System.out.println("Enter the value of the right leaf");
				pointer = pointer.getRight();
				pointer.setRight(new BinNode<Integer>(in.nextInt()));
				System.out.println("Continue? (no/yes)");
				tempQuestion = in.next();
				if (tempQuestion.equals("no"))
					whileQuestion = "false";
			}
			System.out.println("BINNODE" + "\n" + bin);
		}
		return bin;
	}

	// Build BinNode by the book
	public static BinNode<Integer> readIntegerBinNode() {
		System.out.println("Enter integer root value (Enter -1 for end):");
		return readIntegerTree();
	}

	public static BinNode<Integer> readIntegerTree() {
		int value = in.nextInt();
		if (value == -1)
			return null;
		System.out.println("Enter left of " + value + "(or enter -1 to null)");
		BinNode<Integer> left = readIntegerTree();
		System.out.println("Enter right of " + value + "(or enter -1 to null)");
		BinNode<Integer> right = readIntegerTree();
		return new BinNode<Integer>(left, value, right);
	}// End Build BinNode

	// Itay's build method
	public static BinNode<Integer> buildBinInt(Scanner in) {
		return buildBinInt(in, 0);
	}

	public static BinNode<Integer> buildBinInt(Scanner in, int depth) {
		System.out.println("Depth #" + depth);
		System.out.println("Continue? -1 to stop");
		if (in.nextInt() == -1) {
			return null;
		}
		System.out.println("Enter value:");
		int v = in.nextInt();
		BinNode<Integer> ret = new BinNode<Integer>(v);
		System.out.print("Left: ");
		BinNode<Integer> left = buildBinInt(in, depth + 1);
		ret.setLeft(left);
		System.out.print("Right: ");
		BinNode<Integer> right = buildBinInt(in, depth + 1);
		ret.setRight(right);
		return ret;
	}

	// End of Itay's Method

	// Counts of the times of x in BinNode t (#1)
	public static int howMany(BinNode<Integer> t, int x) {
		if (t == null)
			return 0;
		if (t.getValue() == x)
			return 1 + howMany(t.getLeft(), x) + howMany(t.getRight(), x);
		return howMany(t.getLeft(), x) + howMany(t.getRight(), x);
	}

	// Counts the number of nodes in BinNode t (#2)
	public static <T> int numNodes(BinNode<T> t) {
		if (t == null)
			return 0;
		return numNodes(t.getLeft()) + numNodes(t.getRight()) + 1;
	}

	// Checks if char exists in BinNode t (#3)

	public static boolean charExists(BinNode<Character> t, char x) {
		if (t == null)
			return false;
		if (t.getValue() == x)
			return true;
		return charExists(t.getLeft(), x) || charExists(t.getRight(), x);
	}

	// Checks if char exists in BinNode t (#3B)

	public static boolean integerExists(BinNode<Integer> t, int x) {
		if (t == null)
			return false;
		if (t.getValue() == x)
			return true;
		return integerExists(t.getLeft(), x) || integerExists(t.getRight(), x);
	}

	public static <T> boolean checkIfLeaf(BinNode<T> t) {
		if (t == null)
			return false;
		return (t.getLeft() == null && t.getRight() == null);
	}

	// Page 176 Question 9:

	public static void QuestionNine(BinNode<Character> t) {
		if (t != null) {
			if (t.getValue() == 'z')
				t.setValue('a');
			else
				t.setValue((char) (t.getValue() + 1));
			QuestionNine(t.getLeft());
			QuestionNine(t.getRight());
		}
	}

	// Page 176 Question 10:

	public static void QuestionTen(BinNode<Integer> t) {
		if (t != null) {
			if (checkIfLeaf(t))
				System.out.println(t.getValue());
			QuestionTen(t.getLeft());
			QuestionTen(t.getRight());
		}
	}

	// Page 176 Question 11:

	public static void printEven(BinNode<Integer> t) {
		if (t != null) {
			if (checkIfLeaf(t) && t.getValue() % 2 == 0)
				System.out.println(t.getValue());
			else if (t.hasLeft() && t.hasRight() && t.getValue() % 2 == 0 && t.getLeft().getValue() % 2 == 0
					&& t.getRight().getValue() % 2 == 0)
				System.err.println(t.getValue());
			else if (t.hasLeft() && t.getValue() % 2 == 0 && t.getLeft().getValue() % 2 == 0)
				System.out.println(t.getValue());
			else if (t.hasRight() && t.getValue() % 2 == 0 && t.getRight().getValue() % 2 == 0)
				System.out.println(t.getValue());
			printEven(t.getLeft());
			printEven(t.getRight());
		}
	}

	public static boolean isNodeEven(BinNode<Integer> t) {
		return t.getValue() % 2 == 0;
	}

	public static <T> boolean hasChild(BinNode<T> t) {
		return t.hasLeft() || t.hasRight();
	}

	// Page 176 Question 12:

	public static boolean conditionTwelve(BinNode<Integer> t) {
		if (t.getValue() >= 10 && t.getValue() < 100)
			return true;
		else
			return false;
	}

	public static int QuestionTwelve(BinNode<Integer> t) {
		int isIt = 0;
		if (t != null) {
			if (t.getValue() >= 10 && t.getValue() < 100)
				isIt = 1;
		}
		return QuestionTwelve(t.getLeft()) + QuestionTwelve(t.getRight()) + isIt;
	}

	// Page 177 Question 17:

	public static int QuestionSevenTeen(BinNode<Integer> t) {
		int isIt = 0;
		if (t == null)
			return 0;
		if (t.hasLeft() && t.hasRight() && !checkIfLeaf(t.getLeft()) && !checkIfLeaf(t.getRight()))
			isIt = 1;
		return QuestionSevenTeen(t.getLeft()) + QuestionSevenTeen(t.getRight()) + isIt;
	}

	// Page 177 Question 18:

	public static boolean QuestionEightTeen(BinNode<Integer> t1, BinNode<Integer> t2) { // O(m*n) = O(n^2)
		// O(n) - Nodes in T1
		// O(m) - Nodes in T2
		if (t2 == null)
			return true;
		if (!integerExists(t1, t2.getValue()))
			return false;
		return QuestionEightTeen(t1, t2.getLeft()) && QuestionEightTeen(t1, t2.getRight());
	}

	// Page 175 Ex2
	// 10,5,3, 18, 23, 30, 12, 6 -- PreOrder -- The root is at the begging
	// 5, 3, 10, 23, 18, 12, 30 , 6 -- In order -- The root is at the middle
	// 3,5, 23, 12, 6 ,30, 18, 10 -- Post order -- The root is at the end

	// Board exercise:
	// 13, 11, 9, 4, 6, 8, 5, 5, 3, 7, 10, 12, 2 -- PreOrder -- The root is 13
	// 4, 6, 9, 11, 13, 3, 7, 5, 5 ,8, 12, 10, 2 -- In order -- The root is 13
	// 6, 4, 9, 11, 7, 3, 5, 5, 12, 2, 10, 8, 13 -- Post Order -- The root is 13

	// Page 176 Ex13

	public static void QuestionTheerteen(BinNode<Integer> t) {
		int numL, numR;
		if (t != null && !checkIfLeaf(t)) {
			if (!t.hasRight() || !t.hasLeft()) {

				if (t.hasRight())
					System.out.println(t.getRight().getValue());
				else
					System.out.println(t.getLeft().getValue());
			} else {
				numR = Math.abs(t.getValue() - t.getRight().getValue());
				numL = Math.abs(t.getValue() - t.getLeft().getValue());
				if (numR < numL)
					System.out.println(t.getRight().getValue());
				else
					System.out.println(t.getLeft().getValue());
			}
			QuestionTheerteen(t.getLeft());
			QuestionTheerteen(t.getRight());
		}
	}

	// Page 176 Ex14

	public static <T> int getLeafs(BinNode<T> bn) {
		if (!bn.hasLeft() && !bn.hasRight()) {
			return 1;
		}
		if (!bn.hasLeft()) {
			return getLeafs(bn.getRight());
		}
		if (!bn.hasRight()) {
			return getLeafs(bn.getLeft());
		}
		return getLeafs(bn.getLeft()) + getLeafs(bn.getRight());

	}

	// Page 176 Ex15

	public static int inRange(BinNode<Integer> t, int low, int high) {
		if (t != null) {
			if (t.hasLeft())
				if (t.getLeft().getValue() >= low && t.getLeft().getValue() <= high)
					return 1 + inRange(t.getLeft(), low, high);
			if (t.hasRight())
				if (t.getRight().getValue() >= low && t.getRight().getValue() <= high)
					return 1 + inRange(t.getRight(), low, high);
			if (t.hasLeft() && t.hasRight())
				if (t.getLeft().getValue() >= low && t.getLeft().getValue() <= high && t.getRight().getValue() >= low
						&& t.getRight().getValue() <= high)
					return 1 + inRange(t.getLeft(), low, high) + 1 + inRange(t.getRight(), low, high);
		}
		return 0;
	}

	// Page 176 Ex16

	public static int sumBranches(BinNode<Integer> bn) {
		if (!bn.hasLeft() && !bn.hasRight()) {
			return 0;
		}
		if (!bn.hasLeft()) {
			return sumBranches(bn.getRight());
		}
		if (!bn.hasRight()) {
			return sumBranches(bn.getLeft());
		}
		return bn.getValue() + sumBranches(bn.getLeft()) + sumBranches(bn.getRight());
	}

	// Calculates The height of a bin tree

	public static <T> int height(BinNode<T> t) {
		if (t == null)
			return -1;
		return 1 + Math.max(height(t.getLeft()), height(t.getRight()));
	}

	// Page 177 Ex19

	// Page 177 Ex20

	public static <T> int numOfDuplicates(BinNode<T> t, T o) {
		if (t == null)
			if (t.hasLeft())
				if (t.getValue() == o)
					return numOfDuplicates(t.getLeft(), o) + 1;
		if (t.hasRight())
			if (t.getValue() == o)
				return numOfDuplicates(t.getRight(), o) + 1;
		if (t.hasLeft() & t.hasRight())
			if (t.getValue() == o)
				return numOfDuplicates(t.getLeft(), o) + 1 + numOfDuplicates(t.getRight(), o) + 1;

		return 0;
	}

	public static boolean QuestionTwenty(BinNode<Integer> bn) {
		int s = size(bn);
		while (s > 0) {
			if (!integerExists(bn, s)) {
				return false;
			}

		}
		return true;

	}

	public static <T> int size(BinNode<T> bn) {
		if (!bn.hasLeft() && !bn.hasRight()) {
			return 1;
		}
		if (!bn.hasLeft()) {
			return size(bn.getRight()) + 1;
		}

		if (!bn.hasRight()) {
			return size(bn.getLeft()) + 1;
		}
		return size(bn.getLeft()) + size(bn.getRight()) + 1;
	}

	// ex 22

	public static <T> boolean isBalanced(BinNode<T> t) {
		boolean b = false;
		if (t != null) {
			if (t.hasRight() && !t.hasLeft())
				if (t.getRight().hasLeft() && t.getRight().hasRight() // For right side
						|| !(t.getRight().hasLeft() && t.getRight().hasRight())) {
					b = true; // Case 1 & 2
					return b;
				}
			if (!t.hasRight() && t.hasLeft())
				if (t.getLeft().hasLeft() && t.getLeft().hasRight() // For left side
						|| !(t.getLeft().hasLeft() && t.getLeft().hasRight())) {
					b = true; // Case 1 & 2
					return b;
				}
		}
		return b;
	}

	public static <T> boolean balancedTree(BinNode<T> t) {
		if (t != null) {
			if (!checkIfLeaf(t)) {
				if (t.hasRight() && !t.hasLeft())
					if (isBalanced(t.getLeft()))
						return balancedTree(t.getLeft());
				if (t.hasLeft() && !t.hasRight())
					if (isBalanced(t.getRight()))
						return balancedTree(t.getRight());
				if (t.hasRight() && t.hasLeft())
					return balancedTree(t.getLeft()) && balancedTree(t.getRight());
			}
		}
		return false;
	}

	// Ex 24

	// Alef

	public static <T> boolean hasOneSon(BinNode<T> t) {
		if (t == null || checkIfLeaf(t))
			return false;
		return t.hasLeft() != t.hasRight();
	}

	// Bet

	public static <T> int numberOfSingleChildren(BinNode<T> t) {
		if (t == null) {
			if (t.hasRight() && !t.hasLeft())
				if (hasOneSon(t.getRight()))
					return numberOfSingleChildren(t.getRight()) + 1;
				else
					return numberOfSingleChildren(t.getRight());
			if (t.hasLeft() && !t.hasRight())
				if (hasOneSon(t.getLeft()))
					return numberOfSingleChildren(t.getLeft()) + 1;
				else
					return numberOfSingleChildren(t.getLeft());
			if (t.hasLeft() && t.hasRight()) {
				if (hasOneSon(t.getRight()) & hasOneSon(t.getLeft()))
					return numberOfSingleChildren(t.getLeft()) + 1 + numberOfSingleChildren(t.getRight()) + 1;
				if (hasOneSon(t.getLeft()) && !hasOneSon(t.getRight()))
					return numberOfSingleChildren(t.getLeft()) + 1 + numberOfSingleChildren(t.getRight());
				if (hasOneSon(t.getRight()) && !hasOneSon(t.getLeft()))
					return numberOfSingleChildren(t.getLeft()) + numberOfSingleChildren(t.getRight()) + 1;
			}
		}
		return 0;
	}
// Ex 22

	public static <T> boolean cBalanced(BinNode<T> bn) {
		if (bn == null) {
			return true;
		}
		return (bn.hasLeft() ^ bn.hasRight()) && cBalanced(bn.getLeft()) && cBalanced(bn.getRight());

	}

	// ex 26

	public static <T> boolean nSizeTree(BinNode<T> bn) {
		int s = size(bn);
		return (int) (Math.log(s) / Math.log(2)) - Math.log(s) / Math.log(2) == 0;

	}

	// ex 23

	// Alef

	public static double max(BinNode<Double> t) { // O(n)
		if (checkIfLeaf(t))
			return t.getValue();
		if (!t.hasLeft())
			return Math.max(t.getValue(), max(t.getRight()));
		if (!t.hasRight())
			return Math.max(t.getValue(), max(t.getLeft()));
		return Math.max(t.getValue(), Math.max(max(t.getLeft()), max(t.getRight())));
	}

	public static double min(BinNode<Double> t) { // O(n)
		if (checkIfLeaf(t))
			return t.getValue();
		if (!t.hasLeft())
			return Math.min(t.getValue(), min(t.getRight()));
		if (!t.hasRight())
			return Math.min(t.getValue(), min(t.getLeft()));
		return Math.min(t.getValue(), Math.min(min(t.getLeft()), min(t.getRight())));
	}

	/*
	 * 
	 * 
	 * 
	 * 
	 */
	// Fibonacci Algorithem

	public static BinNode<Character> fib(int n) {
		if (n == 1)
			return new BinNode<Character>('*');
		if (n == 2)
			return new BinNode<Character>(fib(1), '*', null);
		return new BinNode<Character>(fib(n - 1), '*', fib(n - 2));
	}

//	public static <T> boolean isSymetric(BinNode<T> t) {
//		if (t == null || checkIfLeaf(t))
//			return true;
//		return Math.abs(height(t.getLeft()) - height(t.getRight()) - height(t.getRight()) <= 1
//				&& isSymetric(t.getLeft()) && isSymetric(t.getRight()));
//	}

	// Search Binary Tree Methods

	public static boolean binExist(BinNode<Integer> t, int x) {
		if (t == null)
			return false;
		if (t.getValue() == x)
			return true;
		if (t.getValue() < x)
			return binExist(t.getRight(), x);
		return binExist(t.getLeft(), x);
	}

	public static int maxBin(BinNode<Integer> t) {
		if (!t.hasRight())
			return t.getValue();
		return maxBin(t.getRight());
	}

	public static int minBin(BinNode<Integer> t) {
		if (!t.hasLeft())
			return t.getValue();
		return minBin(t.getLeft());
	}
// Page 189 ex44

	public static boolean checkIfSearchTree(BinNode<Integer> t) {
		boolean b = false;
		if (t == null)
			return true;
		if (checkIfLeaf(t))
			return true;
		if (!t.hasRight())
			if (t.getValue() <= minBin(t))
				return true;
			else
				return false;
		if (!t.hasLeft())
			if (t.getValue() > maxBin(t))
				return true;
			else
				return false;
		if (t.hasRight() & t.hasLeft())
			if (t.getValue() <= maxBin(t) & t.getValue() > minBin(t))
				b = true;
		return b;
	}

	// Page 189 Ex45

	public static Node<Integer> sortedList(BinNode<Integer> t) {
		Node<Integer> n = null;
		Node<Integer> p = n;
		ArrayList<Integer> a = new ArrayList<>();
		return p;
	}

	// From Bagrut 2016 (T205_16) Ex 2

	public static boolean upPath(BinNode<Integer> tr) {
		if (tr != null) {
			if (!tr.hasRight()) {
				if (tr.getValue() < tr.getLeft().getValue())
					return upPath(tr.getRight());
			}
			if (!tr.hasLeft()) {
				if (tr.getValue() < tr.getRight().getValue())
					return upPath(tr.getLeft());
			}
			if (tr.getValue() < tr.getLeft().getValue() || tr.getValue() < tr.getRight().getValue()) {
				return upPath(tr.getLeft()) || upPath(tr.getRight());
			}

		} else
			return true;
		return false;
	}

	// MAIN for testing
	public static void main(String[] args) {
		BinNode<Integer> bin = readIntegerBinNode();
		// BinNode<Integer> bon = readIntegerBinNode();

//		BinNode<Integer> t1 = new BinNode<Integer>(10);
//		BinNode<Integer> t2 = new BinNode<Integer>(1);

//		t1.setLeft(new BinNode<Integer>(22));
//		t1.getLeft().setRight(new BinNode<Integer>(54));
//		t1.getLeft().setLeft(new BinNode<Integer>(new BinNode<Integer>(5), 2, new BinNode<Integer>(3)));
//		t1.setRight(new BinNode<Integer>(83));
//		t1.getRight().setLeft(new BinNode<Integer>(12));
//		t1.getRight().setRight(new BinNode<Integer>(8));
//
//		t2.setLeft(new BinNode<Integer>(2));
//		t2.getLeft().setRight(new BinNode<Integer>(4));

//		BinNode<Integer> bin = new BinNode<Integer>(1);
//		bin.setLeft(new BinNode<Integer>(2));
//		bin.setRight(new BinNode<Integer>(3));
//		BinNode<Integer> l, r;
//		l = bin.getLeft();
//		r = bin.getRight();
//		l.setLeft(new BinNode<Integer>(4));
//		BinNode<Integer> p = l.getLeft();
//		p.setRight(new BinNode<Integer>(5));

		System.out.println(bin + "\n");
		// System.out.println(t2 + "\n");
		// System.out.println(QuestionEightTeen(t1, t2));
		System.out.println(upPath(bin));
	}

}
