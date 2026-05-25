package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fix {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int times=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<times; i++) {
			String[] array=new String[3];
			int bool=0;
			for (int j=0; j<3; j++) {
				array[j]=input.readLine();
			}
			for (int j=0; j<array.length-1 && bool!=1; j++) {
				for (int n=j+1; n<array.length; n++) {
					if (array[j].indexOf(array[n])==0 || array[n].indexOf(array[j])==0 || (array[j].lastIndexOf(array[n])==array[j].length()-array[n].length() && array[j].length()-array[n].length()>=0) || (array[n].lastIndexOf(array[j])==array[n].length()-array[j].length() && array[n].length()-array[j].length()>=0)) {
						System.out.println("No");
						bool=1;
						break;
					}
				}
			}
			if (bool==0)
				System.out.println("Yes");
		}
	}

}
