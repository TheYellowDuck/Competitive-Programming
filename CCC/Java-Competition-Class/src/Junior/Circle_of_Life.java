package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Circle_of_Life {
	static int length;
	static int[] circle;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] str=input.readLine().split(" ");
		length=(int) Double.parseDouble(str[0]);
		int cycles=(int) Double.parseDouble(str[1]);
		String strcircle=input.readLine();
		circle=new int[length];
		for (int i=0; i<length; i++) {
			circle[i]=strcircle.charAt(i)-'0';
		}	
		for (int i=0; i<cycles; i++) {
			getNeighbours();
		}
		System.out.println(Arrays.toString(circle).replace(", ", "").replace("[", "").replace("]", ""));
	}
	
	public static void getNeighbours() {
		int[] circles=new int[length];
		for (int i=0; i<length; i++) {
			int a=i-1, b=i+1;
			if (a<0)
				a=length-1;
			else if (b==length)
				b=0;
			if (circle[a]!=circle[b])
				circles[i]=1;
		}
		circle=circles;
	}
	
}
