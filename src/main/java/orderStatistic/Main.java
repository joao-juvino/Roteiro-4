package orderStatistic;

public class Main {
	public static void main(String[] args) {
		QuickSelect<Integer> qs = new QuickSelect<Integer>();
		
		Integer[] array1 = {1,5,3,8,0,9};
		Integer[] array2 = {1,5,3,8,0,9,-1};
		
		System.out.println(qs.quickSelect(array2, 7));
	}
}
