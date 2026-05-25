package Y2020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.HashMap;

public class J5_S2_Escape_Room {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Node>> mp = new HashMap<>();
		int m = Integer.parseInt(input.readLine()), n = Integer.parseInt(input.readLine());
		Node start = null;
		for (int i = 1; i <= m; i++) {
			String[] in = input.readLine().split(" ");
			for (int j = 1; j <= n; j++) {
				start = new Node(i, j);
				int val = Integer.parseInt(in[j - 1]);
				ArrayList<Node> l = mp.getOrDefault(val, new ArrayList<>());
				l.add(start);
				mp.put(val, l);
			}
		}
		Queue<Node> q = new LinkedList<>();
		q.add(start);
		while (q.size() != 0) {
			start = q.poll();
			ArrayList<Node> l = mp.get(start.x * start.y);
			for (Node i : l) {
				if (i.x == 1 && i.y == 1) {
					System.out.println("yes");
					System.exit(0);
				}
				q.add(i);
			}
			mp.remove(start.x * start.y);
		}
		System.out.println("no");
	}
	
	static class Node {
		int x, y;
		Node(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

}
