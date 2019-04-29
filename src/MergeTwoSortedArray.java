
/**
 * Merge two sorted array to first where first have size to accommodate both 
 * @author z022839
 *
 */
public class MergeTwoSortedArray {

	public static void main(String[] args) {

		int[] num1 = {3,5,7,9,0,0,0};
		int[] num2 = {1,2,4};

		merge(num1,num2,4,3);
		
		for(int n: num1) {
			System.out.print(n+" ");
		}
	}
	
	public static void merge(int[] arr1,int[] arr2,int lasta,int lastb) {
		
		
		
		int i = lasta-1;
		int j = lastb-1;
		
		int merIdx= lasta+lastb -1;
		while(j>=0) {
			
			if(i >=0 && arr1[i] > arr2[j]) {
				arr1[merIdx] = arr1[i];
				i--;
			}else {
				arr1[merIdx] = arr2[j];
				j--;
			}
			merIdx--;
		}
	}

}
