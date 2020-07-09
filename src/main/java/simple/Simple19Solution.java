package simple;

import domain.ListNode;

/**
 * @author zengxiaofeng
 * @since
 */
public class Simple19Solution {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);

        node.next = new ListNode(2);

        node.next.next = new ListNode(3);

        node.next.next.next = new ListNode(4);

        node.next.next.next.next = new ListNode(5);

        node.next.next.next.next.next = new ListNode(6);

        node.next.next.next.next.next.next = new ListNode(7);

        node.next.next.next.next.next.next.next = new ListNode(8);

        node.next.next.next.next.next.next.next.next = new ListNode(9);
        ListNode newNode = removeNthFromEnd2(node, 1);
        System.out.println(newNode);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 1;
        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
            length++;
        }
        int curIndex = 0;
        int targetIndex = length - n;
        cur = head;
        while (cur.next != null) {
            if(targetIndex==0){
                head = head.next;
                break;
            }

            if (curIndex+1 == targetIndex) {
                cur.next = cur.next.next;
                break;
            }
            cur = cur.next;
            curIndex++;
        }

        return head;

    }

    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        ListNode pre = head;
        ListNode cur = head;


        for (int i = 0; i < n; i++) {
            pre = pre.next;
        }

        if (pre == null) {
            return head.next;
        }

        while (pre.next != null) {
            pre = pre.next;
            cur = cur.next;
        }

        if (cur.next == pre) {
            cur.next = null;
            return head;
        }

        cur.next = cur.next.next;
        return head;

    }
}
