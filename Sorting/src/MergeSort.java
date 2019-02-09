
public class MergeSort {
	public static long sort(int[] array) {
		//System.out.println(array.length);
		long beforeTime = System.nanoTime();
		if(array.length == 1)
			return System.currentTimeMillis() - beforeTime;
		int leftlength = array.length/2;
		int rightlength = array.length - leftlength;
		int[] leftarray = new int[leftlength];
		for(int i = 0; i < leftlength; i++)
			leftarray[i] = array[i];
		int[] rightarray = new int[rightlength];
		for(int i = 0; i < rightlength; i++)
			rightarray[i] = array[i+leftlength];
//		leftarray = sortArray(leftarray);
//		rightarray = sortArray(rightarray);
		sort(leftarray);
		sort(rightarray);
		int leftindex = 0, rightindex = 0;
		for(int i = 0; i < array.length; i++) {
			if(leftindex >= leftlength) {
				array[i] = rightarray[rightindex];
				rightindex++;
			}
			else if(rightindex >= rightlength) {
				array[i] = leftarray[leftindex];
				leftindex++;
			}
			else if(leftarray[leftindex] < rightarray[rightindex]) {
				array[i] = leftarray[leftindex];
				leftindex++;
			}
			
			else {
				array[i] = rightarray[rightindex];
				rightindex++;
			}
		}
		return System.nanoTime() - beforeTime;
	}
}
