public class RemoveNthNode2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3, 4, 5 };
        int[] arr = { 1, 2 };
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        // System.out.println(removeNthFromEnd(head, 2));
        System.out.println(removeNthFromEnd(head, 1));
    }

    // {1,2,3,4,5,6,7}
    // 2
    // 1st iteration = f = 1,
    // 2nd iteration = f = 2,
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        if (fast==null) {
            return head.next;
        }
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}