
public class HeapSort {
	public static long sort(int[] array) {
		long beforeTime = System.nanoTime();
		Heap.makeHeap(array);
		sort(array, array.length);
		return System.nanoTime() - beforeTime;
	}
	private static void sort(int[] array, int size) {
		if(size == 1)
			return;
		int temp = array[0];
		array[0] = array[size-1];
		array[size-1] = temp;
		Heap.heapify(array, 0, size-1);
		sort(array,size-1);
	}
}
