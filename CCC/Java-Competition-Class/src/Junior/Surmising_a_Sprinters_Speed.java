package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Surmising_a_Sprinters_Speed {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		int size=Integer.parseInt(input.readLine());
		ArrayList<Double> time=new ArrayList<Double>();
		ArrayList<Integer> point=new ArrayList<Integer>();
		double[] array=new double[size];
		for (int i=0; i<size; i++) {
			String[] str=input.readLine().split(" ");
			double a=Double.parseDouble(str[0]);
			Integer b=Integer.parseInt(str[1]);
			if (time.size()==0) {
				time.add(a);
				point.add(b);
			}
			else {
				for (int j=0; j<time.size(); j++) {
					if (a<time.get(j)) {
						time.add(j, a);
						point.add(j, b);
						break;
					}
					else if (j==size-1) {
						time.add(a);
						point.add(b);
						break;
					}
					else {
						time.add(j+1, a);
						point.add(j+1, b);
						break;
					}
				}
			}
		}
		ArrayList<Integer> check=new ArrayList<Integer>(point);
		Collections.sort(check);
		for (int i=0; i<size; i++) {
			point.set(i, point.get(i)-check.get(0));
		}
		for (int i=size-1, j=0; i>0; i--) {
			double timer=time.get(i)-time.get(i-1);
			int n=point.get(i)-point.get(i-1);
			if (n<0) {
				n=-n;
			}
			array[j++]=n/timer;
		}
		Arrays.parallelSort(array);
		System.out.println(String.format("%.1f", array[size-1]));
	}

}
