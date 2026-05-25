package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

public class The_Geneva_Confection {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int ts=Integer.parseInt(input.readLine());
		BigDecimal a=new BigDecimal(System.nanoTime());
		for (int i=0; i<ts; i++) {
			int t=Integer.parseInt(input.readLine()), car=1, mi=0, bi=t-1;
			int[] m=new int[t], b=new int[t+1];
			for (int j=t-1; j>=0; j--) {
				m[j]=Integer.parseInt(input.readLine());
			}
			while (true) {
				if (mi<t && m[mi]==car) {
					m[mi]=0;
					car++;
					mi++;
				}
				else if (bi<t-1 && b[bi+1]==car) {
					b[bi+1]=0;
					car++;
					bi++;
				}
				else if (mi<t && m!=null){
					b[bi]=m[mi];
					m[mi]=0;
					mi++;
					bi--;
				}
				else
					break;
			}
			boolean e=true;
			for (int ii=0; ii<t; ii++) {
				if (m[ii]!=0 || b[ii]!=0) {
					e=false;
					break;
				}
			}
			System.out.println(e?"Y":"N");
		}
		System.out.println(new BigDecimal(System.nanoTime()).subtract(a).divide(new BigDecimal("1000000000")));
	}

}
