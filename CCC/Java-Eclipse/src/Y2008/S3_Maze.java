package Y2008;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class S3_Maze {
	
	static int R, C;
	static Intersection[][] M;

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		while (N > 0) {
			
			R = Integer.parseInt(br.readLine());
			C = Integer.parseInt(br.readLine());
			M = new Intersection[R][C];
			
			for (int i = 0; i < R; i ++) {
				String in = br.readLine();
				for (int j = 0; j < C; j ++) 
					M[i][j] = new Intersection(i, j, in.charAt(j));
			}
			
			int count = 1;
			ArrayList<Intersection> F = new ArrayList<>();
			F.add(M[0][0]);
			M[0][0].visited = true;
			while (!F.isEmpty() && !M[R - 1][C - 1].visited) {
				ArrayList<Intersection> L = new ArrayList<>();
				for (Intersection i : F)
					L.addAll(i.getNeighbours());
				F = L;
				count ++;
			}
			
			System.out.println(M[R - 1][C - 1].visited ? count : -1);
			
			N --;
		}

	}
	
	static class Intersection {
		
		int x, y;
		char v;
		boolean visited = false;
		
		Intersection(int x, int y, char v) {
			this.x = x;
			this.y = y;
			this.v = v;
		}
		
		ArrayList<Intersection> getNeighbours() {
			
			ArrayList<Intersection> L = new ArrayList<>();
			
			if (v == '+' || v == '|') {
				if (x - 1 >= 0 && !M[x - 1][y].visited && M[x - 1][y].v != '*') {
					L.add(M[x - 1][y]);
					M[x - 1][y].visited = true;
				}
				if (x + 1 < R && !M[x + 1][y].visited && M[x + 1][y].v != '*') {
					L.add(M[x + 1][y]);
					M[x + 1][y].visited = true;
				}
			}
			
			if (v == '+' || v == '-') {
				if (y - 1 >= 0 && !M[x][y - 1].visited && M[x][y - 1].v != '*') {
					L.add(M[x][y - 1]);
					M[x][y - 1].visited = true;
				}
				if (y + 1 < C && !M[x][y + 1].visited && M[x][y + 1].v != '*') {
					L.add(M[x][y + 1]);
					M[x][y + 1].visited = true;
				}
			}
			
			return L;
		}
		
	}

}
