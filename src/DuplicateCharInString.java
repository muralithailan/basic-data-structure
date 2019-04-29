
public class DuplicateCharInString {

	public static void main(String[] args) {

		String s = "weertr";

		String out = duplicateChar(s);
		System.out.println(out);

	}

	public static String duplicateChar(String str) {
		int[] chrmap = new int[128];

		for (int i = 0; i < str.length(); i++) {
			chrmap[str.charAt(i)]++;
		}

		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < str.length(); i++) {

			if (chrmap[str.charAt(i)] > 0) {
				sb.append(str.charAt(i)).append(chrmap[str.charAt(i)]);
				chrmap[str.charAt(i)] = 0;
			}
		}

		return sb.toString();
	}

}
