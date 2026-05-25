package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Sheep_and_Coyotes {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		List<C> eat = new ArrayList<C>(), sh = new ArrayList<C>();
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		int s = Integer.parseInt(input.readLine());
		while (s > 0) {
			C c = new C(Double.parseDouble(input.readLine()), Double.parseDouble(input.readLine()));
			for (double i = 0; i <= 1000; i += 0.01) {
				double l = c.getLength(i);
				if (c < l) {
					l = c;
					eat.clear();
					eat.add(array[j]);
				} else if (c == l)
					eat.add(array[j]);
				for (C j : eat)
					if (j.v == 0) {
						System.out.println("The sheep at (" + String.format("%.2f", j.x) + ", "
								+ String.format("%.2f", j.y) + ") might be eaten.");
						j.v = 1;
					}
			}
			s--;
		}
	}

	public static class C {
		double x, y;
		int v = 0;

		C(double x, double y) {
			this.x = x;
			this.y = y;
		}

		double getLength(double i) {
			double xx = Math.abs(x - i);
			return Math.sqrt(xx * xx + y * y);
		}
	}
}
