package tw.encdg;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EncodingProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(EncodingProblem.constructTree("ab"));

	}
	
	static private class Node {
		private char val;
		private double frequency;
//		private Link llink;
//		private Link rlink;
		private Link uplink;

		public Node(char val, double frequency) {
			super();
			this.val = val;
			this.frequency = frequency;
		}
		
		public char getVal() {
			return val;
		}
//		public void setVal(char val) {
//			this.val = val;
//		}
		public double getFrequency() {
			return frequency;
		}
		public void setFrequency(double frequency) {
			this.frequency = frequency;
		}
//		public Link getLlink() {
//			return llink;
//		}
//		public void setLlink(Link llink) {
//			this.llink = llink;
//		}
//		public Link getRlink() {
//			return rlink;
//		}
//		public void setRlink(Link rlink) {
//			this.rlink = rlink;
//		}
		public Link getUplink() {
			return uplink;
		}
		public void setUplink(Link uplink) {
			this.uplink = uplink;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + val;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (val != other.val)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", frequency=" + frequency /*+ ", llink="
					+ llink + ", rlink=" + rlink */+ ", uplink=" + uplink + "]";
		}
		
	}
	
	static private class Link{
		private String linkNum;
		private Node endNode;		
		public Link(String linkNum, Node endNode) {
			super();
			this.linkNum = linkNum;
			this.endNode = endNode;
		}
		public String getLinkNum() {
			return linkNum;
		}
//		public void setLinkNum(String linkNum) {
//			this.linkNum = linkNum;
//		}
		public Node getEndNode() {
			return endNode;
		}
//		public void setEndNode(Node endNode) {
//			this.endNode = endNode;
//		}
		@Override
		public String toString() {
			return "Link [linkNum=" + linkNum + ", endNode=" + endNode + "]";
		}
		
	}
	
	
	public static String constructTree(String input1){
		final char[] inp_chars = input1.toCharArray();
		int totalLength = inp_chars.length;
		if(totalLength<=0){
			throw new IllegalArgumentException("Input is not valid");
		}
		Map<Character, Node> frequencysMap = new HashMap<Character, Node>();
		for (int i = 0; i < totalLength; i++) {
			Node endNode;
			
			char curChar = inp_chars[i];
			if(frequencysMap.containsKey(curChar)){
				endNode = frequencysMap.get(curChar);
				double curFrequency = endNode.getFrequency();
				double newFrequency = ((curFrequency*totalLength)+1.0)/totalLength;
				endNode.setFrequency(newFrequency);
			}else{
				endNode = new Node(curChar, 1.0/totalLength);
				frequencysMap.put(curChar, endNode);
			}
		}
		
		List<Node> endNodes = new ArrayList<Node>(frequencysMap.values());
		Collections.sort(endNodes, new Comparator<Node>() {

			@Override
			public int compare(Node o1, Node o2) {
				if(o1.getFrequency()<o2.getFrequency()){
					return 1;
				}else if(o1.getFrequency()>o2.getFrequency()){
					return -1;
				}else{
					if(o1.getVal()<o2.getVal()){
						return -1;
					}else if(o1.getVal()>o2.getVal()){
						return 1;
					}else{
						return 0;
					}
				}
			}
		});
		
		Node lastCreatedNode = null;
		int endNodeLength = endNodes.size();
		for(int k=endNodeLength-1; k>0;k--){
			if(lastCreatedNode==null){
				lastCreatedNode = endNodes.get(k);
			}
			Node prevNode = endNodes.get(k-1);
			Node joininNode = new Node(' ', lastCreatedNode.getFrequency()+prevNode.getFrequency());
			lastCreatedNode.setUplink(new Link("1", joininNode));
			prevNode.setUplink(new Link("0", joininNode));
			lastCreatedNode = joininNode;
		}
		
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < inp_chars.length; i++) {
			char curChar = inp_chars[i];
			Node nd = frequencysMap.get(curChar);
			sb.append(findEncoding(nd));
			
		}
		
		
		return sb.toString();
	}


	private static String findEncoding(Node curNode) {
		StringBuffer sb = new StringBuffer();
		Link upLink = curNode.getUplink();
		while(upLink!=null){
			sb.append(upLink.getLinkNum());
			Node upNode = upLink.getEndNode();
			curNode = upNode;
			upLink = curNode.getUplink();
		}
		
		return sb.reverse().toString();
	}

}
