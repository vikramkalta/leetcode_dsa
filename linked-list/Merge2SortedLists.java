public class Merge2SortedLists {
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

    public static void main(String[] args) {
        int[] list1 = { 1, 2, 4 };
        int[] list2 = { 1, 3, 4 };
        ListNode l1 = createList(list1);
        ListNode l2 = createList(list2);
        System.out.println(mergeTwoLists(l1, l2));
    }

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode curr1 = list1;
        ListNode curr2 = list2;
        ListNode mergedList = new ListNode(-1);
        ListNode tempMerged = mergedList;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                tempMerged.next = curr1;
                curr1 = curr1.next;
            } else {
                tempMerged.next = curr2;
                curr2 = curr2.next;
            }
            tempMerged = tempMerged.next;
        }
        while (curr1!=null) {
            tempMerged.next = curr1;
            curr1=curr1.next;
            tempMerged=tempMerged.next;
        }
        while (curr2!=null) {
            tempMerged.next=curr2;
            curr2=curr2.next;
            tempMerged=tempMerged.next;
        }
        return mergedList.next;
    }
}