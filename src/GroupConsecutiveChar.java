
public class GroupConsecutiveChar {

	public static void main(String[] args) {

		String str = "34FTG234+ +- *";

		GroupConsecutiveChar groupConsecutiveChar = new GroupConsecutiveChar();

		String res = groupConsecutiveChar.groupConsecutiveChar(str);

		System.out.println(res);

	}

	public String groupConsecutiveChar(String str) {

		char[] temp = new char[str.length()];
		int k = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != ' ') {
				temp[k++] = str.charAt(i);
			}
		}
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while (i < k) {
			if (temp[i] >= 'A' && temp[i] <= 'Z') {
				while (i < k && temp[i] >= 'A' && temp[i] <= 'Z') {
					sb.append(temp[i++]);

				}
				sb.append(" ");
			} else if (temp[i] >= '0' && temp[i] <= '9') {
				while (i < k && temp[i] >= '0' && temp[i] <= '9') {
					sb.append(temp[i++]);

				}
				sb.append(" ");
			} else {
				while (i < k && temp[i] >= '*' && temp[i] <= '/') {
					sb.append(temp[i++]);

				}
				sb.append(" ");
			}
		}

		return sb.toString();
	}
}
