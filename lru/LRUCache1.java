import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache1 {
    public static void main(String args[]) {
        LRUCache1 lru = new LRUCache1(2);
        put(1, 2);
        put(2, 3);
        System.out.println(get(1));
        put(3, 4);
        System.out.println(doublyQueue);
    }
    LRUCache1(int n) {
        size = n;
        doublyQueue = new LinkedList<>();
    }
    private static HashMap<Integer, Integer> hm = new HashMap<>();
    private static Deque<Integer> doublyQueue;
    private static int size;

    public static void refer(int key) {
        if (!hm.containsKey(key)) {
            if (doublyQueue.size() == size) {
                int last = doublyQueue.removeLast();
                hm.remove(last);
            }
        } else {
            doublyQueue.remove(key);
        }
        doublyQueue.push(key);
    }
    public static void put(int key, int value) {
        refer(key);
        hm.put(key, value);
    }
    public static int get(int key) {
        if (hm.containsKey(key)) {
            refer(key);
            return hm.get(key);
        }
        return -1;
    }

}
