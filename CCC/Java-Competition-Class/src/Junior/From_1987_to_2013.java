package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class From_1987_to_2013 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int s=(int) Double.parseDouble(input.readLine());
		while (true) {
			s++;
			char[] array=String.valueOf(s).toCharArray();
			int bool=0;
			for (int i=0; i<array.length-1 && bool!=1; i++) {
				for (int j=i+1; j<array.length; j++) {
					if (array[i]==array[j]) {
						bool=1;
						break;
					}
				}
			}
			if (bool==0) {
				System.out.println(s);
				break;
			}
		}
	}

}
