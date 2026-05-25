package Junior;

//import java.util.HashMap;

public class Duplicate_ArrayList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double a=System.currentTimeMillis();long bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
		int[] array=new int[243531772];
		int[] visited=new int[243531772];
		array[0]=243531771;
		for (int i=1; i<243531772; i++)
			array[i]=i;
		for (int i=0; i<array.length; i++) {
			if (visited[array[i]]==0)
				visited[array[i]]=1;
			else
				System.out.println(array[i]);
		}
		System.out.println((System.currentTimeMillis()-a)+"\n"+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM)/1000000);
//		HashMap<Integer, Integer> array2=new HashMap<Integer, Integer>();
//		a=System.currentTimeMillis();bUM=Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory();
//		array2.put(69999998, 0);
//		for (int i=0; i<69999999; i++) {
//			if (array2.get(i)==null)
//				array2.put(i, 1);
//			else {
//				System.out.println(i);
//				break;
//			}
//		}
//		System.out.println((System.currentTimeMillis()-a)+"\n"+((Runtime.getRuntime().totalMemory()-Runtime.getRuntime().freeMemory())-bUM));
	}

}
