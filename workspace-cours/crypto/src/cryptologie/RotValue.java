package cryptologie;

import java.util.Arrays;

public class RotValue {	

	public static void main(String[] args) {

	String result = encodeString("test de string ,;:!ù^$");
	System.out.println(result);

	}

	private static String encodeString(String message) {
		if(message != null) {
			int rot = 13;
			StringBuilder stringBuilder = new StringBuilder();
			java.util.List<String> list = Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z");
			message = message.toLowerCase();
			String[] splited = message.split("(?!^)");
			Integer position = null;
			
			for(String i : splited) {
				 if(!list.contains(i)) {
					stringBuilder.append(i);
				} else if(list.contains(i)) {
					position = list.indexOf(i) + rot;
					if(position > list.size() || position == list.size()) {
						position = position - list.size();
					}
					if(position != null) {
						stringBuilder.append(list.get(position));
					}
				}else if(i == " ") {
					stringBuilder.append(" ");
				}
			}
			return stringBuilder.toString();
			
		} else {
			return "Message null";
		}
	}		
}
