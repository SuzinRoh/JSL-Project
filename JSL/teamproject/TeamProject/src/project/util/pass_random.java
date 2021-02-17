package project.util;
import java.util.Random;

public class pass_random {
	private static final char[] chars;
	static {
		StringBuilder buffer = new StringBuilder();
		for (char ch = '0'; ch <= '9'; ++ch) // 숫자 범위 설정
			buffer.append(ch);
		for (char ch = 'a'; ch <= 'z'; ++ch) // 소문자 범위 설정
			buffer.append(ch);
		for (char ch = 'A'; ch <= 'Z'; ++ch) //대문자 범위 설정
			buffer.append(ch);
		chars = buffer.toString().toCharArray();
	}

	public String MakeRandomPass(int length) {
		if (length < 1)
			throw new IllegalArgumentException("length < 1: " + length);

		StringBuilder randomString = new StringBuilder();
		Random random = new Random();

		for (int i = 0; i < length; i++) {
			randomString.append(chars[random.nextInt(chars.length)]);
		}
		return randomString.toString();
	}

	public static void main(String[] args) {
	}
}
