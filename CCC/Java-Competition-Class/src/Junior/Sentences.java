package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Sentences {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(input.readLine()), l;
		String[] s;
		String[] v;
		String[] o;
		for (int i=0; i<t; i++) {
			l=Integer.parseInt(input.readLine());
			s=new String[l];
			l=Integer.parseInt(input.readLine());
			v=new String[l];
			l=Integer.parseInt(input.readLine());
			o=new String[l];
			for (int j=0; j<s.length; j++) s[j]=input.readLine();
			for (int j=0; j<v.length; j++) v[j]=input.readLine();
			for (int j=0; j<o.length; j++) o[j]=input.readLine();
			Arrays.parallelSort(s, String.CASE_INSENSITIVE_ORDER);
			Arrays.parallelSort(v, String.CASE_INSENSITIVE_ORDER);
			Arrays.parallelSort(o, String.CASE_INSENSITIVE_ORDER);
			for (int j=0; j<s.length; j++)
				for (int n=0; n<v.length; n++)
					for (int m=0; m<o.length; m++)
						System.out.println(s[j]+" "+v[n]+" "+o[m]+".");
			System.out.println();
		}
		input.close();
	}

}
