package Ido_Queue;

import java.util.Scanner;

public class Queue_Main {

	public static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {
//		Queue<Integer> q1 = new Queue<Integer>(1);
//		System.out.println("... \n");
//		for (int i = 2; i < 6; i++) {
//			q1.insert(i);
//			System.out.println("..." + i + "...\n");
//		}
//		System.out.println("...End of Loop...\n");
//		System.out.println(q1 + "\n");
//		System.out.println("... \n");
//
//		for (int i = 0; i < 2; i++) {
//			q1.remove();
//			System.out.println("...REMOVED " + (i + 1) + "...\n");
//		}
//		System.out.println("...End of Second Loop...\n");
//		q1.insert(10);
//		System.out.println("... \n");
//		System.out.println(q1);
//		System.out.println("... \n");

		System.out.println("Noder");
		Queue<Integer> q2 = new Queue<Integer>();
		for (int i = 0; i < 8; i++) {
			System.out.println("Insert the " + (i + 1) + " value");
			q2.insert(in.nextInt());
		}
		System.out.println("The Queue :");
		System.out.println(q2 + "\n");
		System.out.println("The Stack :");
		System.out.println(serviceQueue.ex5(q2));

	}

}
