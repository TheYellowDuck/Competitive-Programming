package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Coins {
	
	static double[] heads, tails;
	static Double[][] ans;
	
	public static void P(int c, int h) {
		if (ans[c-1][h]==null) P(c-1, h);
		if (ans[c-1][h-1]==null) P(c-1, h-1);
		ans[c][h]=(ans[c-1][h]*tails[c-1])+(ans[c-1][h-1]*heads[c-1]);
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int coin=Integer.parseInt(input.readLine());
		heads=new double[coin];
		tails=new double[coin];
		ans=new Double[coin+1][coin+1];
		String[] in=input.readLine().split(" ");
		double v=Double.parseDouble(in[0]);
		heads[0]=v;
		tails[0]=v;
		ans[0][0]=1.0;
		ans[0][1]=0.0;
		for (int i=1; i<coin; i++) {
			ans[i][i+1]=0.0;
			ans[i][0]=ans[i-1][0]*(1-v);
			v=Double.parseDouble(in[i]);
			heads[i]=v;
			tails[i]=1-v;
		}
		ans[coin][0]=ans[coin-1][0]*tails[coin-1];
		v=0;
		coin++;
		for (int i=(coin)/2; i<coin; i++) {
			P(coin-1, i);
			v+=ans[coin-1][i];
		}
		System.out.println(v);

	}

}
