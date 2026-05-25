package Junior;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class TopYodeller {
	static int[] rank, array, ranking;
	static int topv=-1001, numperson, rounds;
	static HashMap<Integer, Integer> top=new HashMap<Integer, Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
		String[] in=input.readLine().split(" ");
		numperson=(int) Double.parseDouble(in[0]); rounds=(int) Double.parseDouble(in[1]);
		rank=new int[numperson];
		array=new int[numperson];
		for (int i=0; i<rounds; i++) {
			in=input.readLine().split(" ");
			for (int j=0; j<in.length; j++) array[j]+=(int) Double.parseDouble(in[j]);
			ranking();
		}
		for (int i=0, c=0; c<top.get(topv) && i<array.length; i++)
			if (array[i]==topv) {
				System.out.println("Yodeller "+(i+1)+" is the TopYodeller: score "+topv+", worst rank "+rank[i]);
				c++;
			}
	}
	public static void ranking() {
		ranking=array.clone();
		int b=-1001;
		Arrays.parallelSort(ranking);
		topv=ranking[numperson-1];
		for (int i=numperson-1, ranked=1; i>=0; i--, ranked++) {
			for (int j=0; ranking[i]!=b && j<numperson; j++) 
				if (ranking[i]==array[j] && rank[j]<ranked) 
					rank[j]=ranked;
			b=ranking[i];
			if (top.get(ranking[i])==null) top.put(ranking[i], 1);
			else top.put(ranking[i], top.get(ranking[i])+1);
		}
	}
}
