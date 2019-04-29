import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DuplicateRemoval {

	public static void main(String[] args) {

		List<Integer> arr = Arrays.asList(1, 2, 1, 2, 3, 1, 4, 4, 5, 4);
		DuplicateRemoval duplicateRemoval = new DuplicateRemoval();
		List<Integer> res = duplicateRemoval.removeDuplicate(arr);

		for (int a : res) {
			System.out.println(a);
		}
		
		System.out.println("************************** Sorted List ************************");
		
		List<Integer> arrSorted = Arrays.asList(1, 1,2,2,2,4,4,5,6,7,7);
		
		List<Integer> resNoDup = duplicateRemoval.removeDuplicateSortlist(arrSorted);

		for (int a : resNoDup) {
			System.out.println(a);
		}

	}

	public List<Integer> removeDuplicate(List<Integer> arr) {

		Set<Integer> sets = new HashSet<>();

		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < arr.size(); i++) {
			if (!sets.contains(arr.get(i))) {
				sets.add(arr.get(i));
				result.add(arr.get(i));
			}
		}
		return result;
	}
	
	public List<Integer> removeDuplicateSortlist(List<Integer> arr) {
		List<Integer> result = new ArrayList<>();
		if (!arr.isEmpty()) {
			result.add(arr.get(0));
		}
		for (int i = 1; i < arr.size(); i++) {
			if (arr.get(i) != arr.get(i - 1)) {
				result.add(arr.get(i));
			}
		}

		return result;
	}

}
