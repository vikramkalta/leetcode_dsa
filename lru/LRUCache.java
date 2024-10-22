import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;

public class LRUCache {
    public static void main(String[] args) {
        // LRUCache lru = new LRUCache(3);
        // lru.put(1, 1);
        // lru.put(2, 2);
        // lru.put(3, 3);
        // System.out.println(lru.get(1));
        // lru.put(4, 4);
        // System.out.println(lru.get(2));
        // System.out.println(lru.get(3));
        // LRUCache lru = new LRUCache(2);
        // lru.put(2, 1);
        // lru.put(2, 2);
        // System.out.println(lru.get(2));
        // lru.put(1, 1);
        // lru.put(4, 1);
        // System.out.println(lru.get(2));
        // LRUCache lru = new LRUCache(2);
        // System.out.println(lru.get(2));
        // lru.put(2, 6);
        // System.out.println(lru.get(1));
        // lru.put(1, 5);
        // lru.put(1, 2);
        // System.out.println(lru.get(1));
        // System.out.println(lru.get(2));
        // [1,1],[2,2],[1],[3,3],[2],[4,4],[1],[3],[4]
        // LRUCache lru = new LRUCache(2);
        // lru.put(1, 1);
        // lru.put(2, 2);
        // System.out.println(lru.get(1));
        // lru.put(3, 3);
        // System.out.println(lru.get(2));
        // lru.put(4, 4);
        // System.out.println(lru.get(1));
        // System.out.println(lru.get(3));
        // System.out.println(lru.get(4));
        // [2],[2,1],[1,1],[2,3],[4,1],[1],[2]
        LRUCache lru = new LRUCache(2);
        lru.put(2, 1);
        lru.put(1, 1);
        lru.put(2, 3);
        lru.put(4, 1);
        System.out.println(lru.get(1));
        System.out.println(lru.get(2));
    }
    static int cap = 0;
    protected static final Deque<Integer> deque = new LinkedList<>();
    protected static final HashMap<Integer, Integer> cacheMap = new HashMap<>();
    // protected static final HashMap<Integer, Deque<Integer>> cacheMap = new HashMap<>();
    public LRUCache(int capacity) {
        cap = capacity;
    }
    public static int get(int key) {
        if (cacheMap.containsKey(key)) {
            deque.remove(key);
            deque.addFirst(key);

            return cacheMap.get(key);
        } else {
            return -1;
        }
    }
    // [2],[2,1],[1,1],[2,3],[4,1],[1],[2]
    public static void put(int key, int value) {
        if (deque.size() < cap) {
            if (cacheMap.containsKey(key)) {
                cacheMap.put(key, value);
                deque.remove(key);
                deque.addFirst(key);
            }else{
                deque.addFirst(key);
                cacheMap.putIfAbsent(key, value);
            }
        } else {
            // Remove the least recently used.
            if (cacheMap.containsKey(key)) {
                cacheMap.put(key, value);
                deque.remove(key);
                deque.addFirst(key);
            }else{
                int x = deque.peekLast();
                deque.removeLast();
                deque.addFirst(key);
                cacheMap.remove(x);
                cacheMap.put(key, value);
            }
        }
    }

    // public static int get(int key) {
    //     if (cacheMap.containsKey(key)) {
    //         deque.remove(key);
    //         deque.addFirst(key);

    //         Deque<Integer> q = cacheMap.get(key);
    //         int x = q.removeLast();
    //         q.addFirst(x);
    //         return x;
    //     } else {
    //         return -1;
    //     }
    // }

    // public static void put(int key, int value) {
    //     if (deque.size() < cap) {
    //         deque.addFirst(key);
    //         Deque<Integer> q = new LinkedList<>();
    //         if (cacheMap.containsKey(key)) {
    //             q = cacheMap.get(key);
    //         }
    //         q.add(value);
    //         cacheMap.putIfAbsent(key, q);
    //     } else {
    //         // Remove the least recently used.
    //         int x = deque.peekLast();

    //         if (cacheMap.containsKey(key)) {
    //             Deque<Integer> innerQ = cacheMap.get(key);
    //             innerQ.removeLast();
    //             innerQ.addFirst(value);
    //             deque.addFirst(key);
    //             deque.removeLast(); // Check
    //             cacheMap.putIfAbsent(key, innerQ);
    //         }else{
    //             Deque<Integer> innerQ = new LinkedList<>();
    //             innerQ.addFirst(value);
    //             deque.removeLast();
    //             cacheMap.remove(x);
    //             deque.addFirst(key);
    //             cacheMap.putIfAbsent(key, innerQ);
    //         }
    //     }
    // }
}
