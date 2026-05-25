package Fun_Problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class A_Knapsack {
	
	static class Node {
		int i, v;
		Node(int i, int v) {
			this.i = i;
			this.v = v;
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		while(T -- > 0) {
			
			String[] in = br.readLine().split(" ");
			int N = Integer.parseInt(in[0]);
			long W = Long.parseLong(in[1]);
			Node[] a = new Node[N];
			in = br.readLine().split(" ");
			
			for (int i = 0; i < N; i++) 
				a[i] = new Node(i + 1, Integer.parseInt(in[i]));
			
			Arrays.sort(a, (x, y) -> x.v - y.v);
			
			ArrayList<Integer> l = new ArrayList<Integer>();
			long sum = 0, half = (W + 1) / 2;
			for (int i = N - 1; i >= 0; i --) {
				if (sum + a[i].v > W)
					continue;
				sum += a[i].v;
				l.add(a[i].i);
				if (sum >= half) {
					System.out.println(l.size());
					l.forEach(x -> System.out.print(x + " "));
					System.out.println();
					break;
				}
			}
			if (sum < half)
				System.out.println(-1);
			
		}

	}

}
