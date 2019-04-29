
public class PascalTriangle {

	public static void main(String[] args) {

		int n = 6;

		displayPascalTriangle(n);
		System.out.println("**************************** Pascal with no arr **********");
		displayPascalTriangleNoArr(n);
	}

	/**
	 * with time O(n^2) space O(n^2)
	 * @param n
	 */
	public static void displayPascalTriangle(int n) {
		int[][] arr = new int[n][n];
		for (int line = 0; line < n; line++) {
			for (int i = 0; i <= line; i++) {
				if (line == i || i == 0) {
					arr[line][i] = 1;
				} else {
					arr[line][i] = arr[line - 1][i - 1] + arr[line - 1][i];
				}
				System.out.print(arr[line][i] +" ");
			}
			System.out.println("");
		}
	}
	
	public static void displayPascalTriangleNoArr(int n) {
		
		for (int line = 1; line <=n; line++) {
			int c =1;
			for (int i = 1; i <= line; i++) {
				System.out.print(c +" ");
				c = c * (line -i)/i;
				
			}
			System.out.println("");
		}
	}

}
