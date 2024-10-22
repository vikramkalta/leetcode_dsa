import java.util.PriorityQueue;

public class MedianFinder {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }

    PriorityQueue<Integer> smallHeap = new PriorityQueue<>((a, b) -> b - a);
    PriorityQueue<Integer> bigHeap = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        smallHeap.offer(num);
        if (!bigHeap.isEmpty() && smallHeap.peek() >= bigHeap.peek()) {
            bigHeap.offer(smallHeap.remove());
        }
        if (smallHeap.size() > bigHeap.size()+1) {
            bigHeap.offer(smallHeap.remove());
        }
        if (bigHeap.size() > smallHeap.size()+1) {
            smallHeap.offer(bigHeap.remove());
        }
    }

    public double findMedian() {
        int lenSmall = smallHeap.size();
        int lenBig = bigHeap.size();
        if (lenSmall == lenBig) {
            return (double) (smallHeap.peek() + bigHeap.peek()) / 2;
        } else if (lenSmall > lenBig) {
            return smallHeap.peek();
        } else {
            return bigHeap.peek();
        }
    }
}
