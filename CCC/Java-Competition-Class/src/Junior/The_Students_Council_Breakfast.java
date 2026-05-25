package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class The_Students_Council_Breakfast {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int[] c=new int[4];
		for (int i=0; i<4; i++) c[i]=Integer.parseInt(input.readLine());
		int t=Integer.parseInt(input.readLine()), w=0, s=Integer.MAX_VALUE;
		int p=t/c[0], g=t/c[1], r=t/c[2], o=t/c[3];
		for (int i=0; i<=p; i++) {
			for (int j=0; j<=g; j++) {
				for (int n=0; n<=r; n++) {
					for (int m=0; m<=o; m++) {
						if (i*c[0]+j*c[1]+n*c[2]+m*c[3]==t) {
							int x=i+j+n+m;
							if (x<s)
								s=x;
							System.out.println("# of PINK is "+i+" # of GREEN is "+j+" # of RED is "+n+" # of ORANGE is "+m);
							w++;
						}
					}
				}
			}
		}
		System.out.println("Total combinations is "+w+".\r\n" + 
				"Minimum number of tickets to print is "+s+".");
	}

}
