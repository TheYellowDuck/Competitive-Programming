package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Federal_Voting_Age {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<n; i++) {
			String[] array=input.readLine().split(" ");
			int y=(int) Double.parseDouble(array[0]);
			int m=(int) Double.parseDouble(array[1]);
			int d=(int) Double.parseDouble(array[2]);
			if (y<1989)	
				System.out.println("Yes");
			else if (y==1989) {
				if (m<2)
					System.out.println("Yes");
				else if (m==2) {
					if (d<=27)
						System.out.println("Yes");
					else
						System.out.println("No");
				}
				else
					System.out.println("No");
			}
			else
				System.out.println("No");
		}
	}

}
