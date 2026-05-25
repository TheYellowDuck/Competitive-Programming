package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Weak_Passwords {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int hash;
		for (int i=0; i<5; i++) {
			hash=Integer.parseInt(input.readLine());
			for (int a=65; a<91 && hash!=0; a++) for (int b=65; b<91 && hash!=0; b++) for (int c=65; c<91 && hash!=0; c++) for (int d=65; d<91; d++) 
				if (((a*1000000)+(b*10000)+(c*100)+d)%((a*11)+(b*101)+(c*1009)+(d*10007))==hash) {
					System.out.println(((char) a)+""+((char) b)+""+((char) c)+""+((char) d));
					hash=0;
					break;
				}
		}

	}

}
