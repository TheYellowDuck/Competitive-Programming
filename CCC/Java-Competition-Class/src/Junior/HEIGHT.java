package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HEIGHT {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int t=Integer.parseInt(input.readLine()), sum, v, a, b, m, bool;
		int[] array=new int[t], ans=new int[t];
		for (int i=0; i<t; i++) {
			v=Integer.parseInt(input.readLine());
			array[i]=v;
			ans[i]=v;
		}
		sum=array[t-1];
		for (int i=t-2; i>=0; i--) { 
			v=array[i];
			a=ans[i];
			m=a;
			bool=1;
			for (int j=i+1; j<t; j++) {
				b=a;
				if (v<array[j]) {
					b+=ans[j];
					if (m<b) m=b;
					bool=0;
				}
			}
			if (bool==1 && sum<v) sum=v;
			else {
				ans[i]=m;
				if (sum<m) sum=m;
			}
		}
		System.out.println(sum);

	}

}

