
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
		heapify(array, index, array.length);
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
	static public void heapify(int[] array, int index, int size) {
		int 
			leftindex = getLeftIndex(array, index, size),
			rightindex = getRightIndex(array, index, size);
		int maxindex = index;
		if(leftindex != -1 && array[leftindex] > array[maxindex])
			maxindex = leftindex;
		if(rightindex != -1 && array[rightindex] > array[maxindex])
			maxindex = rightindex;
		if(maxindex != index) {
			int temp = array[index];
			array[index] = array[maxindex];
			array[maxindex] = temp;
			heapify(array, maxindex, size);
		}
	}
	static public void makeHeap(int[] array) {
		Heap h = new Heap(array, true);
		h.buildHeap();
	}
	public int getLeftIndex(int index) {
		return getLeftIndex(array, index, array.length);
	}
	static public int getLeftIndex(int[] array, int index, int size) {
		if(index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		int toReturn = index*2;
		if(toReturn >= size) return -1;
		else return toReturn;
	}
	public int getRightIndex(int index) {
		return getRightIndex(array, index, array.length);
	}
	static public int getRightIndex(int[] array, int index, int size) {
		if(index < 0 || index >= size)
			throw new ArrayIndexOutOfBoundsException();
		int toReturn = index*2;
		if(++toReturn >= size) return -1;
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
