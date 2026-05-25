package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Mouse_Move {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ");
		int x=0, y=0, mx=Integer.parseInt(in[0]), my=Integer.parseInt(in[1]);
		String line=input.readLine();
		while (!line.contentEquals("0 0")) {
			in=line.split(" ");
			int nx=x+Integer.parseInt(in[0]), ny=y+Integer.parseInt(in[1]);
			if (nx<0)
				nx=0;
			else if (nx>mx)
				nx=mx;
			if (ny<0)
				ny=0;
			else if (ny>my)
				ny=my;
			x=nx;
			y=ny;
			System.out.println(x+" "+y);
			line=input.readLine();
		}
	}

}
