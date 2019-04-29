import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeParent {

	Node root;

	public void insert(int data) {
		if (root == null) {
			root = new Node(data);
		} else {
			insert(root, data);
		}
	}

	private void insert(Node root, int data) {
		if (root != null) {
			if (data <= root.data) {
				if (root.left != null) {
					insert(root.left, data);
				} else {
					root.left = new Node(data);
					root.left.parent = root;
				}
			} else {
				if (root.right != null) {
					insert(root.right, data);
				} else {
					root.right = new Node(data);
					root.right.parent = root;
				}
			}
		}

	}

	public Node search(int data) {
		return search(root, data);
	}

	private Node search(Node root, int data) {
		if (root == null) {
			return null;
		} else {
			if (data < root.data) {
				return search(root.left, data);
			} else if (data > root.data) {
				return search(root.right, data);
			} else {
				return root;
			}
		}
	}

	public int nextInorderSuccesor(int data) {
		Node node = search(data);

		Node succ = nextInorderSuccesor(node);

		return succ != null ? succ.data : -1;
	}

	private Node nextInorderSuccesor(Node node) {
		if (node.right != null) {
			return minimumValueNode(node.right);
		} else {
			Node q = node;
			Node x = q.parent;
			while (x != null && x != q) {
				q = x;
				x = x.left;
			}
			return x;
		}
	}

	private Node minimumValueNode(Node node) {
		while (node.left != null) {
			node = node.left;
		}

		return node;
	}

	public void inorder() {
		inorder(root);
	}

	private void inorder(Node root2) {
		if (root2 != null) {
			inorder(root2.left);
			System.out.println(root2.data);
			inorder(root2.right);
		}
	}

	public Node nextInorderSuccesorNoParent(Node node) {
		
		if(node.right!=null) {
			return minimumValueNode(node.right);
		}else {
			Node rightMost = rightMostNode(node);
			if(node == rightMost) {
				return null;
			}else {
				return inOrderSucessorRes(root,node);
			}
			
		}
	}
	
	private Node rightMostNode(Node node) {
		while(node!=null && node.right!=null) {
			node = node.right;
		}
		return node;
	}

	private Node inOrderSucessorRes(Node root, Node node) {

		if (root == null) {
			return null;
		}

		Node n=null;

		if (root == node || (n = inOrderSucessorRes(root.left, node)) != null
				|| (n = inOrderSucessorRes(root.right, node)) != null) {

			if (n != null) {
				if(root.left == n) {
					System.out.println(root.data);
					return null;
				}
			}
			return root;
		}
		return null;
	}

	public void insertFromArray(int[] arr) {
		root = insertFromArray(arr, 0, arr.length - 1);
	}

	private Node insertFromArray(int[] arr, int low, int high) {
		if (low > high) {
			return null;
		} else {

			int mid = (low + high) / 2;
			Node node1 = new Node(arr[mid]);

			node1.left = insertFromArray(arr, low, mid - 1);
			node1.right = insertFromArray(arr, mid + 1, high);
			return node1;
		}

	}

	public int height() {
		return height(root);
	}

	private int height(Node node) {
		if (node == null) {
			return -1;
		} else {
			int leftH = height(node.left);
			int rightH = height(node.right);

			if (leftH > rightH) {
				return leftH + 1;
			} else {
				return rightH + 1;
			}
		}
	}

	public void breathFirstSearch() {
		breathFirstSearch(root);
	}

	private void breathFirstSearch(Node node) {

		Queue<Node> queue = new LinkedList<>();

		if (node != null) {
			queue.add(node);
		}

		while (!queue.isEmpty()) {
			Node nde = queue.poll();
			System.out.println(nde.data);
			if (nde.left != null) {
				queue.add(nde.left);
			}
			if (nde.right != null) {
				queue.add(nde.right);
			}
		}

	}

	public void depthListTree() {
		List<LinkedList<Node>> lists = new ArrayList<>();

		depthListTree(root, lists, 0);

		for (LinkedList<Node> lst : lists) {
			for (Node node : lst) {
				System.out.print(node.data + " ");
			}
			System.out.println("");
		}

	}

	private void depthListTree(Node node, List<LinkedList<Node>> lists, int depth) {

		if (node == null) {
			return;
		}

		LinkedList<Node> current = null;

		if (lists.size() == depth) {
			current = new LinkedList<>();
			lists.add(current);
		} else {
			current = lists.get(depth);
		}

		current.add(node);
		depthListTree(node.left, lists, depth + 1);
		depthListTree(node.right, lists, depth + 1);

	}

	public boolean isBalanced() {
		return isBalanced(root) != Integer.MIN_VALUE;
	}

	private int isBalanced(Node node) {
		if (node == null) {
			return -1;
		} else {
			int leftH = isBalanced(node.left);
			if (leftH == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			int rightH = isBalanced(node.right);
			if (rightH == Integer.MIN_VALUE)
				return Integer.MIN_VALUE;

			if (Math.abs(leftH - rightH) > 1) {
				return Integer.MIN_VALUE;
			}

			return Math.max(leftH, rightH) + 1;
		}
	}

	public boolean isBinarySearchTree() {
		return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private boolean isBinarySearchTree(Node node, int minValue, int maxValue) {

		if (node == null) {
			return true;
		}

		if ((minValue != Integer.MIN_VALUE && node.data < minValue)
				|| (maxValue != Integer.MAX_VALUE && node.data > maxValue)) {
			return false;
		}

		if (!isBinarySearchTree(node.left, minValue, node.data)
				|| !isBinarySearchTree(node.right, node.data, maxValue)) {
			return false;
		}
		return true;
	}

	public List<Node> path(int data) {
		List<Node> arr = new ArrayList<>();
		//pathToNode(root, arr, data);

		for (Node node : arr) {
			System.out.println(node.data);
		}

		return arr;
	}

	public Node commonAnsestorNoParent(Node p, Node q) {
		List<Node> pathP = new ArrayList<>();
		List<Node> pathQ = new ArrayList<>();
		pathToNode(root, p, pathP);
		pathToNode(root, q, pathQ);

		for (int i = 0, j = 0; i < pathP.size() && j < pathQ.size(); i++, j++) {
			if (pathP.get(i) != pathQ.get(j)) {
				if (i > 0) {
					return pathP.get(i - 1);
				} else {
					return null;
				}
			}
		}
		return null;
	}

	private boolean pathToNode(Node root, Node node, List<Node> path) {
		if (root == null) {
			return false;
		}

		path.add(root);

		if (root == node) {
			return true;
		}

		if (pathToNode(root.left, node, path) || pathToNode(root.right, node, path))
			return true;

		path.remove(path.size() - 1);
		return false;
	}

	public Node commonAnsestorParent(Node p, Node q) {
		if (!commons(root, p) || !commons(root, q)) {
			return null;
		} else if (commons(p, q)) {
			return p;
		} else if (commons(q, p)) {
			return q;
		}

		Node parent = p.parent;
		while (!commons(parent, q)) {
			parent = parent.parent;
		}
		return parent;
	}

	public boolean commons(Node root, Node p) {
		if (root == null)
			return false;

		if (root == p)
			return true;

		return commons(root.left, p) || commons(root.right, p);
	}
	
	public Node commonAnsestorNoParentRec(Node p, Node q) {
		if (!commons(root, p) || !commons(root, q)) {
			return null;
		} else {
			return commonAnsestorHelper(root, p, q);
		}
	}

	private Node commonAnsestorHelper(Node root, Node p, Node q) {

		if (root == null || root == p || root == q) {
			return root;
		}

		boolean leftP = commons(root.left, p);
		boolean leftQ = commons(root.left, q);

		if (leftP != leftQ) {
			return root;
		}
		Node child = leftP ? root.left : root.right;
		return commonAnsestorHelper(child, p, q);
	}
	
	public List<LinkedList<Integer>> getAllsequence(){
		return getAllsequence(root);
	}
	public List<LinkedList<Integer>> getAllsequence(Node node){
		List<LinkedList<Integer>> results = new ArrayList<>();
		
		if(node == null) {
			results.add(new LinkedList<>());
			return results;
		}
		
		LinkedList<Integer> prefix = new LinkedList<>();
		
		prefix.add(node.data);
		
		List<LinkedList<Integer>> left = getAllsequence(node.left);
		List<LinkedList<Integer>> right = getAllsequence(node.right);
		
		for(LinkedList<Integer> first : left) {
			for(LinkedList<Integer> second : right) {
				weeveList(first,second,results,prefix);
			}
		}
		return results;
	}



	private void weeveList(LinkedList<Integer> first, LinkedList<Integer> second, List<LinkedList<Integer>> results,
			LinkedList<Integer> prefix) {
		
		if(first.size() == 0 || second.size() == 0) {
			LinkedList<Integer> result = (LinkedList<Integer>)prefix.clone();
			
			result.addAll(first);
			result.addAll(second);
			results.add(result);
			return;
		}
		
		int headfirst = first.removeFirst();
		
		prefix.addLast(headfirst);
		weeveList(first,second,results,prefix);
		
		first.addFirst(headfirst);
		prefix.removeLast();
		
		int headsecond= second.removeFirst();
		
		prefix.addLast(headsecond);
		weeveList(first,second,results,prefix);
		
		second.addFirst(headsecond);
		prefix.removeLast();
		
		
	}



	public static class Node {
		int data;
		Node right;
		Node left;
		Node parent;

		Node(int data) {
			this.data = data;
		}
	}
}
