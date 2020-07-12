package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class MinCoinsChange {
	
	public static void main(String... args) {
		List<Integer> coins = Arrays.asList(100, 25,10,1);
		HashMap<Integer, Integer> resultCache = new HashMap<>();
		HashMap<String, Integer> resultCache2 = new HashMap<>();
		//System.out.println(minCoinsRequired(coins, 69, resultCache));
		System.out.println(numberofwaysofchange(coins, 77, resultCache2));
	}

	
	public static int minCoinsRequired(List<Integer> coins, int amount, HashMap<Integer, Integer> resultCache) {
		if(amount==0) return 0;
		if(resultCache.containsKey((amount))) {
			System.out.println("hitting the cache for amnt"+amount);
			return resultCache.get(amount);
		}
		int result = Integer.MAX_VALUE;
		for(int i=0; i<coins.size(); i++) {
			int subRes = Integer.MAX_VALUE;
			System.out.println("amount="+amount+", coin="+coins.get(i));
			if(amount>=coins.get(i)) {
				subRes = Math.min(subRes, 1+minCoinsRequired(coins, amount-coins.get(i), resultCache));
				result = Math.min(result, subRes);
			}
		}
		resultCache.put(amount, result);
		return result;
	}
	
	public static int numberofwaysofchange(List<Integer> coins, int amount, HashMap<String, Integer> resultCache) {
		if(amount==0) return 1;
		if(coins.size()==0) return 0;
		if(amount<0) return 0;
		String mapKey = ""+amount+"_"+coins.size();
		if(resultCache.containsKey(mapKey)) return resultCache.get(mapKey);
		int result = numberofwaysofchange(coins, amount-coins.get(0), resultCache)+numberofwaysofchange(coins.subList(1, coins.size()), amount, resultCache);
		resultCache.put(mapKey, result);
		return result;
	}
	
}
