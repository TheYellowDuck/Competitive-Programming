package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Slot_Machines {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int wealth=(int) Double.parseDouble(input.readLine());
		int tf=(int) Double.parseDouble(input.readLine());
		int oh=(int) Double.parseDouble(input.readLine());
		int t=(int) Double.parseDouble(input.readLine());
		int i;
		for (i=0; wealth>0; i++, wealth--) {
			switch (i%3) {
			case 0:
				tf++;
				if (tf==35) {
					wealth+=30;
					tf=0;
				}
				break;
			case 1:
				oh++;
				if (oh==100) {
					wealth+=60;
					oh=0;
				}
				break;
			case 2:
				t++;
				if (t==10) {
					wealth+=9;
					t=0;
				}
				break;
			}	
		}
		System.out.println("Martha plays "+i+" times before going broke.");
	}

}
