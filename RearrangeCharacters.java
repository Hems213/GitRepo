package practice;

import java.util.HashMap;
import java.util.Map;

public class RearrangeCharacters {

	public static void main(String[] args) {
		String str = "aababbca";
		System.out.println(rearrangeChars(str));

	}

	private static String rearrangeChars(String str) {
		String res = "";
		String[] inpArr = str.split("");
		Map<String, Integer> countMap = new HashMap<>();
		for (String letter : inpArr) {
			if (countMap.containsKey(letter)) {
				countMap.put(letter, countMap.get(letter) + 1);
			} else {
				countMap.put(letter, 1);
			}
		}
		String prevChar = "";
		while (countMap.size() > 0) {
			Map<String, Integer> nextMap = new HashMap<>();
			for (Map.Entry<String, Integer> mapEntry : countMap.entrySet()) {
				String currentChar = mapEntry.getKey();
				if (prevChar.equals(currentChar)) {
					System.out.println("Not possibile");
					return "";
				}
				prevChar = currentChar;
				res += currentChar;
				if (mapEntry.getValue() > 1) {
					nextMap.put(mapEntry.getKey(), mapEntry.getValue() - 1);
				}
			}
			countMap = nextMap;
		}
		return res;
	}

}