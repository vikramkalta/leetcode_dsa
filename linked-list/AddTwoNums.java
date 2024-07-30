public class AddTwoNums {
    static class ListNode {
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
        // int[] list1 = { 2, 4, 3 };
        // int[] list2 = { 5, 6, 4 };
        int[] list1 = { 9, 9, 9, 9, 9, 9, 9 };
        int[] list2 = { 9, 9, 9, 9 };
        ListNode l1 = createList(list1);
        ListNode l2 = createList(list2);
        ListNode x = addTwoNumbers(l1, l2);
        System.out.println(x);
    }

    public static ListNode createList(int[] list) {
        int i = 0;
        ListNode head = new ListNode(list[i]);
        ListNode temp = head;
        i++;
        while (i < list.length) {
            temp.next = new ListNode(list[i]);
            temp = temp.next;
            i++;
        }
        return head;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ans = null;
        ListNode ansTemp = null;
        boolean remainder = false;
        while (l1 != null && l2 != null) {
            int x = l1.val + l2.val;
            if (remainder) {
                x++;
                remainder = false;
            }

            if (x >= 10) {
                remainder = true;
            }
            x = x % 10;
            if (ans == null) {
                ansTemp = new ListNode(x);
                ans = ansTemp;
            } else {
                ansTemp.next = new ListNode(x);
                ansTemp = ansTemp.next;
            }

            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int x = l1.val;
            if (remainder) {
                x++;
                remainder = false;
            }

            if (x >= 10) {
                remainder = true;
            }
            x = x % 10;
            ansTemp.next = new ListNode(x);
            ansTemp = ansTemp.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            int x = l2.val;
            if (remainder) {
                x++;
                remainder = false;
            }

            if (x >= 10) {
                remainder = true;
            }
            x = x % 10;
            ansTemp.next = new ListNode(x);
            ansTemp = ansTemp.next;
            l2 = l2.next;
        }
        if (remainder) {
            ansTemp.next = new ListNode(1);
        }
        return ans;
    }

    public static ListNode reverseList(ListNode l1) {
        ListNode curr = l1;
        ListNode prev = null;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
