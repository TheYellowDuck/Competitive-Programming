package Other;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class foxl {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		HashMap<Integer, ArrayList<Integer>> C = new HashMap<>();
		String[] in = br.readLine().split(" ");
		int N = Integer.parseInt(in[0]), M = Integer.parseInt(in[1]);
		int[] A = new int[N + 1];
		int count = N, cycle = 1;
		for (int i = 0; i < M; i++) {
			in = br.readLine().split(" ");
			int f1 = Integer.parseInt(in[0]), f2 = Integer.parseInt(in[1]);
			if (A[f1] != 0 && A[f2] != 0) {
				C.putIfAbsent(A[f1], new ArrayList<>());
				C.putIfAbsent(A[f2], new ArrayList<>());
				if (!C.get(A[f1]).contains(A[f2])) {
					count --;
					C.get(A[f1]).add(A[f2]);
					C.get(A[f2]).add(A[f1]);
				}
				
			}
			else if (A[f1] != 0 || A[f2] != 0) {
				count --;
				if (A[f1] == 0)
					A[f1] = A[f2];
				else
					A[f2] = A[f1];
			}
			else {
				count --;
				A[f1] = cycle;
				A[f2] = cycle;
				cycle ++;
			}
			System.out.println(Arrays.toString(A));
			System.out.println(count);
		}
		System.out.println(count);
	}

}
