
public class Main {
	static String arrayToString(int[] array) {
		StringBuilder toPrint = new StringBuilder();
		toPrint.append("[ ");
		for(int i = 0 ; i < array.length; i++) {
			toPrint.append(String.valueOf(array[i]));
			if(i != array.length - 1)
				toPrint.append(" , ");
			
		}
		toPrint.append(" ]");
		return toPrint.toString();
	}
	
	public static void main(String[] args) {
//		int[] x =  {4, 1, 3, 2, 16, 9, 10, 14, 8, 7};
//		HeapSort.sort(x);
//		System.out.println(arrayToString(x));
		
		AppFrame f = new AppFrame();
		f.activate();
		
		
		
		
	}
}
