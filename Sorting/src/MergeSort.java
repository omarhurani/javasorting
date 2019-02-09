
public class MergeSort {
	public static long sort(int[] array) {
		long beforeTime = System.currentTimeMillis();
		sortArray(array);
		return System.currentTimeMillis()-beforeTime;
	}
	private static void sortArray(int[] array) {
		//System.out.println(array.length);
		if(array.length == 1)
			return;
		int leftlength = array.length/2;
		int rightlength = array.length - leftlength;
		int[] leftarray = new int[leftlength];
		for(int i = 0; i < leftlength; i++)
			leftarray[i] = array[i];
		int[] rightarray = new int[rightlength];
		for(int i = 0; i < rightlength; i++)
			rightarray[i] = array[i+rightlength];
//		leftarray = sortArray(leftarray);
//		rightarray = sortArray(rightarray);
		sortArray(leftarray);
		sortArray(rightarray);
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
		//return array;
	}
}
