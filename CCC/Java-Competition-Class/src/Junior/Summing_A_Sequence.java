package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Summing_A_Sequence {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int v=Integer.parseInt(input.readLine());
		if (v!=0) {
			int[] array=new int[v];
			long[] ans=new long[v];
			StringTokenizer st=new StringTokenizer(input.readLine());
			for (int i=0; i<v; i ++) array[i]=Integer.parseInt(st.nextToken());
			if (array[0]>0) ans[0]=array[0];	
			ans[1]=Math.max(array[1], ans[0]); 
			for (int i=2; i<v; i++) ans[i]=Long.max(ans[i-1], ans[i-2]+array[i]);
			System.out.println(ans[v-1]);
		}
		else System.out.println(0);
	}

}

