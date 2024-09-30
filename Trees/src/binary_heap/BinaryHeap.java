package binary_heap;

public class BinaryHeap {
	private int[] arr;
	private int sizeOfTree;
	private String heapType;

	public BinaryHeap(int size, String heapType) {
		this.sizeOfTree = 0;
		this.arr = new int[size + 1];
		this.heapType = heapType;
	}

	private boolean isEmpty() {
		if (sizeOfTree == 0) {
			return true;
		}
		return false;
	}

	public void levelOrder() {
		for (int i = 1; i < this.arr.length; i++) {
			System.out.print(this.arr[i] + " ");
		}
		System.out.println();
	}

	public void insert(int value) {
		if (sizeOfTree == this.arr.length) {
			System.out.println("Tree is full");
			return;
		}
		arr[sizeOfTree + 1] = value;
		sizeOfTree++;
		heapifyBottomToTop(sizeOfTree);
		System.out.println("Inserted " + value + " successfully in Heap");
	}

	private void heapifyBottomToTop(int index) {
		int parent = index / 2;
		if (index <= 1) {
			return;
		}
		if (this.heapType.equals("min")) {
			if (arr[index] < arr[parent]) {
				int tmp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = tmp;
			}
		} else if (this.heapType.equals("max")) {
			if (arr[index] > arr[parent]) {
				int tmp = arr[index];
				arr[index] = arr[parent];
				arr[parent] = tmp;
			}
		}
		heapifyBottomToTop(parent);
	}

	public int extractHeadOfBH() {
		if (isEmpty()) {
			return -1;
		}
		int extractedValue = arr[1];
		arr[1] = arr[this.sizeOfTree];
		sizeOfTree--;
		heapifyTopToBottom(1);
		return extractedValue;
	}

	private void heapifyTopToBottom(int index) {
		int left = index * 2;
		int right = index * 2 + 1;
		int swapChild = sizeOfTree;
		if (sizeOfTree < left) {
			return;
		}
		if (this.heapType.equals("min")) {
			if (this.sizeOfTree == left) {
				if (this.arr[index] > this.arr[left]) {
					int tmp = arr[index];
					arr[index] = arr[left];
					arr[left] = tmp;
				}
				return;
			} else {
				if (arr[left] < arr[right]) {
					swapChild = left;
				} else {
					swapChild = right;
				}
				if (arr[index] > arr[swapChild]) {
					int tmp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = tmp;
				}
			}
		} else if (this.heapType.equals("max")) {
			if (this.sizeOfTree == left) {
				if (this.arr[index] < this.arr[left]) {
					int tmp = arr[index];
					arr[index] = arr[left];
					arr[left] = tmp;
				}
				return;
			} else {
				if (arr[left] > arr[right]) {
					swapChild = left;
				} else {
					swapChild = right;
				}
				if (arr[index] < arr[swapChild]) {
					int tmp = arr[index];
					arr[index] = arr[swapChild];
					arr[swapChild] = tmp;
				}
			}
		}
		heapifyTopToBottom(swapChild);
	}
}
