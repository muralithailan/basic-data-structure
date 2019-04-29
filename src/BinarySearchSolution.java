
public class BinarySearchSolution {

	public static void main(String[] args) {

		int[] arr = {1,2,3,4,5,6,7,8};
		
		int res = search(arr,7);
		System.out.println(res);
		
		int num = 16;
		int sqt = squareRoot(num);
		
		System.out.println(sqt);
	}
	
	public static int search(int[] arr,int num) {
		return search(arr,0,arr.length-1,num);
	}

	private static int search(int[] arr, int low, int high,int num) {
		
		if(low<high) {
			
			int mid = (low +high)/2;
			
			if(arr[mid] > num) {
				return search(arr,low,mid-1,num);
			}else if(arr[mid]<num) {
				return search(arr,mid+1,high,num);
			}else {
				return mid;
			}
		}else {
			return -1;
		}
	}
	
	private static int squareRoot(int num) {
		return squareRoot(num,1,num);
	}

	private static int squareRoot(int num, int low, int high) {
		if(low<high) {
			int mid = (low+high)/2;
			int sqt = mid * mid;
			if(sqt > num) {
				return squareRoot(num,low,mid-1);
			}else if(sqt < num){
				return squareRoot(num,mid+1,high);
			}else {
				return mid;
			}
		}
		return -1;
	}

}
