package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class wac3p4 {
	
	static int[] valid, root, rank;
	static HashSet<Integer> validList;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		HashSet<Integer> usedNodes = new HashSet<>();
		valid = new int[N]; root = new int[N]; rank = new int[N];
		validList = new HashSet<>(N);
		for (int i = 0; i < N; i ++) {
			root[i] = i;
		}
		while (M > 0) {
			in = br.readLine().split(" ");
			int n1 = Integer.parseInt(in[0]) - 1, n2 = Integer.parseInt(in[1]) - 1, w = Integer.parseInt(in[2]);
			join (n1, n2);
			usedNodes.add(n1);
			usedNodes.add(n2);
			valid[n1] += w;
			valid[n2] += w;
			if (valid[n1] % 2 != 0) validList.add(n1);
			else validList.remove(n1);
			if (valid[n2] % 2 != 0) validList.add(n2);
			else validList.remove(n2);
			System.out.println(rank[root[n1]] + 1 == usedNodes.size() ? (validList.isEmpty() || validList.size() == 2 ? "YES" : "NO") : "NO");
			M --;
		}
	}
	
	static int findRoot (int i) {
		if (root[i] == i) return i;
		root[i] = findRoot(root[i]);
		return root[i];
	}
	
	static void join (int a, int b) {
		int root1 = findRoot(a), root2 = findRoot(b);
		if (root1 == root2) return;
		if (rank[root1] == rank[root2]) {
			root[root2] = root1;
			rank[root1] += rank[root2] + 1;
		}
		else if (rank[root1] > rank[root2]) {
			root[root2] = root1;
			rank[root1] += rank[root2] + 1;
		}
		else {
			root[root1] = root2;
			rank[root2] += rank[root1] + 1;
		}
		findRoot(a); findRoot(b);
		return;
	}

}

