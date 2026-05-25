package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mod_Inverse {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		int y=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<y; i++) {
			if ((x*i)%y==1) {
				System.out.println(i);
				return;
			}
		}
		System.out.println("No such integer exists.");
	}
}
