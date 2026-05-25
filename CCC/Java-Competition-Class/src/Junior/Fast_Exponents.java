package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fast_Exponents {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int l=Integer.parseInt(input.readLine()), bool=0;
		long n, s;
		for (int i=0; i<l; i++) {
			n=Integer.parseInt(input.readLine());
			bool=0;
			if (n==1 || n==2 || n==4 || n==8 || n==16 || n==32 || n==64 || n==128 || n==256 || n==512 || n==1024 || n==2048 || n==4096 || n==8192 || n==16384 || n==32768 || n==65536 || n==131072) System.out.println("T");
			else if (n%2==1) System.out.println("F");
			else {
				while (bool==0) {
					s=n%16;
					if (s==2 || s==4 || s==8 || s==16 || s==32 || s==64 || s==128 || s==256 || s==512 || s==1024 || s==2048 || s==4096 || s==8192 || s==16384 || s==32768 || s==65536 || s==131072) {
						System.out.println("T");
						bool=1;
					}
					if (s%2==0) n/=16;
					else {
						System.out.println("F");
						bool=1;
					}
				}
			}
		}
	}

}
