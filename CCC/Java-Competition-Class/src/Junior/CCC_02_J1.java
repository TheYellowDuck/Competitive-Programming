package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CCC_02_J1 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		String h=" * * *\n", v1="*     *\n*     *\n*     *\n", v2="*\n*\n*\n", v3="      *\n      *\n      *\n";
		switch (x) {
		case 0:
			System.out.print(h+v1+"\n"+v1+h);
			break;
		case 1:
			System.out.print(v3+"\n"+"\n"+v3);
			break;
		case 2:
			System.out.print(h+v3+h+v2+h);
			break;
		case 3:
			System.out.print(h+v3+h+v3+h);
			break;
		case 4:
			System.out.print(v1+h+v3);
			break;
		case 5:
			System.out.print(h+v2+h+v3+h);
			break;
		case 6:
			System.out.print(h+v2+h+v1+h);
			break;
		case 7:
			System.out.print(h+v3+"\n"+v3);
			break;
		case 8:
			System.out.print(h+v1+h+v1+h);
			break;
		case 9:
			System.out.print(h+v1+h+v3+h);
			break;
		}
	}

}
