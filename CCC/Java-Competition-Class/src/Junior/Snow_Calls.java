package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Snow_Calls {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int calls=(int) Double.parseDouble(input.readLine());
		for (int i=0; i<calls; i++) {
			String[] call=input.readLine().replaceAll("[^A-Z0-9]", "").split("");
			for (int j=0; j<10; j++) {
				switch(call[j]) {
				case "A":
				case "B":
				case "C":
					call[j]="2";
					break;
				case "D":
				case "E":
				case "F":
					call[j]="3";
					break;
				case "G":
				case "H":
				case "I":
					call[j]="4";
					break;
				case "J":
				case "K":
				case "L":
					call[j]="5";
					break;
				case "M":
				case "N":
				case "O":
					call[j]="6";
					break;
				case "P":
				case "Q":
				case "R":
				case "S":
					call[j]="7";
					break;
				case "T":
				case "U":
				case "V":
					call[j]="8";
					break;
				case "W":
				case "X":
				case "Y":
				case "Z":
					call[j]="9";
					break;
				}
			}
			System.out.println(call[0]+call[1]+call[2]+"-"+call[3]+call[4]+call[5]+"-"+call[6]+call[7]+call[8]+call[9]);
		}
	}

}
