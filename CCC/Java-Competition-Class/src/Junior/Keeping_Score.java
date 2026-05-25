package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Keeping_Score {
	static int c=0, d=0, h=0, s=0, p=0;
	static String n="", l="";
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] str=new String[4];
		String strstr=input.readLine();
		str[0]=strstr.substring(1, strstr.indexOf("D")); str[1]=strstr.substring(strstr.indexOf("D")+1, strstr.indexOf("H")); str[2]=strstr.substring(strstr.indexOf("H")+1, strstr.indexOf("S")); str[3]=strstr.substring(strstr.indexOf("S")+1);
		System.out.println("Cards Dealt                        Points");
		for (int i=0; i<str.length;i++) {
			p=0;
			int add=0;
			if (str[i].contentEquals(""))
				add+=3;
			else if (str[i].length()==1)
				add+=2;
			else if (str[i].length()==2)
				add+=1;
			String[] string=str[i].replaceAll("\\d", "").replace("T", "").split("");
			for (int j=0; j<string.length; j++) {
				switch (string[j]) {
				case "A":
					add+=4;
					break;
				case "K":
					add+=3;
					break;
				case "Q":
					add+=2;
					break;
				case "J":
					add+=1;
					break;
				}
			}
			add(i, add);
			System.out.print(n+" ");
			System.out.print(String.join(" ", str[i].split("")));
			for (int j=0; !str[i].contentEquals("") && j<=l.length()-(str[i].length()*2); j++) {
				System.out.print(" ");
			}
			if (str[i].contentEquals(""))
				System.out.print(l);
			System.out.println(p);
		}
		int total=c+d+h+s;
		if (total>9)
			System.out.println("                                 Total "+total);
		else
			System.out.println("                                  Total "+total);
	}
	public static void add(int i, int add) {
		switch (i) {
		case 0:
			c+=add;
			p=c;
			n="Clubs";
			if (c>9)
				l="                                 ";
			else
				l="                                  ";
			break;
		case 1:
			d+=add;
			p=d;
			n="Diamonds";
			if (d>9)
				l="                              ";
			else
				l="                               ";
			break;
		case 2:
			h+=add;
			p=h;
			n="Hearts";
			if (h>9)
				l="                                ";
			else
				l="                                 ";
			break;
		case 3:
			s+=add;
			p=s;
			n="Spades";
			if (s>9)
				l="                                ";
			else
				l="                                 ";
			break;
		}
	}
}
