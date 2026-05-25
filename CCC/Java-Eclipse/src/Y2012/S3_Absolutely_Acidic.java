package Y2012;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.TreeSet;

public class S3_Absolutely_Acidic {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		TreeSet<Reading> set = new TreeSet<>(new FrequencyComparator());
		int N = Integer.parseInt(br.readLine());
		while (N > 0) {
			int R = Integer.parseInt(br.readLine());
			set.add(new Reading(R));
			N --;
		}
	}
	
	static class Reading {
		int val, freq = 0;
		public Reading (int val) {
			this.val = val;
			freq ++;
		}
		@Override
		public boolean equals(Object object) {
			if (object == null)
				return false;
			else {
				Reading reading = (Reading) object;
				if (this.val == reading.val) {
					int v = Math.max(this.freq, reading.freq) + 1;
					this.freq = v;
					reading.freq = v;
					return true;
				}
			}
			return false;
		}
	}
	
	static class FrequencyComparator implements Comparator<Reading> {

		@Override
		public int compare(Reading o1, Reading o2) {
			// TODO Auto-generated method stub
			if (o1.freq == o2.freq) 
				return Integer.compare(o1.val, o2.val);
			else
				return Integer.compare(o2.freq, o1.freq);
		}
		
	}

}
