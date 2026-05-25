package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Trident {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=(int) Double.parseDouble(input.readLine());
		int s=(int) Double.parseDouble(input.readLine());
		int h=(int) Double.parseDouble(input.readLine());
		String ti="*";
		String sp="";
		for (int i=0; i<s; i++) {
			ti=ti.concat(" ");
		}
		ti=ti.concat(ti+"*");
		for (int i=0; i<t; i++) {
			System.out.println(ti);
		}
		for (int i=0; i<(s*2)+3; i++) {
			System.out.print("*");
		}
		System.out.println();
		for (int i=0; i<s+1; i++) {
			sp=sp.concat(" ");
		}
		sp=sp.concat("*");
		for (int i=0; i<h; i++) {
			System.out.println(sp);
		}
	}

}
