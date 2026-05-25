package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Huffman_Encoding {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine()), max=0, min=Integer.MAX_VALUE;
		String[] letter=new String[n], key=new String[n];
		String decoded=""; 
		for (int i=0; i<n; i++) {
			String[] array=input.readLine().split(" ");
			letter[i]=array[0];
			key[i]=array[1];
			if (array[1].length()>max)
				max=array[1].length();
			if (array[1].length()<min)
				min=array[1].length();
		}
		String str=input.readLine();
		while (str.length()>0) {
			for (int i=min; i<=max; i++) {				
				String sub=str.substring(0, i);
				for (int j=0; j<n; j++) {
					if (sub.contentEquals(key[j])) {
						decoded=decoded.concat(letter[j]);
						str=str.substring(i);
						i=max;
						break;
					}
				}
			}
		}
		System.out.println(decoded);
	}

}
