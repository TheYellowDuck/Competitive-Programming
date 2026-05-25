package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

public class Calendar {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] array=input.readLine().split(" ");
		int x=(int) Double.parseDouble(array[0]);
		int y=(int) Double.parseDouble(array[1]);
		System.out.println("Sun Mon Tue Wed Thr Fri Sat");
		System.out.print("  ");
		for (int i=1; i<x; i++) {
			System.out.print("    ");
		}
		int j=x;
		for (int i=1; i<=y;) {
			for (; j<=7 && i<=y; j++) {
				if (i==1)
					System.out.print(i);
				else if (j==1 && String.valueOf(i).length()==1)
					System.out.print("  "+i);
				else if (j==1 && String.valueOf(i).length()==2)
					System.out.print(" "+i);
				else if (String.valueOf(i).length()==1)
					System.out.print("   "+i);
				else
					System.out.print("  "+i);
				i++;
			}
			System.out.println();
			j=1;
		}
	}

}
