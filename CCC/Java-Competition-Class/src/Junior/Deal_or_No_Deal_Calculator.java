package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Deal_or_No_Deal_Calculator {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		ArrayList<Double> array=new ArrayList<Double>() {{
			add(100.0);
			add(500.0);
			add(1000.0);
			add(5000.0);
			add(10000.0);
			add(25000.0);
			add(50000.0);
			add(100000.0);
			add(500000.0);
			add(1000000.0);
		}};
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int n=(int) Double.parseDouble(input.readLine());
		int size=10;
		for (int i=0; i<n; i++, size--) {
			int index=(int) Double.parseDouble(input.readLine())-1;
			array.set(index, 0.0);
		}
		double average=(array.get(0)+array.get(1)+array.get(2)+array.get(3)+array.get(4)+array.get(5)+array.get(6)+array.get(7)+array.get(8)+array.get(9))/size;
		if ((int) Double.parseDouble(input.readLine())>average)
			System.out.println("deal");
		else
			System.out.println("no deal");
	}

}
