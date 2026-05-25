package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Cross_Spiral {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int c=(int) Double.parseDouble(input.readLine()), r=(int) Double.parseDouble(input.readLine()), sc=(int) Double.parseDouble(input.readLine()), sr=(int) Double.parseDouble(input.readLine()), steps=(int) Double.parseDouble(input.readLine());
		int[][] grid=new int[r][c];
		for (int i=0; i<sr; i++) {
			for (int j=0; j<sc; j++) {
				grid[i][j]=1;
				grid[i][c-j-1]=1;
				grid[r-i-1][j]=1;
				grid[r-i-1][c-j-1]=1;
			}
		}
		int x=0, y=sc, count=c-sc+sr-2, count2=r-sr+sc-2;
		grid[x][y]=1;
		for (int i=0, d=0, c1=0; i<steps; i++, c1++) {
			switch (d) {
			case 0:
				if (y+1<c && grid[x][y+1]==0) {
					y++;
					grid[x][y]=1;
				}
				else if (x+1<r && grid[x+1][y]==0) {
					x++;
					grid[x][y]=1;
				}
				if (c1==count) {
					d=1;
					c1=-1;
				}
				break;
			case 1:
				if (x+1<r && grid[x+1][y]==0) {
					x++;
					grid[x][y]=1;
				}
				else if (y-1>=0 && grid[x][y-1]==0) {
					y--;
					grid[x][y]=1;
				}
				if (c1==count2) {
					d=2;
					c1=-1;
				}
				break;
			case 2:
				if (y-1>=0 && grid[x][y-1]==0) {
					y--;
					grid[x][y]=1;
				}
				else if (x-1>=0 && grid[x-1][y]==0) {
					x--;
					grid[x][y]=1;
				}
				if (c1==count) {
					d=3;
					c1=-1;
					count--;
				}
				break;
			case 3:
				if (x-1>=0 && grid[x-1][y]==0) {
					x--;
					grid[x][y]=1;
				}
				else if (y+1>=0 && grid[x][y+1]==0) {
					y++;
					grid[x][y]=1;
				}
				if (c1==count2) {
					d=0;
					c1=-1;
					count2--;
				}
				break;
			}
			for (int[] j:grid) {
				for (int n:j) System.out.print(n);
				System.out.println();
			}
			System.out.println(count+" "+count2+" "+c1+" "+d);
			System.out.println();
		}
		System.out.println((y+1)+"\n"+(x+1));
	}

}
