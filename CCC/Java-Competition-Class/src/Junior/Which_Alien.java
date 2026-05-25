package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Which_Alien {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=(int) Double.parseDouble(input.readLine());
		int e=(int) Double.parseDouble(input.readLine());
		if (a>2 && e<5)
			System.out.println("TroyMartian");
		if (a<7 && e>1)
			System.out.println("VladSaturnian");
		if (a<3 && e<4)
			System.out.println("GraemeMercurian");
	}

}
