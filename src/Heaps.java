import java.util.Arrays;

// Heap Datastructure implementation - Min Heap
public class Heaps {
	public int[] array;
	public int capacity;
	public int count;
	public int heap_type;
	
	// Constructor 
	public Heaps(int capacity, int count, int heap_type) {
		this.array = new int[capacity];
		this.capacity = capacity;
		this.count = count;
		this.heap_type = heap_type;
	}
	
	// Get parents Index
	public int getParentIndex(int index) {
		if(index <= 0 || index >= this.count)
			return -1;
			
		return (index - 1)/2;
	}
	
	// Get left Index
	public int getLeftChildIndex(int index) {
		int left = (2 * index) + 1;

		if(index >= this.count)
			return -1;
		return left;		
	}
	
	// Get right Index
	public int getRightChildIndex(int index) {
		int right = (2 * index) + 2;
		
		if(index >= this.count)
			return -1;
		
		return right;
	}
	
	// check if parent of the current index exits
	public boolean hasParent(int index) {
		return getParentIndex(index) >=0;
	}
	
	// Double the array size and copy the existing array
	public void ensureExtraCapacity() {
		if(count == capacity) {
			array = Arrays.copyOf(array, capacity*2);
			capacity *= 2;
		}
	}
	
	// Get the zeroth index element from array but don't remove it
	public int peek() {
		
		if(count == 0 )
			throw new IllegalStateException();
		
		return array[0];
	}
	
	// add the elements into the heap
	public void add(int element) {
		ensureExtraCapacity();
		array[count] = element;
		count++;
		heapifyUp();
	}

	private void heapifyUp() {
		int index = count-1;
		
		while(getParentIndex(index) > array[index] && hasParent(index)) {
			swap(getParentIndex(index), index);
			index = getParentIndex(index);
		}
	}

	private void swap(int parent, int index) {
		
		int temp = array[parent];
		array[parent] = array[index];
		array[index] = temp;
	}
	
	
}
