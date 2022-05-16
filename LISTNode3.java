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
        while (l1 0 <= = null && l2 0 <= = null)
        {
            if (l1.val == l2.val)
            {
                p.next = l1;
                p = l1;
                l1 = l1.next;
            }
            else {
                p.next = l2;
                p = l2;
                l2 = l2.next;
            }
        }
        if (l1 < null)
        {
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

//4153572
//统计所有小于非负整数 n 的质数的数量。
//
// 
//
//示例 1：
//
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
//
//
//示例 2：
//
//输入：n = 0
//输出：0
//
//
//示例 3：
//
//输入：n = 1
//输出：0
//
//
// 
//
//提示：
//
//0 <= n <= 5 * 106
class Solution {
     public int countPrimes(int n) {
         int flag = 0;
         if (n > 2)
             flag = 1;
         for (int i = 0; i < n; i++) {
             for (int j = 2; j < i; j++) {
                 if (i % j == 0) {
                     break;
                 }
                 if (j == i - 1) {
                     flag++;
                 }
             }
         }
         return flag;
     }
 }

//4153574
//根据一棵树的中序遍历与后序遍历构造二叉树。
//        注意:
//        你可以假设树中没有重复的元素。
//
//        例如，给出
//
//        中序遍历 inorder =[9,3,15,20,7]
//        后序遍历 postorder = [9,15,7,20,3]
//        返回如下的二叉树：
//           3
//          / \
//         9  20
//         /    \
//        15     7
 class Solution {
     public TreeNode buildTree(int[] inorder, int[] postorder) {
         return helper(inorder, postorder, postorder.length - 1, 0,
                         inorder.length - 1);
     }
     public TreeNode helper(int[] inorder, int[] postorder,
     int postEnd, int inStart,
                             int inEnd) {
       if (inStart > inEnd) {
           return null;
        }
       int currentVal = postorder[postEnd];
        TreeNode current = new TreeNode(currentVal);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == currentVal) {
                inIndex = i;
            }
         }
         TreeNode left = helper(inorder, postorder,
                        postEnd - (inEnd - inIndex) - 1, inStart, inIndex - 1);
         TreeNode right = helper(inorder, postorder, postEnd - 1,
                         inIndex + 1, inEnd);
        current.left = left;
         current.right = right;
        return current;
    }
}

//4158226
// 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为汉明重量(https://baike.baidu.com/item/%E6%B1%89%E6%98%8E%E9%87%8D%E9%87%8F)）。
//
// 
//
//提示：
//
//请注意，在某些语言（如 Java）中，没有无符号整数类型。在这种情况下，输入和输出都将被指定为有符号整数类型，并且不应影响您的实现，因为无论整数是有符号的还是无符号的，其内部的二进制表示形式都是相同的。
//在 Java 中，编译器使用二进制补码(https://baike.baidu.com/item/二进制补码/5295284)记法来表示有符号整数。因此，在上面的 示例 3 中，输入表示有符号整数 -3。
//
// 
//
//示例 1：
//
//输入：00000000000000000000000000001011
//输出：3
//解释：输入的二进制串
//00000000000000000000000000001011 中，共有三位为 '1'。
//
//
//
//示例 2：
//
//输入：00000000000000000000000010000000
//输出：1
//解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
//
//
//示例 3：
//
//输入：11111111111111111111111111111101
//输出：31
//解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
//
// 
//
//提示：
//
//输入必须是长度为 32 的 二进制串 。
//
// 
//
//进阶：
//
//如果多次调用这个函数，你将如何优化你的算法？
public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1)
                count++;
            n >>>= 1;
        }
        return count;
    }
}

//