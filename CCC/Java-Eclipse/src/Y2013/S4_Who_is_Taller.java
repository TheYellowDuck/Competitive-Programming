package Y2013;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class S4_Who_is_Taller {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		Classmate[] A = new Classmate[N + 1];
		while (M > 0) {
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[0]), y = Integer.parseInt(in[1]);
			if (A[x] == null)
				A[x] = new Classmate();
			if (A[y] == null)
				A[y] = new Classmate();
			A[x].shorter.add(A[y]);
			A[y].taller.add(A[x]);
			M --;
		}
		in = br.readLine().split(" ");
		int p = Integer.parseInt(in[0]), q = Integer.parseInt(in[1]);
		if (A[p] == null || A[q] == null) {
			System.out.println("unknown");
		}
		else {
			Queue<Classmate> Q = new LinkedList<Classmate>();
			Q.add(A[p]);
			A[p].tvisited = true;
			boolean notfound = true;
			while (!Q.isEmpty() && notfound) {
				Classmate taller = Q.poll();
				if (taller != null) {
					for (Classmate i : taller.shorter) {
						if (!i.tvisited) {
							i.tvisited = true;
							if (i == A[q])
								notfound = false;
							Q.add(i);
						}
					}
				}
			}
			if (!notfound)
				System.out.println("yes");
			else {
				Q = new LinkedList<Classmate>();
				Q.add(A[p]);
				A[p].svisited = true;
				while (!Q.isEmpty() && notfound) {
					Classmate shorter = Q.poll();
					if (shorter != null) {
						for (Classmate i : shorter.taller) {
							if (!i.svisited) {
								i.svisited = true;
								if (i == A[q])
									notfound = false;
								Q.add(i);
							}
						}
					}
				}
				if (!notfound)
					System.out.println("no");
				else
					System.out.println("unknown");
			}
		}
	}
	
	static class Classmate {
		ArrayList<Classmate> shorter = new ArrayList<>();
		ArrayList<Classmate> taller = new ArrayList<>();
		boolean svisited = false;
		boolean tvisited = false;
	}

}
