package practice;

public class MergeIntervalsFromArray {

	public static void main(String[] args) {
//		int[] input = {0,3,4,6,7,8,9,10,12,13,20,75,76,77,80,81,82,91,92,94};
		int[] input = {4,5, 15,16,17,18,19,20,1,2,3,5,8,9,10,12,13,14};
		printInIntervals(input);

	}

	private static void printInIntervals(int[] input) {
		StringBuilder sb = new StringBuilder();
		sb.append(input[0]);
		boolean prevInsequence = false;
		for(int i=0,j=1; j<input.length; i++, j++) {
			if(isInSequence(input[i], input[j])) {
				if(!prevInsequence) {sb.append("-");}
				prevInsequence=true;
			} else {
				
				if(prevInsequence)sb.append(input[i]);
				sb.append(",");
				sb.append(input[j]);
				prevInsequence=false;
			}
		}
		if(prevInsequence) {
			sb.append(input[input.length-1]);
		}
		System.out.println(sb.toString());
		
	}
	

	private static boolean isInSequence(int i, int j) {
		// TODO Auto-generated method stub
		return i+1==j;
	}

}
