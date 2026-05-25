package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Good_Times {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int o=(int) Double.parseDouble(input.readLine());
		int[] array=new int[] {o-300, o-200, o-100, o, o+100, o+130};
		String[] name=new String[] {" in Victoria", " in Edmonton", " in Winnipeg", " in Toronto", " in Halifax", " in St. John's"};
		System.out.println(o+" in Ottawa");
		for (int i=0; i<array.length; i++) {
			if (array[i]%100>59) {
				array[i]-=60;
				array[i]+=100;
			}
			if (array[i]>2359)
				array[i]-=2400;
			else if (array[i]<0) {
				array[i]+=2400;
				if (array[i]%100>59) {
					array[i]-=60;
					array[i]+=100;
				}
			}
			System.out.println(array[i]+name[i]);
		}
	}

}
