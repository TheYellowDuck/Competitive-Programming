package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class vmss7wc16c6p3 {
	
	static Graph graph;
	static int time = 0;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		graph = new Graph(N, M);
		while (M > 0) {
			in = br.readLine().split(" ");
			int n1 = Integer.parseInt(in[0]), n2 = Integer.parseInt(in[1]);
			if (graph.nodes.get(n1) == null)
				graph.add(n1, new Node(n1));
			if (graph.nodes.get(n2) == null)
				graph.add(n2, new Node(n2));
			graph.nodes.get(n1).add(graph.nodes.get(n2));
			graph.nodes.get(n2).add(graph.nodes.get(n1)); //Directed or unDirected
			M --;
		}
		graph.root = graph.nodes.get(1);
		Tarjan(null, graph.root);
		printGraph();
	}
	
	public static void Tarjan(Node P, Node N) {
//		graph.incall.add(N);
		int c = 0;
		N.time = time ++;
		for (Node i : N.neighbours) {
			if (i.time == -1) {
				c ++;
				Tarjan (N, i);
				N.back = minB (N, i);
				if (N != graph.root && N.back.time >= i.time)
					graph.CutNode.add(N.index);
			}
			else if (N != graph.root)
				N.back = minT (N, i);
//			Node t = minB (N, i);
//			if (graph.incall.contains(t))
//				N.back = t;
//			else N.back = minT (N, i);
		}
		if (N != graph.root && c > 1) 
			graph.CutNode.add(N.index);
//		graph.incall.remove(N);
//		if (isCutNode(graph.root, N)) graph.CutNode.add(N.index);
//		else graph.CutNode.remove(N.index);
		return;
	}
	
//	public static boolean isCutNode(Node R, Node N) {
//		if (R == N) {
//			if (N.neighbours.size() >= 2) 
////				for (Node i : N.neighbours) 
////					if (i.back.time > N.time) return true;
//				return true;
//		}
//		else 
//			for (Node i : N.neighbours) 
//				if (i.back.time > N.time) return true;
//		return false;
//		
//	}
	
	public static Node minB (Node N1, Node N2) {
		if (N1.back.time > N2.back.time) return N2.back;
		return N1.back;
	}
	
	public static Node minT (Node N1, Node N2) {
		if (N1.back.time > N2.time) return N2;
		return N1.back;
	}
	
	public static void printGraph() {
//		int c = 0;
//		SortedSet<Integer> S = new TreeSet<>();
//		Node R = graph.nodes.get(1);
//		for (Node N : graph.nodes.values()) {
////			System.out.println("Index: " + N.index + ", Time: " + N.time + ", Lowlink Node: " + N.back.index + ", Lowlink Time: " + N.back.time + ", isCutNode: " + isCutNode(graph.nodes.get(1), N));
//			if (isCutNode(R, N)) {
//				c++;
//				S.add(N.index);
//			}
//		}
//		System.out.println(c);
		System.out.println(graph.CutNode.size());
		for (int i : graph.CutNode) {
			System.out.println(i);
		}
	}
	
	public static class Graph {
		
		int nodecount, edgecount;
		HashMap<Integer, Node> nodes;
//		HashSet<Node> incall = new HashSet<>();
		SortedSet<Integer> CutNode = new TreeSet<>();
		Node root = null;
		
		Graph(int nodecount, int edgecount) {
			this.nodecount = nodecount;
			this.edgecount = edgecount;
			nodes = new HashMap<>(nodecount);
		}
		
		public void add(int i, Node n) {
			nodes.put(i, n);
		}

	}
	
	public static class Node {
		
		int index, time = -1;
		ArrayList<Node> neighbours = new ArrayList<>();
		Node back = this;
		
		public Node (int index) {
			this.index = index;
		}
		
		public void add(Node n) {
			neighbours.add(n);
		}

	}

}
