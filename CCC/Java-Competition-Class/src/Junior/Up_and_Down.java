package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Up_and_Down {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int a=(int) Double.parseDouble(input.readLine());
		int b=(int) Double.parseDouble(input.readLine());
		int c=(int) Double.parseDouble(input.readLine());
		int d=(int) Double.parseDouble(input.readLine());
		int s=(int) Double.parseDouble(input.readLine());
		int x=(a-b)*(s/(a+b));
        if (s%(a+b)<=a)
            x+=s%(a+b);
        else
            x-=(s%(a+b))-a;
        int y=(c-d)*(s/(c+d));
        if (s%(c+d)<=c )
            y+=s%(c+d);
        else
            y-=(s%(c+d))-c;
		if (x<y)
			System.out.println("Byron");
		else if (x==y)
			System.out.println("Tied");
		else
			System.out.println("Nikky");
	}

}
