package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class What_is_n_Daddy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		if (x<6)
			System.out.println(x/2+1);
		else {
			switch (x) {
			case 6:
				System.out.println(3);
				break;
			case 7:
				System.out.println(2);
				break;
			case 8:
				System.out.println(2);
				break;
			case 9:
				System.out.println(1);
				break;
			case 10:
				System.out.println(1);
				break;
			}
		}
			
	}

}
