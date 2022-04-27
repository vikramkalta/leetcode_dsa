public class RemoveNthNode {
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

    public static void main(String args[]) {
        // int[] a = {1,2,3,4,5};
        // int[] a = { 1, 2 };
        int[] a = {1};
        // int[] a = { 1, 2, 3 };
        ListNode head = new ListNode(a[0]);
        ListNode temp = head;
        for (int i = 1; i < a.length; i++) {
            temp.next = new ListNode(a[i]);
            temp = temp.next;
        }
        // System.out.println(removeNthFromEnd(head, 2));
        // System.out.println(removeNthFromEnd(head, 2));
        System.out.println(removeNthFromEnd(head, 1));
        // System.out.println(removeNthFromEnd(head, 3));
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            temp = temp.next;
            len++;
        }
        int i = 0;
        temp = head;
        while (i < len) {
            if (i == len - n - 1) {
                temp.next = temp.next.next;
                break;
            } else if (len - n <= 0) {
                head = temp.next;
                break;
            }
            temp = temp.next;
            i++;
        }
        return head;
    }
}
