package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class wc17fs2 {
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		Graph Graph = new Graph(N, M);
		while (M > 0) {
			in = br.readLine().split(" ");
			long n1 = Long.parseLong(in[0]), n2 = Long.parseLong(in[1]), w = Long.parseLong(in[2]);
			if (Graph.nodes.get(n1) == null)
				Graph.add(n1, new Node(n1));
			if (Graph.nodes.get(n2) == null)
				Graph.add(n2, new Node(n2));
			Node N1 = Graph.nodes.get(n1), N2 = Graph.nodes.get(n2);
			Edge E = new Edge(N1, N2, w);
			Graph.add(E);
			N1.add(E);
			N2.add(E);
			M --;
		}
		boolean success = Kruskals(Graph);
		System.out.println(success ? Graph.Weight : "Impossible");
	}
	
	static boolean Kruskals (Graph graph) {
		graph.sortEdges();
		long c = 0;
		for (int i = 0; i < graph.edgecount; i ++) {
			Edge e = graph.edges.get(i);
			Node N1 = e.N1, N2 = e.N2;
			boolean b = false;
			if (c < graph.nodecount - 1 || e.weight > 0)
				b = join(e);
			if (b) {
				c++; 
				graph.Weight += e.weight;
			}
			else {
				N1.connected.remove(e);
				N2.connected.remove(e);
				graph.edgecount --;
				graph.edges.remove(i);
				i --;
			}
		}
		Node root = null;
		for (Node N : graph.nodes.values()) {
			findRoot(N);
			if (root != null && root != findRoot(N))
				return false;
			root = findRoot(N);
		}
		return true;
	}
	
	static Node findRoot (Node n) {
		if (n.root == n) return n;
		n.root = findRoot(n.root);
		return n.root;
	}
	
	static boolean join (Edge E) {
		Node R1 = findRoot(E.N1), R2 = findRoot(E.N2);
		if (R1 == R2) return false;
		if (R1.rank == R2.rank) {
			R2.root = R1;
			R1.rank ++;
		}
		else if (R1.rank > R2.rank) R2.root = R1;
		else R1.root = R2;
		return true;
	}
	
	static void printGraph (Graph graph) {
		System.out.println(graph.Weight);
		for (Edge E : graph.edges) 
			System.out.println(E.N1.id + " " + E.N2.id + " " + E.weight);
	}
	
	static class Graph {
		
		long nodecount, edgecount;
		HashMap<Long, Node> nodes;
		ArrayList<Edge> edges;
		sortEdge sortEdge = new sortEdge();
		long Weight = 0;
		
		Graph (int nodecount, int edgecount) {
			this.nodecount = nodecount;
			this.edgecount = edgecount;
			nodes = new HashMap<>(nodecount);
			edges = new ArrayList<>(edgecount);
		}
		
		public void add (long i, Node n) {
			nodes.put(i, n);
		}
		
		public void add (Edge e) {
			edges.add(e);
		}
		
		public void sortEdges () {
			Collections.sort(edges, sortEdge);
		}
		
		class sortEdge implements Comparator<Edge> {
		    public int compare(Edge a, Edge b)
		    {
		        return Long.compare(b.weight, a.weight);
		    }
		}
	}
	
	static class Node {
		
		long id;
		long rank = 0;
		Node root = this;
		ArrayList<Edge> connected = new ArrayList<Edge>();
		
		Node (long id) {
			this.id = id;
		}
		
		void add (Edge E) {
			connected.add(E);
		}

	}
	
	static class Edge {
		
		Node N1, N2;
		long weight = 0;
		
		Edge (Node N1, Node N2, long weight) {
			this.N1 = N1;
			this.N2 = N2;
			this.weight = weight;
		}

	}
	
}
