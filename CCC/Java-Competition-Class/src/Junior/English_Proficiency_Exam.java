package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class English_Proficiency_Exam {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ");
		char[] ch;
		int l;
		for (String i:in) {
			ch=i.toCharArray();
			if (ch.length==1 && (ch[0]!='a' && ch[0]!='e' && ch[0]!='i' && ch[0]!='o' && ch[0]!='u')) {
				System.out.println("not readable");
				return;
			}
			l=0;
			for (char j:ch) {
				if (j=='a' || j=='e' || j=='i' || j=='o' || j=='u') l++;
				else l--;
			}
			if (l!=0 && Math.abs(l)!=1) {
				System.out.println("not readable");
				return;
			}
		}
		System.out.println("readable");
	}

}
