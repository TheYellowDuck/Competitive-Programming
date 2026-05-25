package Y2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S3_Phonomenal_Reviews {
	
	static int[] P;
	static int total = 0;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		in = br.readLine().split(" ");
		P = new int[M];
		for (int i = 0; i < M; i ++) 
			P[i] = Integer.parseInt(in[i]);
		Node[] R = new Node[N];
		for (int i = 1; i < N; i ++) {
			in = br.readLine().split(" ");
			int n1 = Integer.parseInt(in[0]), n2 = Integer.parseInt(in[1]);
			if (R[n1] == null)
				R[n1] = new Node(n1);
			if (R[n2] == null)
				R[n2] = new Node(n2);
			R[n1].n.add(R[n2]);
			R[n2].n.add(R[n1]);
		}
		Node s = recurse(null, R[P[0]]);
		s.visited = true;
		recurse2(s);
		System.out.println(total);
	}
	
	static Node recurse(Node root, Node n) {
		if (n.n.size() == 1 && n.n.get(0) == root) {
			for (int i : P) {
				if (n.i == i)
					return n;
			}
			return null;
		}
		Node r = null, p = null;
		for (int i = 0; i < n.n.size(); i ++) {
			Node neighbour = n.n.get(i);
			if (neighbour != root) {
				p = recurse(n, neighbour);
				if (p == null) 
					n.n.remove(i --);
				else 
					r = (r == null ? -1 : r.v) >= p.v ? r : p;
			}
		}
		if (r == null) {
			for (int i : P) {
				if (n.i == i)
					return n;
			}
			return null;
		}
		r.v ++;
		return r;
	}
	
	static int recurse2 (Node n) {
		int r = -1, p = -1;
		for (Node i : n.n) {
			if (!i.visited) {
				i.visited = true;
				i.v2 = n.v2 + 1;
				total ++;
				p = recurse2(i);
				if (r != -1) 
					total ++;
				r = Math.max(r, p);
			}
		}
		if (r == -1) 
			return n.v2;
		return r;
	}
	
	static class Node {
		int i, v, v2;
		boolean visited = false;
		ArrayList<Node> n;
		public Node(int i) {
			this.i = i;
			v = 0;
			v2 = 0;
			n = new ArrayList<>();
		}
	}

}
