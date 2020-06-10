package com.leetcode.solution.daily.han;

/**
 * @Description 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: 12258
 * 输出: 5
 * 解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"
 *  
 *
 * 提示：
 *
 * 0 <= num < 231
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-06-09 22:24
 * @Param
 * @return
 */
public class Sol46InterviewTranslateNumHan {
    public int translateNum(int num) {
        // 首先挨个解析数字的每一个字符，肯定对应一个字符串
        // 接下来，考虑 两位数的情况是否 在10~25之间，遍历数字对应的字符串，遍历到当前位置是，判断跟前一个字符 组成的两位数是否能解析成字符
        /**
         * num = x1x2...xn;
         * f(i-2) 为 x1x2...xi-2翻译方案树
         * f(i-1) 为x1x2...xi-1的翻译方案数
         *          f(i-2) + f(i-1) xi-1xi 可以合起来被翻译
         * f（i） =
         *          f(i-1)           xi-1xi 不可以被翻译
         *
         *  用动态数组 记录 f(i-2) he f(i-1) 的方案数， 则 f(i) 要们等于 f(i-1) 或者 f(i-1) + f(i-2)
         *
         *
         */
        if (num < 10) {
            return 1;
        }

        int count = 1, pre = 0, curr = 0;

        String str = String.valueOf(num);

        for (int i = 0; i < str.length(); i++) {
            pre  = curr;
            curr = count;

            if (i == 0) {
                continue;
            }

            // 获取当前下标 与前一下标对应的字符，判断能否解析
            String sub = str.substring(i-1,i+1);
            if(sub.compareTo("10") >= 0 && sub.compareTo("25") <= 0){
                count += pre;
            } else {
                count = curr;
            }

        }

        return count;
    }

    public static  void main(String[] args) {
        int a = 12258;
        System.out.println(new Sol46InterviewTranslateNumHan().translateNum(a));
    }

}
