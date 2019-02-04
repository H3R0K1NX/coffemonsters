package Ido_BinNode;

public class serviceBinNode {

	public static <T> boolean isLeaf(BinNode<T> t) {
		if (t == null)
			return false;
		return !t.hasLeft() && !t.hasRight();
	}

	public static <T> int numNodes(BinNode<T> t) {
		if (t == null)
			return 0;
		return numNodes(t.getLeft()) + numNodes(t.getRight()) + 1;
	}

}
