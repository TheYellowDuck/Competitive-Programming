package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Zero_That_Out {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=Integer.parseInt(input.readLine()), sum=0, index=0;
		int[] array=new int[n];
		for (int i=0; i<n; i++) {
			int a=Integer.parseInt(input.readLine());
			switch (a) {
			case 0:
				index--;
				sum-=array[index];
				array[index]=0;
				break;
			default:
				sum+=a;
				array[index]=a;
				index++;
				break;
			}
		}
		System.out.println(sum);
	}

}
