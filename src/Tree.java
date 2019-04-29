import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Tree {

	Node root;

	public void add(int value) {
		if (root == null) {
			root = new Node(value);

		} else {
			add(root, value);
		}
	}

	private void add(Node root, int val) {
		if (root != null) {
			if (val <= root.value) {
				if (root.left != null) {
					add(root.left, val);
				} else {
					root.left = new Node(val);
				}
			} else {
				if (root.right != null) {
					add(root.right, val);
				} else {
					root.right = new Node(val);
				}
			}
		}
	}

	public int height() {
		return height(root);
	}

	private int height(Node root) {
		if (root == null) {
			return -1;
		} else {

			int left = height(root.left);
			int right = height(root.right);

			if (left > right) {
				return left + 1;
			} else {
				return right + 1;
			}
		}
	}

	public void minHeightTree(int[] arr) {
		root = minHeightTree(arr, 0, arr.length - 1);
	}

	private Node minHeightTree(int[] arr, int low, int high) {
		if (high < low) {
			return null;
		} else {
			int mid = (low + high) / 2;

			Node root = new Node(arr[mid]);
			root.left = minHeightTree(arr, low, mid - 1);
			root.right = minHeightTree(arr, mid + 1, high);
			return root;
		}
	}

	public void inOrder() {
		inOrder(root);
	}

	private void inOrder(Node root) {
		if (root != null) {
			inOrder(root.left);
			System.out.println(root.value);
			inOrder(root.right);
		}

	}

	public void breathFirstSearch() {
		Queue<Node> queue = new LinkedList<>();

		queue.add(root);
		while (!queue.isEmpty()) {
			Node node = queue.poll();
			if (node != null) {
				System.out.println(node.value);
				queue.add(node.left);
				queue.add(node.right);
			}

		}
	}

	public void getDepthList() {
		List<LinkedList<Node>> lists = new ArrayList<>();
		getDepthList(root, lists, 0);

		for (LinkedList<Node> nodes : lists) {
			for (Node node : nodes) {
				System.out.print(node.value + " ");
			}
			System.out.println("");
		}
	}

	private void getDepthList(Node root, List<LinkedList<Node>> lists, int depth) {

		if (root == null) {
			return;
		}

		LinkedList<Node> list = null;

		if (lists.size() == depth) {
			list = new LinkedList<>();
			lists.add(list);
		} else {
			list = lists.get(depth);
		}

		list.add(root);
		getDepthList(root.left, lists, depth + 1);
		getDepthList(root.right, lists, depth + 1);
	}

	public void getDepthListIterative() {
		List<LinkedList<Node>> lists = new ArrayList<>();
		getDepthListIterative(root, lists);

		for (LinkedList<Node> nodes : lists) {
			for (Node node : nodes) {
				System.out.print(node.value + " ");
			}
			System.out.println("");
		}
	}

	private void getDepthListIterative(Node root, List<LinkedList<Node>> lists) {

		LinkedList<Node> current = new LinkedList<>();
		if (root != null) {
			current.add(root);
		}

		while (current.size() > 0) {
			lists.add(current);
			LinkedList<Node> parent = current;
			current = new LinkedList<>();
			for (Node node : parent) {

				if (node.left != null) {
					current.add(node.left);
				}

				if (node.right != null) {
					current.add(node.right);
				}
			}

		}

	}

	/**
	 * Is balanced or not
	 * 
	 * @return
	 */
	public boolean isBalanced() {
		return isBalanced(root, new Height());
	}

	private boolean isBalanced(Node root, Height height) {

		if (root == null) {
			height.height = -1;
			return true;
		}

		Height lefth = new Height();
		Height righth = new Height();

		boolean lb = isBalanced(root.left, lefth);
		boolean rb = isBalanced(root.right, righth);

		if (lefth.height > righth.height) {
			height.height = lefth.height + 1;
		} else {
			height.height = righth.height + 1;
		}

		if (Math.abs(lefth.height - righth.height) > 1) {
			return false;
		}
		return lb && rb;
	}

	public boolean isBalancedOptimized() {
		return isBalanced(root) != Integer.MIN_VALUE;
	}

	private int isBalanced(Node root) {
		if (root == null) {
			return -1;
		}

		int leftH = isBalanced(root.left);
		if (leftH == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		int rightH = isBalanced(root.right);
		if (rightH == Integer.MIN_VALUE)
			return Integer.MIN_VALUE;

		if (Math.abs(leftH - rightH) > 1) {
			return Integer.MIN_VALUE;
		} else {
			return Integer.max(leftH, rightH) + 1;
		}
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node root, int min, int max) {
		if (root == null) {
			return true;
		}

		if ((min != Integer.MIN_VALUE && root.value <= min) || (max != Integer.MAX_VALUE && root.value > max)) {
			return false;
		}

		if(!isBinarySearchTree(root.left,min , root.value)
				|| !isBinarySearchTree(root.right,root.value,max)) {
			return false;
		}
		return true;
	}

	static class Height {
		int height;
	}

	static class Node {
		int value;
		Node left;
		Node right;

		Node(int value) {
			this.value = value;
		}
	}

}
