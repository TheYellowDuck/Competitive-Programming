package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class The_Cell_Sell {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		double d=Double.parseDouble(input.readLine());
		double e=Double.parseDouble(input.readLine());
		double w=Double.parseDouble(input.readLine());
		double d2=d-250;
		double e2=e;
		double w2=w;
		d-=100;
		d*=0.25;
		if (d<0)
			d=0;
		e*=0.15;
		w*=0.2;
		d2*=0.45;
		if (d2<0)
			d2=0;
		e2*=0.35;
		w2*=0.25;
		String total=String.format("%.2f", d+e+w);
		String total2=String.format("%.2f", d2+e2+w2);
		System.out.println("Plan A costs "+total);
		System.out.println("Plan B costs "+total2);
		if (d+e+w<d2+e2+w2)
			System.out.println("Plan A is cheapest.");
		else if (d+e+w==d2+e2+w2)
			System.out.println("Plan A and B are the same price.");
		else
			System.out.println("Plan B is cheapest.");
	}

}
