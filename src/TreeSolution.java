
public class TreeSolution {

	public static void main(String[] args) {

		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };

		Tree tree = new Tree();

		tree.minHeightTree(arr);
		// for (int a : arr) {
		// tree.add(a);
		// }
		tree.inOrder();
		System.out.println("*****************Height**********");
		int height = tree.height();
		
		System.out.println(height);

		System.out.println("*****************Breath first search**********");
		tree.breathFirstSearch();

		System.out.println("*****************Depth list**********");
		tree.getDepthList();

		System.out.println("*****************Iterative Depth list**********");
		tree.getDepthListIterative();

		System.out.println("***************** Is Balanced **********");

		boolean st = tree.isBalanced();

		System.out.println(st);

		System.out.println("***************** Is Balanced Optimized with no extra height class**********");

		boolean ot = tree.isBalancedOptimized();

		System.out.println(ot);

		System.out.println("***************** Is Binary search tree**********");
		boolean isBinarySearch = tree.isBinarySearchTree();
		System.out.println(isBinarySearch);
	}

}
