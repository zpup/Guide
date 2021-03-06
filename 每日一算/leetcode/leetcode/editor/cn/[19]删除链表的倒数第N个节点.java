//给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。 
//
// 示例： 
//
// 给定一个链表: 1->2->3->4->5, 和 n = 2.
//
//当删除了倒数第二个节点后，链表变为 1->2->3->5.
// 
//
// 说明： 
//
// 给定的 n 保证是有效的。 
//
// 进阶： 
//
// 你能尝试使用一趟扫描实现吗？ 
// Related Topics 链表 双指针


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {


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
//leetcode submit region end(Prohibit modification and deletion)
