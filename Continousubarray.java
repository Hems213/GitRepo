package practice;

public class Continousubarray {
	public static void main (String[] args) 
    { 
        int [] a = {2,-3,4,1,-2,-1,-5,-3}; 
        System.out.println("Maximum contiguous sum is " + 
                                       maxSubArraySum(a)); 
    } 
  
    static int maxSubArraySum(int a[]) 
    { 
    	int maxSoFar = Integer.MIN_VALUE;
    	int maxTillNow = 0;
    	for(int num : a) {
    		maxTillNow = maxTillNow+num;
    		maxSoFar = Math.max(maxSoFar, maxTillNow);
    		maxTillNow = Math.max(0,  maxTillNow);
    	}
    	return maxSoFar;
    } 
}
