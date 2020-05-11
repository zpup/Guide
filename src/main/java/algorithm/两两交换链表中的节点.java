package algorithm;

public class 两两交换链表中的节点 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        build(node, 2);
//        while (node != null) {
//            System.out.print(node.val + " ");
//            node = node.next;
//        }
        ListNode swapNode  = swapPairs(node);

        while (swapNode != null) {
            System.out.print(swapNode.val + " ");
            swapNode = swapNode.next;
        }
    }

    public static void build(ListNode node, int val) {
        if (val < 7) {
            ListNode newNode = new ListNode(val);//创建新的结点
            newNode.next = null;
            node.next = newNode;
            build(newNode, ++val);

        }
    }

    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        //获取需要交换的节点。
        ListNode first = head;
        ListNode second = head.next;
        //设置交换后的next指向
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }
}
