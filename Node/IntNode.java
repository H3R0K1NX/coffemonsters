package Node;

public class IntNode {

	private int value;
	private IntNode next;

	public IntNode(int value) {
		this.value = value;
	}

	public IntNode(int value, IntNode next) {

		this.value = value;
		this.next = next;
	}

	public int getValue() { // RETURNS THE VALUE OF NODE
		return value;
	}

	public void setValue(int value) { // SETS THE VALUE OF NODE
		this.value = value;
	}

	public IntNode getNext() { // RETURNS VALUE OF NEXT NODE
		return next;
	}

	public void setNext(IntNode next) { // SETS THE VALUE OF NEXT NODE
		this.next = next;
	}

//	public String toString() {
//		return value + "-->" + next;
//	}

	@Override
	public String toString() {
		if (this.next == null)
			return this.value + "";
		return this.value + "-->" + this.next;
	}

	public static void main(String[] args) { // BEGIN MAIN

//		System.out.println(ServiceIntNode.direct());
//		System.out.println(ServiceIntNode.rev());
//		System.out.println(ServiceIntNode.methodEx1(1500));
		/*
		 * IntNode p = ServiceIntNode.direct(); System.out.println(p); //
		 * ServiceIntNode.delEven(p); // System.out.println(p);
		 * ServiceIntNode.delOdd(p); System.out.println(p);
		 */

		IntNode p = ServiceIntNode.direct();
		System.out.println(p);
		ServiceIntNode.deleteByValue(p, 2);
		System.out.println(p);
	}

}
