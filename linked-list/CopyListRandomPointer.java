import java.util.HashMap;

public class CopyListRandomPointer {
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public static Node createList(int[] list) {
        int i = 0;
        Node head = new Node(list[i]);
        Node temp = head;
        i++;
        while (i < list.length) {
            temp.next = new Node(list[i]);
            temp = temp.next;
            i++;
        }
        return head;
    }

    public static void main(String[] args) {
        // Node head = new Node(1);
        // head.next = new Node(2);
        // head.next.random = head.next;
        Node first = new Node(7);
        Node second = new Node(13);
        Node third = new Node(11);
        Node fourth = new Node(10);
        Node fifth = new Node(1);

        Node head = first;
        head.random = null;

        head.next = second;
        head = head.next;
        head.random = first;

        head.next = third;
        head = head.next;
        head.random = fifth;

        head.next = fourth;
        head = head.next;
        head.random = first;

        head.next = fifth;
        head = head.next;
        head.random = first;

        copyRandomList(first);
    }

    public static Node copyRandomList(Node head) {
        Node copiedNode = new Node(-1);
        Node tempCopiedNode = copiedNode;
        Node temp = head;
        HashMap<Node, Node> nodeMap = new HashMap<>();
        while (temp != null) {
            tempCopiedNode.next = new Node(temp.val);

            // Old node->new node map.
            nodeMap.put(temp, tempCopiedNode.next);

            tempCopiedNode = tempCopiedNode.next;
            temp = temp.next;
        }

        tempCopiedNode = copiedNode.next;
        temp = head;

        while (temp != null) {
            tempCopiedNode.random = nodeMap.get(temp.random);
            temp = temp.next;
            tempCopiedNode = tempCopiedNode.next;
        }
        return copiedNode.next;
    }
}
