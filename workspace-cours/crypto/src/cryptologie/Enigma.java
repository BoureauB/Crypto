package cryptologie;

import java.util.Arrays;
import java.util.List;

public class Enigma {

	static String MESSAGE = "salut";
	static List<String> ALPHABET = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n",
			"o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");

	static List<Integer> FIRSTROTOR = Arrays.asList(1, 2, 3);
	static List<Integer> SECONDROTOR = Arrays.asList(1, 2);
	static List<Integer> THIRDROTOR = Arrays.asList(1, 2, 3, 4, 5);

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Rotor<pos> de : " + MESSAGE);
		String encodeString = encodeString(MESSAGE);
		System.out.println("Encode : " + encodeString);
		System.out.println("Decode : " + decodeString(encodeString));
	}

	/**
	 * @param message - the string to encode
	 * @return the encoded String
	 */
	private static String encodeString(String message) {
		return code(message, true);
	}

	/**
	 * @param message - the string to decode
	 * @return the decoded String
	 */
	private static String decodeString(String message) {
		return code(message, false);
	}

	/**
	 * @param message
	 * @param encode
	 * @return
	 */
	private static String code(String message, Boolean encode) {
		StringBuilder result = new StringBuilder();
		if (message != null) {
			message = message.toLowerCase();
			List<String> splitedChar = Arrays.asList(message.split("(?!^)"));
			Integer iterator = 0;
			Integer position = null;
			for (String letter : splitedChar) {
				int rotor = rotor(iterator);
				if (!ALPHABET.contains(letter)) {
					result.append(letter);
				} else if (encode) {
					position = (ALPHABET.indexOf(letter) + rotor) % ALPHABET.size();
					if (position >= 26) {
						position = 0;
					}
					result.append(ALPHABET.get(position));
				} else if (!encode) {
					position = (ALPHABET.indexOf(letter) - rotor) % ALPHABET.size();
					if (position < 0) {
						position = position + 26;
					}
					result.append(ALPHABET.get(position));
				}
				iterator++;
			}
		} else {
			return "Message null";
		}
		return result.toString();
	}

	/**
	 * @param iterator
	 * @return the value of concatenation of rotors
	 */
	private static int rotor(int iterator) {
		StringBuilder rotor = new StringBuilder();

		int firstRotor = checkRotorValue(FIRSTROTOR, iterator);
		rotor.append(FIRSTROTOR.get(firstRotor).toString());
		int secondRotor = checkRotorValue(SECONDROTOR, iterator);
		rotor.append(SECONDROTOR.get(secondRotor).toString());
		int thirdRotor = checkRotorValue(THIRDROTOR, iterator);
		rotor.append(THIRDROTOR.get(thirdRotor).toString());
		return Integer.parseInt(rotor.toString());
	}

	/**
	 * @param rotor
	 * @param iterator
	 * @return the value according to rotor size
	 */
	private static int checkRotorValue(List<Integer> rotor, int iterator) {
		return iterator % rotor.size();
	}

}
