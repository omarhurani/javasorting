
public class CountingSort {
	public static long sort(int[] array) {
		long beforeTime = System.nanoTime();
		int min = array[0];
		int max = array[0];
		for(int i = 1; i < array.length; i++) {
			if(array[i] < min)
				min = array[i];
			if(array[i] > max)
				max = array[i];
		}
		int[] countArray = new int[max-min+1];
		for(int i = 0; i < array.length; i++) {
			countArray[array[i]-min]++;
		}
		for(int i = 1; i < countArray.length; i++) {
			countArray[i] += countArray[i-1];
		}
		int[] sortedArray = new int[array.length];
		for(int i = array.length-1; i >= 0; i--) {
			sortedArray[--countArray[array[i]-min]] = array[i];
		}
		for(int i = 0; i < array.length; i++) {
			array[i] = sortedArray[i];
		}
		return System.nanoTime() - beforeTime;
	}
}
