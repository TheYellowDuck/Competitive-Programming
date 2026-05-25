package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bubble_Sort {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine()), bool=0, a;
		String[] str=input.readLine().split(" ", l);
		int[] array=new int[l];
		for (int i=0; i<l; i++) array[i]=Integer.parseInt(str[i]);
		while (bool==0) {
			bool=1;
			for (int i=1; i<l; i++) {
				a=array[i-1];
				if (a>array[i]) {
					for (int j:array) System.out.print(j+" ");
					System.out.println();
					array[i-1]=array[i];
					array[i]=a;
					bool=0;
				}
			}
		}
		for (int i:array) System.out.print(i+" ");
	}

}
