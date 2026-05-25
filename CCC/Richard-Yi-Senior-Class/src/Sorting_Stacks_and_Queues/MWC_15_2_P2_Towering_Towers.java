package Sorting_Stacks_and_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Stack;

public class MWC_15_2_P2_Towering_Towers {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		Stack<Integer> s = new Stack<>();
//		s.push(0);
		int N = Integer.parseInt(br.readLine()), p = 0;
		int[] a = new int[N], s = new int[N + 1];
		s[0] = 0;
		String[] in = br.readLine().split(" ");
		for (int i = 0; i < N; i++) {
			a[i] = Integer.parseInt(in[i]);
			while (p > 0 && a[i] >= a[s[p]]) 
				p --;
			System.out.print((i - s[p]) + " ");
			p ++;
			s[p] = i;
		}

	}

}
