package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snakes_and_Ladders {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int tile=1;
		int move=(int) Double.parseDouble(input.readLine());
		while (move!=0 && tile!=100) {
			if (tile+move<=100) {
				tile+=move;
				switch (tile) {
				case 9:
					tile=34;
					break;
				case 40:
					tile=64;
					break;
				case 54:
					tile=19;
					break;
				case 67:
					tile=86;
					break;
				case 90:
					tile=48;
					break;
				case 99:
					tile=77;
					break;
				case 100:
					System.out.println("You are now on square "+tile);
					System.out.println("You Win!");
					return;
				}
			}
			System.out.println("You are now on square "+tile);
			move=(int) Double.parseDouble(input.readLine());
		}
		System.out.println("You Quit!");
	}

}
