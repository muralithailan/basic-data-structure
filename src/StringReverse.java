
public class StringReverse {

	public static void main(String[] args) {

		String str = "bala";
		StringReverse stringReverse = new StringReverse();
		String result = stringReverse.reverse(str);

		System.out.println(result);
		
		
		String sentence = "Java 8 is has functional interface";
		System.out.println(stringReverse.reverseSentence(sentence));
		

	}

	public String reverse(String str) {
		return reverse(str, str.length() - 1);
	}

	private String reverse(String str, int len) {
		if (len >= 0) {
			return str.charAt(len) + reverse(str, len - 1);
		} else {
			return "";
		}
	}

	public String reverseSentence(String str) {
		String[] strs = str.split(" ");

		return reverseSentence(strs, strs.length-1);
	}

	private String reverseSentence(String[] strs, int length) {
		if (length >= 0) {
			return strs[length] +" "+ reverseSentence(strs, length - 1);
		} else {
			return "";
		}
	}

}
