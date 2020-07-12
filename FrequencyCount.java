package practice;

import java.util.Map;
import java.util.TreeMap;

public class FrequencyCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "abaksdjuiyhkbsjadahgafbsdjfgbvrgthasdbfhdasfahhhhhhhvgbffbajsasgfdagdfhasgdfyraftehwvfasolfjnmhkdfnhfkdnhkdjfhgxxzzz";
		String[] s_arr = s.split("");
		TreeMap<String, Integer> countsMap = new TreeMap<>();
		for(String letter: s_arr) {
			if(countsMap.containsKey(letter)) {
				int existingCount = countsMap.get(letter);
				countsMap.put(letter, existingCount+1);
			}else {
				countsMap.put(letter, 1);
			}
		}
		for(Map.Entry<String, Integer> entry : countsMap.entrySet()) {
			System.out.println(entry.getKey().toString()+entry.getValue().toString());
		}
	}

}
