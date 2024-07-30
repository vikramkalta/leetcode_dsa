public class DetectCycle {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        int[] list = { 3, 2, 0, -4 };
        int i = 0;
        ListNode head = new ListNode(list[i]);
        ListNode temp = head;
        i++;
        ListNode cycleStart = new ListNode(-1);
        while (i < list.length) {
            temp.next = new ListNode(list[i]);
            if (list[i] == 2) {
                cycleStart = temp.next;
            }
            temp = temp.next;
            i++;
        }
        temp.next = cycleStart;
        System.out.println(hasCycle(head));
    }

    public static boolean hasCycle(ListNode head) {
        ListNode temp = head;
        ListNode hare = head;
        while (temp.next != null) {
            temp = temp.next;
            hare = hare.next.next;
            if (temp == hare) {
                return true;
            }
        }
        return false;
    }
}
