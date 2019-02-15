
public class QuickSort {
	public static long sort(int[] array) {
		long beforeTime = System.nanoTime();
		sort(array, 0, array.length-1);
		return System.nanoTime()-beforeTime;
	}
	private static void sort(int[] array, int startIndex, int endIndex) {
		
	}
}
