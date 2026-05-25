package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Smile_with_Similes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		int y=(int) Double.parseDouble(input.readLine());
		String[] a=new String[x];
		String[] n=new String[y];
		for (int i=0; i<x; i++) {
			a[i]=input.readLine();
		}
		for (int i=0; i<y; i++) {
			n[i]=input.readLine();
		}
		for (int i=0; i<x; i++) {
			for (int j=0; j<y; j++) {
				System.out.println(a[i]+" as "+n[j]);
			}
		}
	}

}
