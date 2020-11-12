public class Heap implements IHeap {
    private int[] Heap;
    private int heapSize = 0;
    private int arraySize;

    public Heap() {
        arraySize = 4;
        Heap = new int[arraySize];
    }

    @Override
    public void insert(int item) {
        if ((heapSize + 1) == arraySize) {
            arraySize = arraySize * 2;
            int[] temp = new int[arraySize];
            for (int i = 0; i < heapSize; i++) {
                temp[i] = Heap[i];
            }
            Heap = temp;
        }
        Heap[heapSize] = item;
        moveUp(heapSize);
        heapSize++;
    }

    private void moveUp(int nodeIndex) {
        if (nodeIndex != 0) {
            int newValue = Heap[nodeIndex];
            int parentIndex = getParent(nodeIndex);
            if (Heap[nodeIndex] > Heap[getParent(nodeIndex)]) {
                int exchange = Heap[getParent(nodeIndex)];
                Heap[getParent(nodeIndex)] = Heap[nodeIndex];
                Heap[nodeIndex] = exchange;
                moveUp(parentIndex);
            }
        }
    }

    @Override
    public void insertAll(int[] items) {
        for (int x : items) {
            insert(x);
        }
    }

    @Override
    public int size() {
        return heapSize;
    }

    @Override
	public void clear() {
        heapSize = 0;
	}

    @Override
    public int removeTop() {
        int answer = Heap[0];
        Heap[0] = Heap[heapSize - 1];
        heapSize--;
        moveDown(0);
        return answer;
    }

    private void moveDown(int index) {
        int bigger;
        int leftCheck = 0;
        int rightCheck = 0;
        if (getLeft(index) < heapSize) {
            leftCheck = Heap[getLeft(index)];
            if (getRight(index) < heapSize) {
                rightCheck = Heap[getRight(index)];
            }
        }
        if (leftCheck > rightCheck) {
            bigger = getLeft(index);
        }
        else if (rightCheck > leftCheck){
            bigger = getRight(index);
        }
        else {
            bigger = -1;
        }

        if (bigger != -1 && Heap[index] < Heap[bigger]) {
            int temp = Heap[bigger];
            Heap[bigger] = Heap[index];
            Heap[index] = temp;
            moveDown(bigger);
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("[ ");
		for (int i = 0; i < (heapSize - 1); i++) {
			sb.append(Heap[i] + ", ");
		}
        sb.append(Heap[heapSize - 1] + " ]");
		return sb.toString();
    }

    private int getParent(int index) {
        return (index - 1) / 2;
    }

    private int getLeft(int index) {
        return index * 2 + 1;
    }

    private int getRight(int index) {
        return index * 2 + 2;
    }

}
