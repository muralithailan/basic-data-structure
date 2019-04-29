import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class StringFrequencyCounter {

	public static void main(String[] args) {
		String sb = "abcabcdede";

		//String res = getCharacterFrequencyHashMap(sb);

		String res = getCharFrequency(sb);
		System.out.println(res);

	}

	public static String getCharacterFrequencyHashMap(String str) {
		Map<Character, Integer> maps = new LinkedHashMap<>();

		for (int i = 0; i < str.length(); i++) {
			char chr = str.charAt(i);

			maps.compute(chr, (key, value) -> value == null ? 1 : value + 1);
		}

		StringBuilder sb = new StringBuilder();

		for (Map.Entry<Character, Integer> mk : maps.entrySet()) {
			sb.append(mk.getKey()).append(mk.getValue());
		}

		return sb.toString();

	}

	public static String getCharFrequency(String str) {

		int[] count = new int[128];

		for (int i = 0; i < str.length(); i++) {
			count[str.charAt(i)]++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {
			if (count[str.charAt(i)] != 0) {
				sb.append(str.charAt(i)).append(count[str.charAt(i)]);
				count[str.charAt(i)] = 0;
			}

		}

		return sb.toString();
	}

}
