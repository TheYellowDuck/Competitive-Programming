package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Spirals {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=(int) Double.parseDouble(input.readLine());
		int[] x=new int[t], y=new int[t];
		for (int i=0; i<t; i++) {
			x[i]=(int) Double.parseDouble(input.readLine());
			y[i]=(int) Double.parseDouble(input.readLine());
		}
		for (int l=0; l<t; l++) {
			int z=y[l]-x[l]+1;
			double a=(int) Math.ceil(Math.sqrt(z));
			int empty=(int) Math.pow(a, 2)-z;
			double  b=a;
			int starta=(int) Math.ceil(a/2)-1;
			int startb=starta, ij=0;
			if (a%2==0)
				ij=2;
			for (int i=(int)a; empty>=i && i>1; i--, ij++) {
				empty-=i;
				if (ij%2==0) {
					b--;
					if (ij%4==0)
						startb--;
				}
				else {
					a--;
					if (ij%4==3)
						starta--;
				}
			}
			int[][] array=new int[(int) a][(int) b];
			array[starta][startb]=x[l];
			x[l]++;
			for (int fill=1, i=0; x[l]<=y[l]; i++) {
				switch (i) {
				case 0:
					for (int j=0; x[l]<=y[l] && j<fill; j++, x[l]++) {
						starta++;
						array[starta][startb]=x[l];
					}
					break;
				case 1:
					for (int j=0; x[l]<=y[l] && j<fill; j++, x[l]++) {
						startb++;
						array[starta][startb]=x[l];
					}
					fill++;
					break;
				case 2:
					for (int j=0; x[l]<=y[l] && j<fill; j++, x[l]++) {
						starta--;
						array[starta][startb]=x[l];
					}
					break;
				case 3:
					for (int j=0; x[l]<=y[l] && j<fill; j++, x[l]++) {
						startb--;
						array[starta][startb]=x[l];
					}
					i=-1;
					fill++;
					break;
				}
			}
			for (int[] i:array) {
				for (int j:i) {
					if (j==0)
						System.out.print("   ");
					else
						System.out.print(String.format("%2d", j)+" ");
				}
				System.out.println();
			}
			System.out.println();
		}
	}

}
