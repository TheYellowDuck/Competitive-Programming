package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Magic_Squares {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int[][] array=new int[4][4];
		for (int i=0; i<4; i++) {
			String[] str=input.readLine().split(" ");
			for (int j=0; j<4; j++) {
				array[i][j]=Integer.parseInt(str[j]);
			}
		}
		int total=array[0][0]+array[0][1]+array[0][2]+array[0][3];
		for (int i=0; i<4; i++) {
			if(array[i][0]+array[i][1]+array[i][2]+array[i][3]!=total || array[0][i]+array[1][i]+array[2][i]+array[3][i]!=total) {
				System.out.println("not magic");
				return;
			}
		}
		System.out.println("magic");
	}

}
