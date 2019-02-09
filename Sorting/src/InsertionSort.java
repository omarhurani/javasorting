
public class InsertionSort {
	static public long sort(int[] array) {
		int i, j, k, temp;
		long beforeTime = System.nanoTime();
		for(i = 0; i < array.length; i++) {
			for(j = i; j < array.length; j++) {
				k = j - 1;
				while(k >=0) {
					if(array[k] > array[k+1]) {
						temp = array[k];
						array[k] = array[k+1];
						array[k+1] = temp;
						k--;
					}
					else break;
				}
			}
		}
		return System.nanoTime() - beforeTime;
	}
}
