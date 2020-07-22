package site.zhguixin.algo.sort;

import site.zhguixin.algo.linklist.LinkNode;

// 单链表排序, 利用快排的思想
public class ListSort {

    public void sort(LinkNode head) {

    }

    private LinkNode partition(LinkNode head, LinkNode end) {
        LinkNode p1 = head, p2 = head;

        int pivot = head.val;
        while (p2 != null) {
            if (pivot > p2.val) {
                p1 = p1.next;
                exchange(p1, p2);
            }
            p2 = p2.next;
        }

        if (p1 != head) {
            exchange(p1, head);
        }
        return p1;
    }

    private void exchange(LinkNode node1, LinkNode node2) {
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }
}
