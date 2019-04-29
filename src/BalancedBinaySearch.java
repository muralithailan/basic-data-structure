
public class BalancedBinaySearch {

	public static void main(String[] args) {

		Node root = new Node(2);
		root.left = new Node(12);
		root.right = new Node(20);
		root.right.right = new Node(30);
		root.right.right.right = new Node(4);

		boolean res = isBalancedTree(root);
		
		System.out.println(res);

	}

	public static boolean isBalancedTree(Node root) {
		return isBalanced(root) == Integer.MIN_VALUE ? false : true;
	}

	private static int isBalanced(Node root) {
		if (root == null) {
			return -1;
		} else {
			int left = isBalanced(root.left);
			if (left == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;
			int right = isBalanced(root.right);
			if (right == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			if (Math.abs(left - right) > 1) {
				return Integer.MIN_VALUE;
			} else {
				return Math.max(left, right) + 1;
			}
		}
		
	}

	static class Node {
		int data;
		Node left;
		Node right;

		Node(int data) {
			this.data = data;
		}
	}

}
