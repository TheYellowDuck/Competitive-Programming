package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Bridge_Transport {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int w=(int) Double.parseDouble(input.readLine()), cs=(int) Double.parseDouble(input.readLine()), sum=0;;
		int[] cars=new int[cs];
		for (int i=0; i<cs; i++) {
			cars[i]=(int) Double.parseDouble(input.readLine());
		}
		for (int i=0; i<cs; i++) {
			if (i>3)
				sum-=cars[i-4];
			sum+=cars[i];
			if (sum>w) {
				System.out.println(i);
				return;
			}
		}
		System.out.println(cs);
	}

}
