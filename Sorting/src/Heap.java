
public class Heap {
	private int[] array;
	private Heap(int[] array, boolean useSame) {
		if(useSame)
			this.array = array;
		else {
			this.array = new int[array.length];
			for(int i = 0 ; i < array.length; i++)
				this.array[i] = array[i];
		}
		buildHeap();
	}
	private void heapify(int index) {
		int 
			leftindex = getLeftIndex(index),
			rightindex = getRightIndex(index);
		int maxindex = index;
		if(leftindex != -1 && array[leftindex] > array[maxindex])
			maxindex = leftindex;
		if(rightindex != -1 && array[rightindex] > array[maxindex])
			maxindex = rightindex;
		if(maxindex != index) {
			int temp = array[index];
			array[index] = array[maxindex];
			array[maxindex] = temp;
			heapify(maxindex);
		}
	}
	private void buildHeap() {
		for(int i = array.length/2; i >= 0; i--)
			heapify(i);
	}
	static public Heap buildHeap(int[] array) {
		Heap h = new Heap(array, false);
		h.buildHeap();
		return h;
	}
	static public void makeHeap(int[] array) {
		Heap h = new Heap(array, true);
		h.buildHeap();
	}
	public int getLeftIndex(int index) {
		if(index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		int toReturn = index*2;
		if(toReturn >= array.length) return -1;
		else return toReturn;
	}
	public int getRightIndex(int index) {
		if(index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		int toReturn = index*2;
		if(++toReturn >= array.length) return -1;
		else return toReturn;
	}
	public int get(int index) {
		if(index < 0 || index >= array.length)
			throw new ArrayIndexOutOfBoundsException();
		return array[index];
	}
	public int getLeft(int index) {
		return get(getLeftIndex(index));
	}
	public int getRight(int index) {
		return get(getLeftIndex(index));
	}
}
