package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Pinball_Ranking_BST {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int ranks = Integer.parseInt(input.readLine()), val = Integer.parseInt(input.readLine());
		double sum = 1;
		Node BST = new Node(val);
		for (int i = 1; i < ranks; i++) {
			val = Integer.parseInt(input.readLine());
			sum += Node.add(BST, val);
			System.out.println(sum);
		}
		System.out.printf("%.2f", sum / ranks);
	}

	public static class Node {
		public Node(int val) {
			this.val = val;
		}

		public int val, nodes = 1;
		public Node left, right;

		static int add(Node n, int aval) {
			int rank;
			if (n.val == aval) {
				n.nodes++;
				System.out.println(n.nodes - (n.left == null ? 0 : n.left.nodes));
				return n.nodes - (n.left == null ? 0 : n.left.nodes);
			}
			if (n.val < aval) {
				if (n.right == null) {
					n.right = new Node(aval);
					n.nodes++;
					System.out.println(n.nodes - (n.left == null ? 0 : n.left.nodes) - 1);
					return n.nodes - (n.left == null ? 0 : n.left.nodes) - 1;
				}
				rank = (n.nodes - n.left.nodes) + add(n.right, aval);
				n.nodes = (n.left == null ? 0 : n.left.nodes + 1) + (n.right == null ? 0 : n.right.nodes + 1);
				System.out.println(rank);
				return rank;
			}
			if (n.left == null) {
				n.left = new Node(aval);
				n.nodes++;
				System.out.println(n.nodes);
				return n.nodes;
			}
			rank = add(n.left, aval);
			n.nodes = (n.left == null ? 0 : n.left.nodes + 1) + (n.right == null ? 0 : n.right.nodes + 1);
			rank += (n.nodes - n.left.nodes) + (n.right == null ? 0 : n.right.nodes);
			System.out.println(n.nodes + " " + n.left.nodes + " " + rank);
			return rank;
		}
	}

}
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class Pinball_Ranking_BST {
//
//	public static double main() throws NumberFormatException, IOException {
//		// TODO Auto-generated method stub
//		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
//		int ranks = Integer.parseInt(input.readLine()), val = Integer.parseInt(input.readLine());
//		long sum = 1;
//		Node BST = new Node(val);
//		for (int i = 1; i < ranks; i++) {
//			val = Integer.parseInt(input.readLine());
//			sum += Node.add(BST, val) + 1;
//		}
//		return sum / ranks;
//	}
//
//	public static class Node {
////		public int val, rank = 0, times = 1;
////		public Node left, right;
//
//		public Node(int val) {
//			this.val = val;
//		}
//
////		public int add(Node root, int s) {
////			int rank = 0;
////			if (root == null)
////				root = new Node(s);
////			else {
////				Node n = root;
////				while (true) {
////					if (s == n.val)
////						break;
////					if (s < n.val) {
////						rank += n.rank + n.times;
////						if (n.left == null) {
////							n.left = new Node(s);
////							return rank;
////						} else
////							n = n.left;
////					} else {
////						n.rank++;
////						if (n.right == null) {
////							n.right = new Node(s);
////							return rank;
////						} else
////							n = n.right;
////					}
////				}
////			}
////			return rank;
////		}
//		public int val, nodes=1, times=1;
//		public Node left, right;
//		static int add(Node n, int aval) {
//			int rank=0;
//			if (n.val==aval) return rank;
//			if (n.val<aval) {
//				if (n.right==null) {
//					n.right=new Node(aval);
//					n.nodes++;
//					return n.nodes-1;
//				}
//				rank=add(n.right, aval);
//				n.nodes=(n.left==null?0:n.left.nodes+1)+(n.right==null?0:n.right.nodes+1);
//				return rank;
//			}
//			if (n.left==null) {
//				n.left=new Node(aval);
//				n.nodes++; 
//				return n.nodes+1;
//			}
//			rank=add(n.left, aval);
//			n.nodes=(n.left==null?0:n.left.nodes+1)+(n.right==null?0:n.right.nodes+1);
//			return rank;
//		}
//	}
//
//}
