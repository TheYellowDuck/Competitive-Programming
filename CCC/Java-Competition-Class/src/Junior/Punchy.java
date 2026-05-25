package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Punchy {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] array=input.readLine().split(" ");
		int a=0, b=0;
		while (!array[0].contentEquals("7")) {
			switch (array[0]) {
			case "1":
				switch (array[1]) {
				case "A":
					switch (array[2]) {
					case "A":
						break;
					case "B":
						a=b;
						break;
					default:
						a=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				case "B":
					switch (array[2]) {
					case "A":
						b=a;
						break;
					case "B":
						break;
					default:
						b=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				}
				break;
			case "2":
				switch (array[1]) {
				case "A":
					System.out.println(a);
					break;
				case "B":
					System.out.println(b);
					break;
				}
				break;
			case "3":
				switch (array[1]) {
				case "A":
					switch (array[2]) {
					case "A":
						a+=a;
						break;
					case "B":
						a+=b;
						break;
					default:
						a+=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				case "B":
					switch (array[2]) {
					case "A":
						b+=a;
						break;
					case "B":
						b+=b;
						break;
					default:
						b+=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				}
				break;
			case "4":
				switch (array[1]) {
				case "A":
					switch (array[2]) {
					case "A":
						a*=a;
						break;
					case "B":
						a*=b;
						break;
					default:
						a*=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				case "B":
					switch (array[2]) {
					case "A":
						b*=a;
						break;
					case "B":
						b*=b;
						break;
					default:
						b*=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				}
				break;
			case "5":
				switch (array[1]) {
				case "A":
					switch (array[2]) {
					case "A":
						a-=a;
						break;
					case "B":
						a-=b;
						break;
					default:
						a-=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				case "B":
					switch (array[2]) {
					case "A":
						b-=a;
						break;
					case "B":
						b-=b;
						break;
					default:
						b-=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				}
				break;
			case "6":
				switch (array[1]) {
				case "A":
					switch (array[2]) {
					case "A":
						a/=a;
						break;
					case "B":
						a/=b;
						break;
					default:
						a/=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				case "B":
					switch (array[2]) {
					case "A":
						b/=a;
						break;
					case "B":
						b/=b;
						break;
					default:
						b/=(int) Double.parseDouble(array[2]);
						break;
					}
					break;
				}
				break;
			}
			array=input.readLine().split(" ");
		}
	}

}
