package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class English_or_French {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine());
		int s=0, t=0;
		for (int i=0; i<n; i++) {
        	char[] array=input.readLine().toCharArray();
	        for (int j=0; j<array.length; j++) {
	        	if (array[j]=='S' || array[j]=='s')
	        		s++;
	        	else if (array[j]=='T' || array[j]=='t')
	        		t++;
	        }
		}
        if (t>s)
        	System.out.println("English");
        else
        	System.out.println("French");
	}

}
