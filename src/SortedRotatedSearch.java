
public class SortedRotatedSearch {

	public static void main(String[] args) {

		int[] num = { 15, 16, 19, 20, 25, 1, 3, 4, 5, 7, 10, 14 };

		int res = search(num, 19);

		System.out.println(res);

	}

	public static int search(int[] arr, int n) {
		return search(arr, 0, arr.length - 1, n);
	}

	private static int search(int[] arr, int low, int high, int n) {

		int mid = (low + high) / 2;

		if (arr[mid] == n) {
			return mid;
		}

		if (low > high) {
			return -1;
		}

		if (arr[low] < arr[mid]) {

			if (n >= arr[low] && n < arr[mid]) {
				return search(arr, low, mid - 1, n);
			} else {
				return search(arr, mid + 1, high, n);
			}

		} else if (arr[mid] < arr[low]) {
			if (n > arr[mid] && n <= arr[high]) {
				return search(arr, mid + 1, high, n);
			} else {
				return search(arr, low, mid - 1, n);
			}
		} else if (arr[mid] == arr[low]) {
			if (arr[mid] != arr[high]) {
				return search(arr, low, high, n);
			} else {
				int res = search(arr, low, mid - 1, n);

				if (res == -1) {
					return search(arr, mid + 1, high, n);
				} else {
					return res;
				}
			}
		}else {
			return -1;
		}
	}

}
