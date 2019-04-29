
public class HeapSolution {

	public static void main(String[] args) {

		HeapDataStructure heapDataStructure = new HeapDataStructure(5);
		
		heapDataStructure.add(4);
		heapDataStructure.add(5);
		heapDataStructure.add(1);
		heapDataStructure.add(2);
		int size = heapDataStructure.size;
		for(int i =0;i<size;i++) {
			System.out.println(heapDataStructure.getMin());
		}

	}

}
