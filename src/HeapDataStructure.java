
public class HeapDataStructure {

	int[] heap;
	int size =0;
	int capacity;
	
	public static final int FIRST = 0;
	
	HeapDataStructure(int capacity){
		this.capacity = capacity;
		this.heap = new int[capacity];
	}
	
	public int left(int pos) {
		return 2 * pos +1;
	}
	
	public int right(int pos) {
		return 2 * pos + 2;
	}
	
	public int parent(int pos) {
		return (pos -1)/2;
	}
	
	public void add(int data) {
		heap[size] = data;
		int current = size;
		size++;
		
		while(heap[current] < heap[parent(current)]) {
			swap(current,parent(current));
			current = parent(current);
		}
	}
	
	public int getMin() {
		
		int data = heap[FIRST];
		
		heap[FIRST] = heap[size- 1];
		heap[size- 1] =0;
		size = size - 1;
		heapify(FIRST);
		
		return data;
		
	}

	private void heapify(int pos) {
		
		int smallest = pos;
		int left = left(pos);
		int right = right(pos);
		
		if(left < size && heap[left]< heap[smallest]) {
			smallest = left;
		}
		if(right < size && heap[right] < heap[smallest]) {
			smallest = right;
		}
		
		if(smallest != pos) {
			swap(smallest,pos);
			heapify(smallest);
		}
	}

	private void swap(int smallest, int pos) {
		int temp = heap[smallest];
		heap[smallest] = heap[pos];
		heap[pos] = temp;
		
	}
}
