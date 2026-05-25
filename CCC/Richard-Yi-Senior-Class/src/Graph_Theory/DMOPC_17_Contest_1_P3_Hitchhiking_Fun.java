package Graph_Theory;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;

public class DMOPC_17_Contest_1_P3_Hitchhiking_Fun {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		
		ArrayList<Pair>[] adj = new ArrayList[N + 1];
		
		for (int i = 0; i < M; i ++) {
			in = br.readLine().split(" ");
			int u = Integer.parseInt(in[0]), v = Integer.parseInt(in[1]), w = Integer.parseInt(in[2]);
			if (adj[u] == null)
				adj[u] = new ArrayList<>();
			if (adj[v] == null)
				adj[v] = new ArrayList<>();
			adj[u].add(new Pair(v, w));
			adj[v].add(new Pair(u, w));
		}
		
		PriorityQueue<Trio> heap = new PriorityQueue<>();
		heap.offer(new Trio(0, 0, 1));
		Pair[] dist = new Pair[N + 1];
		dist[1] = new Pair(0, 0);
		final int INF = 

	}
	
	static class Node {
		int distance = Integer.MAX_VALUE, weight = Integer.MAX_VALUE;
		
	}
	
	static class Pair implements Comparable<Pair> {
		int first, second;
		
		Pair(int first, int second) {
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair pair) {
			// TODO Auto-generated method stub
			if (first == pair.first)
				return second - pair.second;
			return first - pair.first;
		}
		
	}
	
	static class Trio implements Comparable<Trio> {
		int first, second, third;
		
		Trio(int first, int second, int third) {
			this.first = first;
			this.second = second;
			this.third = third;
		}

		@Override
		public int compareTo(Trio trio) {
			// TODO Auto-generated method stub
			if (first == trio.first)
				return second - trio.second;
			return first - trio.first;
		}
		
	}

}
