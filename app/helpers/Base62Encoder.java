package helpers;

import java.util.HashMap;

public class Base62Encoder {

	private static final HashMap<Integer, Character> alphabetMap;

	private static final int BASE_FROM = 10;
	private static final int BASE_TO = 62;
	private static final int ALPHABET_LENGTH = 26;
	private static final int LOWERCASE_A = 97;
	private static final int UPPERCASE_A = 65;

	static {
		alphabetMap = new HashMap<Integer, Character>();

		/* (0..9) => ('0'..'9') */
		for (int i = 0; i < BASE_FROM; i++) {
			alphabetMap.put(i, Character.forDigit(i, BASE_FROM));
		}

		/* (10..35) => ('a'..'z') */
		for (int i = 0; i < ALPHABET_LENGTH; i++) {
			int key = i + BASE_FROM;
			char val = (char) (UPPERCASE_A + i);
			alphabetMap.put(key, val);
		}

		/* (36..61) => ('A'..'Z') */
		for (int i = 0; i < ALPHABET_LENGTH; i++) {
			int key = i + BASE_FROM + ALPHABET_LENGTH;
			char val = (char) (LOWERCASE_A + i);
			alphabetMap.put(key, val);
		}
	}

	public static String encode(int num) {
		if (num < 0) {
			return null;
		}

		StringBuilder answer = new StringBuilder();

		do {
			int remainder = num % BASE_TO;
			answer.append(alphabetMap.get(remainder));

			num /= BASE_TO;
		} while (num > 0);

		return answer.reverse().toString();
	}
}