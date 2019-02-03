package Stack;

import java.util.Scanner;

public class serviceStack {

	public static Scanner in = new Scanner(System.in);

//	public static <T> void fill(Stack<T> s) {
////		T value;
//
//		String typeOfStack = "";
//		if (s.top() instanceof Character)
//			typeOfStack = "Character";
//		else if (s.top() instanceof Integer)
//			typeOfStack = "Integer";
//		else if (s.top() instanceof Long)
//			typeOfStack = "Long";
//		else if (s.top() instanceof Short)
//			typeOfStack = "Short";
//		else if (s.top() instanceof String)
//			typeOfStack = "String";
//
//		String more = "yes";
//
//		switch (typeOfStack) {
//		case "Integer":
//			Integer value;
//			while (more.equalsIgnoreCase("yes")) {
//				System.out.println("Enter an integer");
//				value = in.nextInt();
//				if(s.top() instanceof Integer)
//				s.push(value);
//				System.out.println("Continue ?");
//				more = in.next();
//			}
//
//		}
//
//	}

	public static <T> Stack<T> copy(Stack<T> s) {
		Stack<T> help = new Stack<T>();
		Stack<T> h = new Stack<T>();
		while (!s.isEmpty()) {
			help.push(s.top());
		}
		while (!help.isEmpty()) {
			s.push(help.top());
			h.push(help.pop());
		}
		return h;
	}

	public static String compareStrings(String str1, String str2) {
		char ch1, ch2;
		while (str1.length() > 0 && str2.length() > 0) {
			ch1 = str1.charAt(0);
			ch2 = str2.charAt(0);
			if (ch1 > ch2)
				return "bigger";
			if (ch1 < ch2)
				return "smaller";
			str1.substring(0);
			str2.substring(0);
		}
		return "equal";
	}

	// Inserts in a sorted manner
	public static <T> void sortedInsert(Stack<T> s, T x) {
		Stack<T> help = new Stack<T>();
		String typeOfStack = "";
		if (s.top() instanceof Character)
			typeOfStack = "Character";
		else if (s.top() instanceof Integer)
			typeOfStack = "Integer";
		else if (s.top() instanceof Long)
			typeOfStack = "Long";
		else if (s.top() instanceof Short)
			typeOfStack = "Short";
		else if (s.top() instanceof String)
			typeOfStack = "String";

		System.out.println("Enter :");
		System.out.println("1 - If the stack is sorted so that its top is the smallest");
		System.out.println("2 - If the stack is sorted so that its top is the biggest");
		int wayOfSorting = in.nextInt();

		switch (wayOfSorting) {
		case 1:
			switch (typeOfStack) {
			case "Character":
				while (!s.isEmpty() && (Character) s.top() < (char) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;

			case "Integer":
				while (!s.isEmpty() && (Integer) s.top() < (int) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;

			case "Long":
				while (!s.isEmpty() && (Long) s.top() < (long) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			case "Short":
				while (!s.isEmpty() && (Short) s.top() < (short) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			case "String":
				while (!s.isEmpty() && compareStrings((String) s.top(), (String) x).equals("smaller")) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			}
			break;

		case 2:
			switch (typeOfStack) {
			case "Character":
				while (!s.isEmpty() && (Character) s.top() > (char) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;

			case "Integer":
				while (!s.isEmpty() && (Integer) s.top() > (int) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;

			case "Long":
				while (!s.isEmpty() && (Long) s.top() > (long) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			case "Short":
				while (!s.isEmpty() && (Short) s.top() > (short) x) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			case "String":
				while (!s.isEmpty() && compareStrings((String) s.top(), (String) x).equals("bigger")) {
					help.push(s.pop());
				}
				s.push(x);
				while (!help.isEmpty())
					s.push(help.pop());
				break;
			}
			break;
		}
	}

	public static <T> void sort(Stack<T> s) {
		Stack<T> help = new Stack<T>();
		Stack<T> remember = new Stack<T>();
		boolean printStages = false;

		String typeOfStack = ""; // The type of the stack
		if (s.top() instanceof Character)
			typeOfStack = "Character";
		else if (s.top() instanceof Integer)
			typeOfStack = "Integer";
		else if (s.top() instanceof Long)
			typeOfStack = "Long";
		else if (s.top() instanceof Short)
			typeOfStack = "Short";
		else if (s.top() instanceof String)
			typeOfStack = "String";
		else if (s.top() instanceof Double)
			typeOfStack = "Double";
		else if (s.top() instanceof Ring)
			typeOfStack = "Ring";

		System.out.println("Enter :");
		System.out.println("1 - If the stack is sorted so that its top is the smallest");
		System.out.println("2 - If the stack is sorted so that its top is the biggest");
		int wayOfSorting = in.nextInt(); // Sorting "direction"

		System.out.println("Would you like the method to print the sorting stages ? (yes or no)");
		if (in.next().equalsIgnoreCase("yes"))
			printStages = true; // To print or not to print the stages of the sort

		while (!s.isEmpty()) {
			help.push(s.pop());
		}
		s.push(help.pop());

		switch (wayOfSorting) {
		case 1:
			switch (typeOfStack) {
			case "Integer":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Integer) help.top() <= (int) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Integer) help.top() > (int) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Long":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Long) help.top() <= (long) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Long) help.top() > (long) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Short":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Short) help.top() <= (short) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Short) help.top() > (short) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Character":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Character) help.top() <= (char) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Character) help.top() > (char) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "String":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if (compareStrings((String) help.top(), (String) s.top()).equals("smaller") || // (Down below) we
																									// may write:
																									// (String)help.top().equals((String)s.top());
							compareStrings((String) help.top(), (String) s.top()).equals("equal")) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && compareStrings((String) help.top(), (String) s.top()).equals("bigger")) {
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Ring":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if (Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("bigger")
							|| Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("equal")) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("smaller")) { // to
																															// change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			}// End of the switch
			break;

		case 2:
			switch (typeOfStack) {
			case "Integer":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Integer) help.top() >= (int) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Integer) help.top() < (int) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Long":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Long) help.top() >= (long) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Long) help.top() < (long) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Short":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Short) help.top() >= (short) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Short) help.top() < (short) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Character":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if ((Character) help.top() >= (char) s.top()) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && (Character) help.top() < (char) s.top()) { // to change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "String":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if (compareStrings((String) help.top(), (String) s.top()).equals("bigger") || // (Down below) we
																									// may write:
																									// (String)help.top().equals((String)s.top());
							compareStrings((String) help.top(), (String) s.top()).equals("equal")) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty()
								&& compareStrings((String) help.top(), (String) s.top()).equals("smaller")) {
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			case "Ring":
				while (!help.isEmpty()) { // The beginning of the sort itself

					if (printStages) // Printing the sorting stages (by preference)
						System.out.println(s + "\n");

					if (Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("smaller")
							|| Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("equal")) {
						s.push(help.pop());
					} else {
						while (!s.isEmpty() && Ring.compareSizes((Ring) help.top(), (Ring) s.top()).equals("bigger")) { // to
																														// change
							remember.push(s.pop());
						} // Closes the closest while
						s.push(help.pop());
						while (!remember.isEmpty()) {
							s.push(remember.pop());
						} // Closes the closest while
					} // Closes the "else"
				} // Closes the widest while
				break;
			}// End of the switch
			break;
		}// End of the main switch (The "wayOfSorting" one)
	}// End of the method "sort"

}
