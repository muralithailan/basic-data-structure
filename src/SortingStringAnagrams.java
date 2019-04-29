import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

public class SortingStringAnagrams {

	public static void main(String[] args) {

		String[] arr = {"ala","dcb","aal","cbd","abc","cba"};

		sortStringByAnagram(arr);
		
		for(String s : arr) {
			System.out.print(s +" ");
		}
		System.out.println("");
		String[] arr1 = {"ala","dcb","aal","cbd","abc","cba"};
		String[] out = sortWithAnagrams(arr1);
		
		for(String s : out) {
			System.out.print(s +" ");
		}
	}

	public static void sortStringByAnagram(String[] arr) {

		Comparator<String> comp = new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if (o1.length() == o2.length()) {
					int s1 = 0;
					int s2 = 0;
					for (int i = 0; i < o1.length(); i++) {
						s1 = s1 + o1.charAt(i);
					}
					for (int i = 0; i < o2.length(); i++) {
						s2 = s2 + o2.charAt(i);
					}
					if (s1 == s2) {
						return 0;
					} else {
						return o1.compareTo(o2);
					}
				} else {
					return o1.compareTo(o2);
				}
			}
		};

		Arrays.sort(arr, comp);
	}
	
	public static String[] sortWithAnagrams(String[] arr) {
		
		Map<String,List<String>> mapList = Arrays.stream(arr).filter(Objects::nonNull)
		.collect(Collectors.groupingBy(str -> sortedChar(str),
				Collectors.mapping(str -> str, Collectors.toList())));
		String[] out = new String[arr.length];
		int i =0;
		List<String> lst = mapList.keySet().stream().collect(Collectors.toList());
		Collections.sort(lst);
		for(String key : lst) {
			List<String> strs = mapList.get(key);
			for(String s : strs) {
				out[i] = s;
				i++;
			}
		}
		
		return out;
	}
	
	public static String sortedChar(String str) {
		char[] chars = str.toCharArray();
		
		Arrays.sort(chars);
		
		return String.valueOf(chars);
	}
}
