package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Assigning_Partners {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int x=Integer.parseInt(input.readLine()), bool=0;
		str[] str=new str[x];
		String[] strs=input.readLine().split(" ", x), str2=input.readLine().split(" ", x);
		for (int i=0; i<x; i++) {
			str[i]=new str(strs[i]);
		}
		for (int i=0; i<x && bool==0; i++) {
			for (int j=0; j<x && bool==0; j++) {
				if (str[j].str.contentEquals(str2[i]) && str[i].visited==0 && str[j].visited==0) {
					if (j==i) {
						System.out.println("bad");
						bool=1;
					}
					str[i].visited=1;
					str[j].visited=1;
					String s=str2[i];
					str2[i]=str2[j];
					str2[j]=s;
				}
			}
		}
		
		for (int i=0; i<str.length && bool==0; i++) {
			if (!str[i].str.contentEquals(str2[i])) {
				System.out.println("bad");
				bool=1;
				break;
			}
		}
		if (bool==0)
			System.out.println("good");
	}
	public static class str {
		String str;
		int visited=0;
		str (String str) {
			this.str=str;
		}
	}

}
