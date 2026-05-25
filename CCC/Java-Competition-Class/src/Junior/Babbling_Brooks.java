package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Babbling_Brooks {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int streamnum=(int) Double.parseDouble(input.readLine());
		ArrayList<Double> streams=new ArrayList<Double>();
		for (int i=0; i<streamnum; i++) {
			streams.add(Double.parseDouble(input.readLine()));
		}
		int action=0;
		while (action!=77) {
			action=(int) Double.parseDouble(input.readLine());
			int index;
			switch (action) {
			case 99:
				index=((int) Double.parseDouble(input.readLine()))-1;
				double percent=Double.parseDouble(input.readLine())/100;
				double flow=streams.get(index);
				streams.set(index, flow*percent);
				streams.add(index+1, flow*(1-percent));
				break;
			case 88:
				index=((int) Double.parseDouble(input.readLine()))-1;
				streams.set(index, streams.get(index)+streams.get(index+1));
				streams.remove(index+1);
				break;
			}
		}
		for (double i:streams) {
			System.out.print(String.format("%.0f", i)+" ");
		}
	}

}
