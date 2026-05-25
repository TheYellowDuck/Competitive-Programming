package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sounds_fishy {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=(int) Double.parseDouble(input.readLine());
		int b=(int) Double.parseDouble(input.readLine());
		int c=(int) Double.parseDouble(input.readLine());
		int d=(int) Double.parseDouble(input.readLine());
		if (a<b && b<c && c<d)
			System.out.println("Fish Rising");
		else if (a>b && b>c && c>d)
			System.out.println("Fish Diving");
		else if (a==b && b==c && c==d)
			System.out.println("Fish At Constant Depth");
		else
			System.out.println("No Fish");
	}

}
