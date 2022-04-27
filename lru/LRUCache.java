import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache {
    public static void main(String args[]) {
        LRUCache lru = new LRUCache(2);
        put(1, 2);
        put(2, 3);
        System.out.println(get(1));
        System.out.println(get(3));
        put(3, 4);
        System.out.println(doublyQueue);
    }

    private static Deque<Integer> doublyQueue; 

    private static HashMap<Integer, Integer> hm = new HashMap<>();
    // private static HashSet<Integer> hm = new HashSet<>();

    private static int len = 0;

    public LRUCache(int capacity) {
        len = capacity;
        doublyQueue = new LinkedList<>();
    }

    public static void refer(int page) {
        if (!hm.containsKey(page)) {
            if (doublyQueue.size() == len) {
                int last = doublyQueue.removeLast();
                hm.remove(last);
            }
        } else {
            doublyQueue.remove(page);
        }
        doublyQueue.push(page);
    }

    public static int get(int key) {
        if (hm.containsKey(key)) {
            refer(key);
            return hm.get(key);
        }
        return -1;
    }

    public static void put(int key, int value) {
        refer(key);
        hm.put(key, value);
    }
}
