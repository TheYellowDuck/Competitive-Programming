package Y2022;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class S5_Good_Influencers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		Node[] graph = new Node[N + 1];
		for (int i = 1; i < N; i ++) {
			String[] in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]);
			if (graph[x] == null)
				graph[x] = new Node(x);
			if (graph[y] == null)
				graph[y] = new Node(y);
			graph[x].add(graph[y]);
			graph[y].add(graph[x]);
		}
		char[] YN = br.readLine().toCharArray();
		Queue<Node> Q = new LinkedList<>();
		for (int i = 1; i <= YN.length; i ++) {
			if (YN[i - 1] == 'N') graph[i].destination = true;
			else Q.add(graph[i]);
		}
		String[] cost = br.readLine().split(" ");
		int total = 0;
		while (!Q.isEmpty()) {
			Node n = Q.poll();
			int ncost = Integer.parseInt(cost[n.i]);
			boolean minus = false;
			int ptotal = 0;
			for (Node i : n.connected) {
				if (i.destination) {
					if (i.cost > ncost) {
						if (i.cost != Integer.MAX_VALUE)
							total -= i.cost;
						i.cost = ncost;
						i.convince = n;
						total += ncost;
					}
					Q.add(i);
				}
			}
		}
		System.out.println(total);
	}
	
	static class Node {
		int i;
		int cost = Integer.MAX_VALUE;
		Node convince = null;
		HashSet<Node> connected = new HashSet<>();
		boolean destination = false;
		Node(int i) {
			this.i = i - 1;
		}
		
		void add(Node n) {
			connected.add(n);
		}
	}

}
