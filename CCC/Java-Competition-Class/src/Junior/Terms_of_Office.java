package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terms_of_Office {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=(int) Double.parseDouble(input.readLine());
		int y=(int) Double.parseDouble(input.readLine());
		for (; x<=y; x+=60) {
			System.out.println("All positions change in year "+x);
		}
	}

}
