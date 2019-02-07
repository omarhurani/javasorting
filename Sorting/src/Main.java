
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
		int[] x = {5,8,6,1,2,9,3};
		InsertionSort.sort(x);
		System.out.println(arrayToString(x));
		
		AppFrame f = new AppFrame();
		f.activate();
	}
}
