package site.zhguixin.algo.linklist;

// 合并两个有序链表
public class MergeSortedList {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        MergeSortedList mergeSortedList = new MergeSortedList();
        LinkNode head1 = new LinkNode(1);
        LinkNode node11 = new LinkNode(2);
        LinkNode node12 = new LinkNode(3);
        head1.next = node11; node11.next = node12;

        LinkNode head2 = new LinkNode(2);
        LinkNode node21 = new LinkNode(4);
        LinkNode node22 = new LinkNode(5);
        head2.next = node21; node21.next = node22;
        LinkNode head = mergeSortedList.iterator(head1, head2);
        for (LinkNode temp = head; temp != null; temp = temp.next) {
            System.out.println("val=" + temp.val);
        }
    }

    public LinkNode merge(LinkNode head1, LinkNode head2) {
        return trverase(head1, head2);
    }

    private LinkNode trverase(LinkNode node1, LinkNode node2) {
        // 递归出口
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        // node2上的结点小, 在node2链表上继续递归
        if (node1.val > node2.val) {
            node2.next = trverase(node1, node2.next);
            return node2;
        } else {
            node1.next = trverase(node1.next, node2);
            return node1;
        }
    }

    private LinkNode iterator(LinkNode node1, LinkNode node2) {
        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        // 创造一个假的temp结点, 作为合并后的链表头结点
        LinkNode tempHead = new LinkNode(Integer.MAX_VALUE);
        // !!注意, 生命一个在各个链表中游走的node结点
        LinkNode pNode = tempHead;
        LinkNode tempNode1 = node1, tempNode2 = node2;
        while (tempNode1 != null && tempNode2 != null) {
            if (tempNode1.val > tempNode2.val) {
                pNode.next = tempNode2;
                tempNode2 = tempNode2.next;
            } else {
                pNode.next = tempNode1;
                tempNode1 = tempNode1.next;
            }
            // !! 游走的node结点向后移动
            pNode = pNode.next;
        }

        if (tempNode1 != null) {
            pNode.next = tempNode1;
        }

        if (tempNode2 != null) {
            pNode.next = tempNode2;
        }


        return tempHead.next;
    }
}
