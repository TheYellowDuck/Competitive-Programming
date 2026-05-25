package Advanced_Prefix_Arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class MEC_16_P6_Instruments_of_the_Ghostwriters {
	
	static Trio[][] A;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] in = br.readLine().split(" ");
		int C = Integer.parseInt(in[0]), R = Integer.parseInt(in[1]), M = Integer.parseInt(in[2]), Q = Integer.parseInt(in[3]);
		A = new Trio[C + 1][R + 1];
		
		while (M -- > 0) {
			
			in = br.readLine().split(" ");
			int x = Integer.parseInt(in[1]) - 1, y = Integer.parseInt(in[2]), f = Integer.parseInt(in[3]);
			
			if (A[0][x] == null) 
				A[0][x] = new Trio();
			if (A[R + 1][y] == null)
				A[R + 1][y] = new Trio();
			if (A[0][y] == null)
				A[0][y] = new Trio();
			if (A[R + 1][x] == null)
				A[R + 1][x] = new Trio();
				
			switch(in[0]) {
			case "c" :
				
				if (f == 0) {
					A[0][x].Z += 1;
					A[R + 1][y].Z += 1;
					A[0][y].Z -= 1;
					A[R + 1][x].Z -= 1;
				}
				else {
					A[0][x].M *= f;
					A[R + 1][y].M *= f;
					A[0][y].D *= f;
					A[R + 1][x].D *= f;
				}
				
				break;
			case "r" :
				
				if (f == 0) {
					A[x][0].Z += 1;
					A[y][C + 1].Z += 1;
					A[y][0].Z -= 1;
					A[x][C + 1].Z -= 1;
				}
				else {
					A[x][0].M *= f;
					A[y][C + 1].M *= f;
					A[y][0].D *= f;
					A[x][C + 1].D *= f;
				}
				
				break;
				
			}
			
		}
		
		HashMap<Integer, Integer> mp = new HashMap<>();
		
		for (int i = 0; i < R; i ++) {
			for (int j = 0; j < C; j ++) {
				if (A[i][j] == null);
					A[i][j] = new Trio();
				A[i][j].merge(i, j);
				mp.put(A[i][j].V, mp.getOrDefault(A[i][j].V, 0) + 1);
			}
		}
		
		while (Q -- > 0) {
			
			in = br.readLine().split(" ");
			long B = Long.parseLong(in[0]), O = Long.parseLong(in[1]);
			
			if (B == 0) {
				if (O == 0)
					System.out.println(C * R);
			}
			
		}

	}
	
	static class Trio {
		
		int M = 1, D = 1, Z = 0;
		int V = 0;
		
		void merge(int x, int y) {
			
			Z += x == 0 ? 0 : A[x - 1][y].Z;
			Z += y == 0 ? 0 : A[x][y - 1].Z;
			Z += x == 0 || y == 0 ? 0 : A[x - 1][y - 1].Z;
			
			M *= x == 0 ? 1 : A[x - 1][y].M;
			M *= y == 0 ? 1 : A[x][y - 1].M;
			D *= x == 0 || y == 0 ? 1 : A[x - 1][y - 1].M;
			
			D *= x == 0 ? 1 : A[x - 1][y].D;
			D *= y == 0 ? 1 : A[x][y - 1].D;
			M *= x == 0 || y == 0 ? 1 : A[x - 1][y - 1].D;
			
			V += A[x - 1][y].V;
			V += A[x][y - 1].V;
			V -= A[x - 1][y - 1].V;
			
			if (Z > 0)
				V = 0;
			else 
				V += M / D;
			
		}
		
	}

}
