import java.util.LinkedList;
import java.util.List;



public class TreeParentSolution {

	public static void main(String[] args) {

		int[] arr = { 20, 10, 30, 5, 15, 3, 7, 17 };
		int[] arr1 = { 20, 10, 30 };

		TreeParent treeParent = new TreeParent();

		// treeParent.insertFromArray(arr);
		for (int a : arr) {
			treeParent.insert(a);
		}

		System.out.println("*********************Height**********************");

		System.out.println(treeParent.height());
		System.out.println("*********************In-order**********************");
		treeParent.inorder();

		System.out.println("*********************In-order succesor**********************");
		int ses = treeParent.nextInorderSuccesor(30);

		System.out.println(ses);

		System.out.println("*********************In-order succesor No parent **********************");
		TreeParent.Node p30 = treeParent.search(30);
		TreeParent.Node seNoP = treeParent.nextInorderSuccesorNoParent(p30);

		System.out.println(seNoP != null ? seNoP.data : -1);

		System.out.println("********************* Breath first search **********************");
		treeParent.breathFirstSearch();

		System.out.println("********************* Depth List **********************");
		treeParent.depthListTree();

		System.out.println("********************* Is - Balanced **********************");
		boolean isBalanced = treeParent.isBalanced();
		System.out.println(isBalanced);

		System.out.println("********************* isBinary **********************");
		boolean isBinary = treeParent.isBinarySearchTree();
		System.out.println(isBinary);

		System.out.println("********************* Path **********************");
		treeParent.path(9);

		System.out.println("********************* Common Ansestor **********************");
		TreeParent.Node p1 = treeParent.search(10);
		TreeParent.Node q1 = treeParent.search(30);
		TreeParent.Node commAns = treeParent.commonAnsestorNoParent(p1, q1);
		System.out.println(commAns.data);

		System.out.println("********************* Common Ansestor Parent **********************");
		TreeParent.Node p = treeParent.search(10);
		TreeParent.Node q = treeParent.search(30);

		TreeParent.Node ansestor = treeParent.commonAnsestorParent(p, q);
		System.out.println(ansestor.data);

		System.out.println("********************* Common Ansestor No-Parent **********************");
		TreeParent.Node p11 = treeParent.search(10);
		TreeParent.Node q11 = treeParent.search(30);

		TreeParent.Node ansestorNoP = treeParent.commonAnsestorNoParentRec(p11, q11);

		System.out.println(ansestorNoP.data);

		System.out.println("********************* Number of possible list to bring search tree **********************");
		List<LinkedList<Integer>> results = treeParent.getAllsequence();

		for (LinkedList<Integer> result : results) {
			for (int n : result) {
				System.out.print(n + " ");
			}
			System.out.println("");
		}
		System.out.println("********************* Check T1 larger tree has t2 as sub tree time O(n+m) space O(n +m) **********************");
		int[] t1arr = { 20, 10, 30, 5, 15, 3, 7, 17 };
		int[] t2arr = { 5,3,7 };

		TreeParent t1 = new TreeParent();
		TreeParent t2 = new TreeParent();

		for (int a : t1arr) {
			t1.insert(a);
		}

		for (int a : t2arr) {
			t2.insert(a);
		}

		System.out.println(compareTree(t1, t2));
		
		System.out.println("********************* Check T1 larger tree has t2 as sub tree time O(n +km) space O(log n + log m)**********************");
		System.out.println(recursionTreeCompare(t1.root,t2.root));
	}

	/**
	 * run time O(n+m) and space complexity is O(n+m)
	 * @param t1
	 * @param t2
	 * @return
	 */
	public static boolean compareTree(TreeParent t1, TreeParent t2) {
		StringBuilder sbt1 = new StringBuilder();
		StringBuilder sbt2 = new StringBuilder();

		addPreOrderTree(t1.root, sbt1);
		addPreOrderTree(t2.root, sbt2);

		return sbt1.toString().indexOf(sbt2.toString()) != -1;
	}

	private static void addPreOrderTree(TreeParent.Node root, StringBuilder sbt) {

		if (root == null) {
			sbt.append("x");
			return;
		}

		sbt.append(root.data);
		addPreOrderTree(root.left, sbt);
		addPreOrderTree(root.right, sbt);

	}
	
	public static boolean recursionTreeCompare(TreeParent.Node t1, TreeParent.Node t2) {
		if (t2 == null) {
			return true;
		}
		return subTree(t1, t2);
	}

	private static boolean subTree(TreeParent.Node t1, TreeParent.Node t2) {
		if (t1 == null) {
			return false;
		} else if (t1.data == t2.data && matchTree(t1, t2)) {
			return true;
		}
		return subTree(t1.left, t2) || subTree(t1.right, t2);
	}

	public static boolean matchTree(TreeParent.Node t1, TreeParent.Node t2) {
		if (t1 == null && t2 == null) {
			return true;
		} else if (t1 == null || t2 == null) {
			return false;
		} else if (t1.data != t2.data) {
			return false;
		} else {
			return matchTree(t1.left, t2.left) && matchTree(t1.right, t2.right);
		}
	}

}
