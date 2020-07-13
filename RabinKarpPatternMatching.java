package practice;

public class RabinKarpPatternMatching {
	final static int CHAR_SIZE=26;
	final static int PRIME = 811;
	public static void main(String[] args) {
		String inpStr = "AABC";
		int hashedValue = calculateHash(inpStr);
		System.out.println(hashedValue);
		int removedHash = removeAtLeft(hashedValue, inpStr);
		System.out.println("Remove hash "+removedHash);
		int addedHash = addAtRight(hashedValue, inpStr, 'C');
		System.out.println("addedHash "+addedHash);
	}
	private static int addAtRight(int hashedValue, String inpStr, char c) {
		int addedHash = (hashedValue*CHAR_SIZE)%PRIME;//shift one bit
		addedHash += (int)(getCharValue(c)*Math.pow(CHAR_SIZE, 0));
		return addedHash%PRIME;
	}
	private static int removeAtLeft(int hashedValue, String inpStr) {
		int highestDigitIndex = inpStr.length()-1;
		char leftMostChar = inpStr.charAt(0);
		int hashValue = hashedValue - ((int)(getCharValue(leftMostChar)*Math.pow(CHAR_SIZE, highestDigitIndex))%PRIME);
		return hashValue;
	}
	private static int calculateHash(String inpStr) {
		char[] chars = inpStr.toCharArray();
		int charLength = chars.length;
		int hashValue = 0;
		for(int i=0; i<charLength; i++){
			int charValue = getCharValue(chars[i]);
			hashValue = hashValue+(int)(charValue*Math.pow(CHAR_SIZE, charLength-1-i))%PRIME;
		}
		return hashValue%PRIME;
	}
	private static int getCharValue(char c) {
		return c-'A'+1;
	}
	

}
