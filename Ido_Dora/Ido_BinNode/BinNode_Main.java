package Ido_BinNode;

public class BinNode_Main {

	public static void main(String[] args) {
		BinNode<Integer> t1 = new BinNode<Integer>(1, 2, 3);
		t1.getLeft().setRight(new BinNode<Integer>(4, 5, 6));
		t1.getRight().setRight(new BinNode<Integer>(7, 8, 9));
		System.out.println(t1);

	}

}
