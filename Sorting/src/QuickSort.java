import java.util.Random;

public class QuickSort {
	public static long sort(int[] array) {
		long beforeTime = System.nanoTime();
		sort(array, 0, array.length-1);
		return System.nanoTime()-beforeTime;
	}
	private static void sort(int[] array, int startIndex, int endIndex) {
		if(endIndex - startIndex <= 0)
			return;
		int pivotIndex = new Random().nextInt(endIndex-startIndex+1);
		
		//partitioning
		
		int temp, cursor, pivot;
		if(pivotIndex != startIndex) { //put pivot in start of array
			temp = array[startIndex];
			array[startIndex] = array[pivotIndex];
			array[pivotIndex] = temp;
			pivotIndex = startIndex;
		}
		cursor = pivotIndex + 1; //mark cursor directly after pivot
		pivot = array[pivotIndex]; //store pivot value
		while(cursor < endIndex) {
			if(array[cursor] < pivot) { //if element is less put it near the pivot
				pivotIndex++;
				temp = array[pivotIndex];
				array[pivotIndex] = array[cursor];
				array[cursor] = temp;
			}
			cursor++;
		}
		//replace the pivot with one of the small elements to put it in place
		temp = array[startIndex];
		array[startIndex] = array[pivotIndex];
		array[pivotIndex] = temp;
		
		//call sorting recursively
		sort(array, startIndex, pivotIndex-1);
		sort(array, pivotIndex+1, endIndex);
	}
}
