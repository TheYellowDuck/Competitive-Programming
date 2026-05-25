package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mouse_Journey {
	static Integer[][] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] rc=input.readLine().split(" ");
		int row=Integer.parseInt(rc[0]),column=Integer.parseInt(rc[1]);
		array=new Integer[row+1][column+1];
		for (int i=0; i<=column; i++) array[row][i]=-1;
		for (int i=0; i<row; i++) array[i][column]=-1;
		array[row-1][column-1]=1;
		int cats=Integer.parseInt(input.readLine());
		for (int i=0; i<cats; i++) {
			String[] cat=input.readLine().split(" ");
			array[Integer.parseInt(cat[0])-1][Integer.parseInt(cat[1])-1]=-1;
		}
		input.close();
		System.out.println(paths(0, 0));
	}
	public static int paths(int i, int j) {
		Integer p=array[i][j];
		if (p==null) p=paths(i+1, j)+paths(i, j+1);
		else if (p==-1) return 0;
		array[i][j]=p;
		return p;
	}
}