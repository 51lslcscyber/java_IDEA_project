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

//4180013
//请你来实现一个 myAtoi(string s) 函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
//
//函数 myAtoi(string s) 的算法如下：
//
//读入字符串并丢弃无用的前导空格
//检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
//读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
//将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
//如果整数数超过 32 位有符号整数范围 [−231,  231 − 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −231 的整数应该被固定为 −231 ，大于 231 − 1 的整数应该被固定为 231 − 1 。
//返回整数作为最终结果。
//
//注意：
//
//本题中的空白字符只包括空格字符 ' ' 。
//除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。
//
// 
//
//示例 1：
//
//输入：s = "42"
//输出：42
//解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
//第 1 步："42"（当前没有读入字符，因为没有前导空格）
//^
//第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//^
//第 3 步："42"（读入 "42"）
//^
//解析得到整数 42 。
//由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。
//
//示例 2：
//
//输入：s = "   -42"
//输出：-42
//解释：
//第 1 步："   -42"（读入前导空格，但忽视掉）
//^
//第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
//^
//第 3 步："   -42"（读入 "42"）
//^
//解析得到整数 -42 。
//由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。
//
//
//示例 3：
//
//输入：s = "4193 with words"
//输出：4193
//解释：
//第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
//^
//第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//^
//第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
//^
//解析得到整数 4193 。
//由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。
//
//
//示例 4：
//
//输入：s = "words and 987"
//输出：0
//解释：
//第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
//^
//第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
//^
//第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
//^
//解析得到整数 0 ，因为没有读入任何数字。
//由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。
//
//示例 5：
//
//输入：s = "-91283472332"
//输出：-2147483648
//解释：
//第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
//^
//第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
//^
//第 3 步："-91283472332"（读入 "91283472332"）
//^
//解析得到整数 -91283472332 。
//由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -231 = -2147483648 。
//
// 
//
//提示：
//
//0 <= s.length <= 200
//s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
class Solution {
    public int myAtoi(String s) {
        long y = 0;
        int i = 0;
        boolean w = false;
        boolean sign = false;
        int offset = 0;
        char[] ints = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        while (i < s.length()) {
            char c = s.charAt(i);
            boolean isSign = false;
            if (w == false && c != ' ') {
                w = true;
                if (c == '-') {
                    sign = true;
                    isSign = true;
                }
                if (c == '+') {
                    isSign = true;
                }
            }
            if (w && (!isSign)) {
                int v = Arrays.binarySearch(ints, c);
                if (v < 0) {
                    break;
                }
                y = y * 10 + v;
                if (y > 0x7FFFFFFF) {
                    y = 0x7FFFFFFF;
                    offset = 1;
                    break;
                }
            }
            i++;
        }
        return sign ? -(int) (y + offset) : (int) y;
    }
}

//4197353
//给定一个已按照 非递减顺序排列  的整数数组 numbers ，请你从数组中找出两个数满足相加之和等于目标数 target 。
//
//函数应该以长度为 2 的整数数组的形式返回这两个数的下标值。numbers 的下标 从 1 开始计数 ，所以答案数组应当满足 1 <= answer[0] < answer[1] <= numbers.length 。
//
//你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
//
// 
//
//示例 1：
//
//输入：numbers = [2,7,11,15], target = 9
//输出：[1,2]
//解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
//
//
//示例 2：
//
//输入：numbers = [2,3,4], target = 6
//输出：[1,3]
//
//
//示例 3：
//
//输入：numbers = [-1,0], target = -1
//输出：[1,2]
//
//
// 
//
//提示：
//
//2 <= numbers.length <= 3 * 104
//-1000 <= numbers[i] <= 1000
//numbers 按 非递减顺序 排列
//-1000 <= target <= 1000
//仅存在一个有效答案
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            int t = target - numbers[i];
            answer[0] = i + 1;
            for (int j = i + 1; j < n; j++) {
                if (numbers[j] > t) {
                    break;
                }
                if (numbers[j] == t) {
                    answer[1] = j + 1;
                    break;
                }
            }
            if (answer[1] != 0) {
                break;
            }
        }
        return answer;
    }
}
//4124370
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        left[0] = 1;
        right[len - 1] = 1;
        for (int i = 1; i < len; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            } else {
                left[i] = 1;
            }
        }
        for (int i = len - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            } else {
                right[i] = 1;
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            res += Math.max(left[i], right[i]);
        }
        return res;
    }
}

//4244570
//给定一个整数数组，判断是否存在重复元素。
//
//如果存在一值在数组中出现至少两次，函数返回 true 。如果数组中每个元素都不相同，则返回 false 。
//
// 
//
//示例 1:
//
//输入: [1,2,3,1]
//输出: true
//
//示例 2:
//
//输入: [1,2,3,4]
//输出: false
//
//示例 3:
//
//输入: [1,1,1,3,3,4,3,2,4,2]
//输出: true

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0)
            return false;
        SortedSet<Long> binTree = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            SortedSet<Long> son = binTree.subSet((long) nums[i] - t, (long) nums[i] + t + 1);
            if (!son.isEmpty())
                return true;
            if (i >= k)
                binTree.remove((long) nums[i - k]);
            binTree.add((long) nums[i]);
        }
        return false;
    }
}

//4244572
//给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
//
//如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
//
//假设环境不允许存储 64 位整数（有符号或无符号）。
//
// 
//
//示例 1：
//
//输入：x = 123
//输出：321
//
//示例 2：
//
//输入：x = -123
//输出：-321
//
//示例 3：
//
//输入：x = 120
//输出：21
//
//示例 4：
//
//输入：x = 0
//输出：0
//
// 
//
//提示：
//
//-231 <= x <= 231 - 1
class Solution {
    public int reverse(int x) {
        long xx = x;
        long r;
        long y = 0;
        boolean sign = xx < 0;
        while (xx != 0) {
            r = xx % 10;
            y = y * 10 + r;
            if (sign) {
                xx = (long) Math.ceil(xx / 10);
            } else {
                xx = (long) Math.floor(xx / 10);
            }
        }
        return y > Integer.MAX_VALUE || y < Integer.MIN_VALUE ? 0 : (int) y;
    }
}
//4244573
//从键盘输入5个整型值 1）按从大到小顺序排序方法； 2）计算这些数的平均值的方法； 3）在主方法中调用这些方法，并输出相应的值。
import java.util.*;
class java_7445932 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        for (int a = 1; a < 6; a++) {
            System.out.print("请输入第 " + a + " 个值：");
            list.add(scanner.nextInt());
        }
        System.out.println(descending(list));
        System.out.println(getAvg(list));
    }
    public static List<Integer> descending(List<Integer> list) {
        list.sort(Collections.reverseOrder());
        return list;
    }
    public static Double getAvg(List<Integer> list) {
        return list.stream().mapToInt(Integer::new).average().getAsDouble();
    }
}

//4252343
//给定一个数组 prices ，其中 prices[i] 是一支给定股票第 i 天的价格。
//
//设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
//
//注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
//
// 
//
//示例 1:
//
//输入: prices = [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
//
//
//示例 2:
//
//输入: prices = [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
//
//
//示例 3:
//
//输入: prices = [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
//
// 
//
//提示：
//
//1 <= prices.length <= 3 * 104
//0 <= prices[i] <= 104
class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i] < prices[i + 1]) {
                profit += prices[i + 1] - prices[i];
            }
        }
        return profit;
    }
}

//4270330
//编写一个函数来查找字符串数组中的最长公共前缀。
//
//如果不存在公共前缀，返回空字符串 ""。
//
// 
//
//示例 1：
//
//输入：strs = ["flower","flow","flight"]
//输出："fl"
//
//示例 2：
//
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。
//
// 
//
//提示：
//
//0 <= strs.length <= 200
//0 <= strs[i].length <= 200
//strs[i] 仅由小写英文字母组成
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        int i = 0;
        StringBuilder lcp = new StringBuilder();
        while (true) {
            boolean done = false;
            if (i >= strs[0].length()) {
                break;
            }
            for (int j = 0; j < strs.length; j++) {
                if (i < strs[j].length()) {
                    if (strs[j].charAt(i) != strs[0].charAt(i)) {
                        done = true;
                        break;
                    }
                } else {
                    done = true;
                    break;
                }
            }
            if (done) {
                break;
            } else {
                lcp.append(strs[0].charAt(i));
                i++;
            }
        }
        return lcp.toString();
    }
}