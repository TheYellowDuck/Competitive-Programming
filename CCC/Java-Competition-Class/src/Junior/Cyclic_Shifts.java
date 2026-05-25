package Junior;

import java.util.Scanner;

public class Cyclic_Shifts {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		String str1t=input.nextLine();
		String str2t=input.nextLine();
		String str1;
		String str2;
		if (str1t.length()>str2t.length()) {
			str1=str1t;
			str2=str2t;
		}
		else {
			str1=str2t;
			str2=str1t;
		}
		boolean check=false;
		for (int i=0; i<str2.length(); i++) {
			str2=str2.substring(1, str2.length()).concat(str2.substring(0, 1));
			if (str1.contains(str2)) {
				System.out.println("yes");
				check=true;
				break;
			}
		}
		if (check==false) {
			System.out.println("no");
		}
	}

}
