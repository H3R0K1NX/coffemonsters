package BinNode;

import java.util.Scanner;

public class ServiceBinNode {

	public static Scanner in = new Scanner(System.in);

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
	}

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

	public static boolean checkIfNodesChildsIsEven(BinNode<Integer> t) {
		if (t != null) {
			if (t.hasLeft())
				return checkIfNodesChildsIsEven(t.getLeft());
			if (t.hasRight())
				return checkIfNodesChildsIsEven(t.getRight());
			if (checkIfLeaf(t))
				if (t.getValue() % 2 == 0)
					return true;
				else
					return false;
		}
		return false;
	}

	public static boolean isNodeEven(BinNode<Integer> t) {
		return t.getValue() % 2 == 0;
	}

	public static <T> boolean hasChild(BinNode<T> t) {
		return t.hasLeft() || t.hasRight();
	}

	public static void QuestionEleven(BinNode<Integer> t) {
		if (t != null) {
//			if (t.hasLeft())
//				if (hasChild(t.getLeft()))
//					if(isNodeEven(t.getLeft()))
//					System.out.println(t.getLeft());
//			if (t.hasRight())
//				if (hasChild(t.getRight()))
//					System.out.println(t.getRight());
			if (t.hasLeft() && t.hasRight())
				if (isNodeEven(t.getLeft()) && isNodeEven(t.getRight()))
					if (hasChild(t.getLeft()) && hasChild(t.getRight()))
						if (!(isNodeEven(t.getLeft().getLeft()) && isNodeEven(t.getRight().getLeft())
								&& !(isNodeEven(t.getLeft().getRight()) && isNodeEven(t.getRight().getRight()))))
							System.out.println(t.getRight() + "/n" + t.getLeft());

		}
		System.out.println("BinNode is empty");
	}

	// Page 176 Question 12:

	public static boolean conditionTwelve(BinNode<Integer> t) {
		if (t.getValue() >= 10 && t.getValue() < 100)
			return true;
		else
			return false;
	}

	public static int QuestionTwelve(BinNode<Integer> t) {
		if (t != null) {
			if (t.hasLeft() && !t.hasRight())
				if (conditionTwelve(t.getLeft()))
					return 1 + QuestionTwelve(t.getLeft());
			if (t.hasRight() && !t.hasLeft())
				if (conditionTwelve(t.getRight()))
					return 1 + QuestionTwelve(t.getRight());
			if (t.hasLeft() && t.hasRight())
				if (conditionTwelve(t.getLeft()) && conditionTwelve(t.getRight()))
					return 1 + QuestionTwelve(t.getLeft()) + QuestionTwelve(t.getRight());

		}
		return 0;
	}

	// Page 177 Question 17:

	public static int QuestionSevenTeen(BinNode<Integer> t) {
		if (t != null) {
			if (t.hasLeft() & t.hasRight())
				return 1 + QuestionSevenTeen(t.getLeft()) + QuestionSevenTeen(t.getRight());
		}
		return 0;
	}

	// Page 177 Question 18:

	public static boolean QuestionEightTeen(BinNode<Integer> t1, BinNode<Integer> t2) {
		if (t1 != null && t2 != null) {
			if (integerExists(t1, t2.getValue()))
				if (t2.hasLeft() && t2.hasRight())
					return QuestionEightTeen(t1, t2.getLeft()) && QuestionEightTeen(t1, t2.getRight());
			if (t2.hasLeft() && !t2.hasRight())
				return QuestionEightTeen(t1, t2.getLeft());
			if (!t2.hasLeft() && t2.hasRight())
				return QuestionEightTeen(t1, t2.getRight());
		}
		return false;
	}

	// MAIN for testing
	public static void main(String[] args) {
		// BinNode<Integer> bin = readIntegerBinNode();
		// BinNode<Integer> bon = readIntegerBinNode();

		BinNode<Integer> t1 = new BinNode<Integer>(10);
		BinNode<Integer> t2 = new BinNode<Integer>(1);

		t1.setLeft(new BinNode<Integer>(22));
		t1.getLeft().setRight(new BinNode<Integer>(54));
		t1.getLeft().setLeft(new BinNode<Integer>(61));
		t1.setRight(new BinNode<Integer>(83));
		t1.getRight().setLeft(new BinNode<Integer>(12));
		t1.getRight().setRight(new BinNode<Integer>(8));
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

		System.out.println(t1 + "\n");
		// System.out.println(t2 + "\n");
		// System.out.println(QuestionEightTeen(t1, t2));
		QuestionEleven(t1);
	}

}
