package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Dressing_Up {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int height=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<=(int)(height/2); i++) {
			System.out.print("*");
			for (int j=0; j<i; j++) {
				System.out.print("**");
			}
			for (int j=i; j<(int)(height/2); j++) {
				System.out.print("    ");
			}
			System.out.print("*");
			for (int j=0; j<i; j++) {
				System.out.print("**");
			}
			System.out.println();
		}
		for (int i=(int)(height/2); i>0; i--) {
			System.out.print("*");
			for (int j=i-1; j>0; j--) {
				System.out.print("**");
			}
			for (int j=i; j<=(int)(height/2); j++) {
				System.out.print("    ");
			}
			System.out.print("*");
			for (int j=i-1; j>0; j--) {
				System.out.print("**");
			}
			System.out.println();
		}
	}

}
