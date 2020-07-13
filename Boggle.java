package practice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Boggle {
	private static Set<String> dictionary = null;



	// Let the given dictionary be following 
    static {
    	dictionary = new HashSet<>();
//    	{ "GEEKS", "FOR", "QUIZ", "GUQ", "EE" };
    	dictionary.add("GEEKS");
    	dictionary.add("FOR");
    	dictionary.add("GEEP");
    	dictionary.add("GEEKY");
    	dictionary.add("YESUI");
    	dictionary.add("KIZOP");
    	dictionary.add("QUIZ");
    	dictionary.add("GUQ");
    	dictionary.add("GUGQ");
    	dictionary.add("EE");
    	 
    }
  
    
  
    // Driver program to test above function 
    public static void main(String args[]) 
    { 
        char boggle[][] = { { 'G', 'I', 'Z', 'O' }, 
                            { 'U', 'E', 'K' , 'P'}, 
                            { 'Q', 'S', 'E' , 'Y'} }; 
  
        System.out.println("Following words of dictionary are present"); 
        findWords(boggle); 
    }



	private static void findWords(char[][] boggle) {
		boolean[][] visited = new boolean[boggle.length][boggle[0].length];
		for(int i=0; i<boggle.length; i++) {
			for(int j=0; j<boggle[i].length; j++) {
				StringBuilder sb = new StringBuilder();
				//boolean[] flag = {true};
				findWordsFrom(visited, boggle, i, j, sb/*, flag*/);
			}
		}
		for(int i=0; i<boggle.length; i++) {
			for(int j=0; j<boggle[i].length; j++) {
				String res = "";
				findWordsFrom2(visited, boggle, i, j, res);
			}
		}
		
	}



	private static void findWordsFrom(boolean[][] visited, char[][] boggle, int i, int j, StringBuilder res/*, boolean[] flag*/) {
		visited[i][j] = true;
		res = res.append(boggle[i][j]);
		//System.out.println(i+","+j+",res="+res.toString());
		if(dictionary.contains(res.toString())) {
			System.out.println("Word found = "+res.toString());
		}
		
		List<IndexPair> next8 = getNext8(i, j, boggle); 
		//System.out.println(next8);
		for(IndexPair index : next8) {
			if(!visited[index.i][index.j]) {
				findWordsFrom(visited, boggle, index.i, index.j, res/*, flag*/);
			}
		}
//		if(flag[0]) {
//			System.out.println("Word at end = "+res);
//			flag[0]=false;
//		}

		res.deleteCharAt(res.length()-1);
		visited[i][j]=false;
	}
	private static void findWordsFrom2(boolean[][] visited, char[][] boggle, int i, int j, String res) {
		visited[i][j] = true;
		res = res+boggle[i][j];
		//System.out.println(i+","+j+",res="+res.toString());
		if(dictionary.contains(res)) {
			System.out.println("Word found 2 = "+res.toString());
		}
		
		List<IndexPair> next8 = getNext8(i, j, boggle); 
		//System.out.println(next8);
		for(IndexPair index : next8) {
			if(!visited[index.i][index.j]) {
				findWordsFrom2(visited, boggle, index.i, index.j, res);
			}
		}
		
		visited[i][j]=false;
	}



	private static List<IndexPair> getNext8(int i, int j, char[][] boggle) {
		int rowCount = boggle.length;
		int colCount = boggle[0].length;
		List<IndexPair> result = new ArrayList<IndexPair>();
		if(i-1>=0 && j-1>=0) {
			result.add(new IndexPair(i-1, j-1));
		}
		if(i-1>=0) {
			result.add(new IndexPair(i-1, j));
		}
		if(i-1>=0 && j+1<colCount) {
			result.add(new IndexPair(i-1, j+1));
		}
		if(j-1>=0) {
			result.add(new IndexPair(i, j-1));			
		}
		if(j+1<colCount) {
			result.add(new IndexPair(i, j+1));
		}
		if(i+1<rowCount && j-1>=0) {
			result.add(new IndexPair(i+1, j-1));
		}
		if(i+1<rowCount) {
			result.add(new IndexPair(i+1, j));
		}
		if(i+1<rowCount && j+1<colCount) {
			result.add(new IndexPair(i+1, j+1));
		}
		
		return result;
	} 
}

class IndexPair {
	int i;
	int j;
	public IndexPair() {}
	public IndexPair(int i, int j) {
		this.i = i;
		this.j = j;
	}
	@Override
	public String toString() {
		return "IndexPair [i=" + i + ", j=" + j + "]";
	}
}
