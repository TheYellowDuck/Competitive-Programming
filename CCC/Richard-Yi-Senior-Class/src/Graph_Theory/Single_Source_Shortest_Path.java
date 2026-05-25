package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class Single_Source_Shortest_Path {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int M = Integer.parseInt(in[0]), N = Integer.parseInt(in[1]);
		Vertice[] A = new Vertice[M + 1];
		while (N -- > 0) {
			in = br.readLine().split(" ");
			int v1 = Integer.parseInt(in[0]), v2 = Integer.parseInt(in[1]), e = Integer.parseInt(in[2]);
			if (A[v1] == null)
				A[v1] = new Vertice(v1);
			if (A[v2] == null)
				A[v2] = new Vertice(v2);
			A[v1].neighbours.add(new Edge(A[v2], e));
			A[v2].neighbours.add(new Edge(A[v1], e));
		}
		if (A[1] == null)
			A[1] = new Vertice(1);
		A[1].distance = 0;
		A[1].visited = true;
		PriorityQueue<Vertice> H = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
		H.add(A[1]);
		while (H.size() != 0) {
			Vertice V = H.poll();
			long d = V.distance;
			for (Edge neighbour : V.neighbours) {
				long nvd = neighbour.vertice.distance;
				if (nvd > d + neighbour.weight) 
					neighbour.vertice.distance = d + neighbour.weight;
				if (!neighbour.vertice.visited)
					H.add(neighbour.vertice);
				neighbour.vertice.visited = true;
			}
		}
		for (int i = 1; i <= M; i ++) 
			System.out.println(A[i] == null || A[i].distance == Long.MAX_VALUE ? -1 : A[i].distance);

	}
	
	static class Vertice {
		int vertice;
		long distance = Long.MAX_VALUE;
		ArrayList<Edge> neighbours = new ArrayList<>();
		boolean visited = false;
		
		Vertice(int vertice) {
			this.vertice = vertice;
		}
		
	}
	
	static class Edge {
		Vertice vertice;
		int weight;
		
		Edge(Vertice vertice, int weight) {
			this.vertice = vertice;
			this.weight = weight;
		}
		
	}

}
