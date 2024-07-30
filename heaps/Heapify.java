import java.util.ArrayList;
import java.util.List;

public class Heapify {
    public static void main(String[] args) {
        int[] arr = { 3, 8, 1, 7, 2, 9 };
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            // list.add(arr[i]);
            insert(list, arr[i]);
        }
    }

    public static void insert(List<Integer> heap, int num) {
        if (heap.isEmpty()) {
            heap.add(num);
        } else {
            heap.add(num);
            int size = heap.size();
            for (int i = size / 2 - 1; i >= 0; i--) {
                heapify(heap, i);
            }
        }
    }

    public static void heapify(List<Integer> heap, int i) {
        int size = heap.size();
        int largest = i;
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        if (leftChild < size && heap.get(leftChild) > heap.get(largest)) {
            largest = leftChild;
        }
        if (rightChild < size && heap.get(rightChild) > heap.get(largest)) {
            largest = rightChild;
        }
        if (largest != i) {
            int temp = heap.get(largest);
            heap.set(largest, heap.get(i));
            heap.set(i, temp);
            heapify(heap, largest);
        }
    }
}
