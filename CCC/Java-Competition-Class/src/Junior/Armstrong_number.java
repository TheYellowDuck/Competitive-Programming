package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Armstrong_number {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int[] a=new int[] {153, 370, 371, 407};
		String[] in=input.readLine().split(" ");
		int x=Integer.parseInt(in[0])-1, y=Integer.parseInt(in[1])+1;
		for (int i:a) if (x<i && i<y) System.out.println(i);

	}

}
