package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class PhoneKeyWord {

	public static void main(String[] args) {
		HashSet<String> dictionary = new HashSet<>();
		dictionary.add("good");
		dictionary.add("great");
		dictionary.add("gone");
		dictionary.add("hmm");
		dictionary.add("goo");
		dictionary.add("morning");
		dictionary.add("hello");
		dictionary.add("everyone");
		dictionary.add("everz");
		
		HashMap<Integer, List<String>> keypad = new HashMap<>();
		keypad.put(1, Arrays.asList("a","b","c"));
		keypad.put(2, Arrays.asList("d","e","f"));
		keypad.put(3, Arrays.asList("g","h","i"));
		keypad.put(4, Arrays.asList("j","k","l"));
		keypad.put(5, Arrays.asList("m","n","o"));
		keypad.put(6, Arrays.asList("p","q","r","s"));
		keypad.put(7, Arrays.asList("t","u","v"));
		keypad.put(8, Arrays.asList("w","x","y","z"));
		
//		List<Integer> digits = Arrays.asList(2,7,2,6,8,5,5,2);
		List<Integer> digits = Arrays.asList(1,3,5,5);
		
		HashSet<String> result = findWords2(digits, keypad, dictionary);
		result.retainAll(dictionary);
		System.out.println(result);
	}
	
	

	private static HashSet<String> findWords2(List<Integer> digits, HashMap<Integer, List<String>> keypad,
			HashSet<String> dictionary) {
		HashSet<String> result = new HashSet<String>();
		result.add("");
		int count = 0;
		for(Integer num: digits) {
			List<String> letters = keypad.get(num);
			HashSet<String> tempResult = new HashSet<String>();
			for(String potentialWord: result) {
				for(String letter: letters) {
					String combination = potentialWord+letter;
					count++;
					System.out.println("Count and combination "+count+" and "+combination);
					if(hasWordStartingWith(combination, dictionary)) {
						System.out.println("Picking this combination "+combination);
						tempResult.add(combination);
					}
				}
			}
			result = tempResult;
		}
		return result;
		
	}

	private static boolean hasWordStartingWith(String combination, HashSet<String> dictionary) {
		for(String word:dictionary) {
			if(word.startsWith(combination)) {
				return true;
			}
		}
		return false;
	}



	private static HashSet<String> findWords(List<Integer> digits, HashMap<Integer, List<String>> keypad,
			HashSet<String> dictionary) {
		HashSet<String> result = new HashSet<String>();
		if(digits.size()==0) {
			result.add("");
			return result;
		}
		List<String> letters = keypad.get(digits.get(0));
		HashSet<String> existingStrings = findWords(digits.subList(1, digits.size()), keypad, dictionary);
		for(String letter: letters) {
			for(String strng: existingStrings) {
				result.add(letter+strng);
			}
		}
		return result;
	}

}
