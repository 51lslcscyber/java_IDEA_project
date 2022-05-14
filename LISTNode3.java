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


//4141943
//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
//
// 
//
//示例 1:
//
//输入: s = "abcabcbb"
//输出: 3
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
//
//示例 2:
//
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
//
//示例 3:
//
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。 
//请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
//
//示例 4:
//
//输入: s = ""
//输出: 0
//
// 
//
//提示：
//
//0 <= s.length <= 5 * 104
//s 由英文字母、数字、符号和空格组成
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int m = 0;
        Map<Integer, Integer> hset = new HashMap<>();
        for (; j < s.length(); j++) {
            int code = s.codePointAt(j);
            Integer o = hset.get(code);
            if (o != null && o > i) {
                i = o;
            }
            m = m > j - i + 1 ? m : j - i + 1;
            hset.put(code, j + 1);
        }
        return m;
    }
}