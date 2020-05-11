package algorithm;

import sun.tools.jstat.Literal;

public class 删除链表的倒数第N个节点 {
    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        build(node,2);
//        while (node != null){
//            System.out.println(node.val);
//            node  = node.next;
//        }

        ListNode node1 =  removeNthFromEnd(node,6);
        while (node1 != null){
            System.out.println(node1.val);
            node1  = node1.next;
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode first = head;
        ListNode second = head;

        //找F的开始点
        for (int i = 0; i <= n; i++) {
            //边界值考虑
            if (first == null){
                return head.next;
            }
            first = first.next;
        }
        //开始处理
        while (second != null) {
            second = second.next;
            second = second.next;
        }
        //删除节点
        second.next = second.next.next;
        return head;
    }
}
