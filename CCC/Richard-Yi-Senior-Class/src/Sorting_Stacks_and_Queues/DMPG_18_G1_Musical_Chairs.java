package Sorting_Stacks_and_Queues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class DMPG_18_G1_Musical_Chairs {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), K = Integer.parseInt(in[1]);
		int[] C = new int[N];
		Stack<Student> S = new Stack<>();
		ArrayList<Student> L = new ArrayList<>();
		in = br.readLine().split(" ");
		for (String i : in) 
			C[Integer.parseInt(i) - 1] -= 1;
		in = br.readLine().split(" ");
		for (int i = 0; i < in.length; i ++) {
			int index = Integer.parseInt(in[i]) - 1;
			C[index] += 1;
			if (C[index] == 1)
				L.add(new Student(index, i));
			else 
				K --;
		}
		Collections.sort(L, (a, b) -> a.i - b.i);
		S.addAll(L);
		int i = (S.peek().i + 1) % N;
		while (K > 0) {
			if (C[i] == -1) {
				S.pop();
				C[i] = 0;
				K --;
			}
			i = (i + 1) % N;
		}
		System.out.println(S.peek().I + 1);

	}
	
	static class Student {
		int i, I;
		Student(int i, int I) {
			this.i = i;
			this.I = I;
		}
	}

}
