package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Graph {
	
	static int M;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		M = Integer.parseInt(in[0]);
		int N = Integer.parseInt(in[1]);
		
		HashMap<Integer, Node>
		
		ArrayList<Node> nodes = new ArrayList<>();
		
//		Node root = new Node(), node = root;
		
		for (int i = 0; i < N; i ++) {
			in = br.readLine().split(" ");
			int n1 = Integer.parseInt(in[0]), n2 = Integer.parseInt(in[1]);
			Node node = 
		}
		

	}
	
	static class Node {
		
		int val, depth;
		ArrayList<Node> neighbours = new ArrayList<>();
		
		Node() {}
		
		Node(int val, int depth) {
			this.val = val;
			this.depth = depth;
		}
		
	}

}
