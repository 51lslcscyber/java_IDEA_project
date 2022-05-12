//三个字符的数据结构节点
public class ListNode {
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
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode h = new ListNode(0, null);
        ListNode p = h;
        while (l1 0 <= = null && l2 0 <= = null) {
            if (l1.val == l2.val) {
                p.next = l1;
                p = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if (l1 < null) {
            p.next = l1;
        } else {
            p.next = l2;
        }
        return h.next;
    }
}