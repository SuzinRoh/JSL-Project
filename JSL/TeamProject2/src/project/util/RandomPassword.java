package project.util;

import java.io.IOException;

public class RandomPassword {
	public static void main(String[] args) throws IOException {
		System.out.println(getRamdomPassword(10));
	}

	public static String getRamdomPassword(int len) {
		char[] randSet = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F',
				'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };
		int idx = 0;
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < len; i++) {
			idx = (int) (randSet.length * Math.random());
			sb.append(randSet[idx]);
		}
		return sb.toString();
	}
}
