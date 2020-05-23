package com.leetcode.solution.daily.han;

/**
 * @Description Given a 32-bit signed integer, reverse digits of an integer.
 *
 * Example 1:
 *
 * Input: 123
 * Output: 321
 * Example 2:
 *
 * Input: -123
 * Output: -321
 * Example 3:
 *
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-integer
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-23 23:37
 * @Param
 * @return
 */
public class Sol7ReverseIntegerHan {
    public int reverse1(int x) {
        // 对x取模 得到最小位上的数，然后将x除以10，再取模 一次得到x的个十百千...位上的数字

        // 用long类型的数 接收，最后 强制类型装换为int  如果 装换后 的数，不等于转换前， 表示 int类型溢出
        long res = 0;

        while (x != 0) {
            res = res*10 + x%10;
            x/=10;
        }


        return (int)res == res ? (int)res : 0;
    }

    public int reverse2(int x) {
        // 对x取模 得到最小位上的数，然后将x除以10，再取模 一次得到x的个十百千...位上的数字

        int res = 0;

        while (x != 0) {
            int pop = x % 10;
            /**
             * 判断 是否溢出
             * tem = res*10 + pop； res*10 > Integer.MAX_VALUE, 转换后肯定溢出
             * 如果 res*10 == Integer.MAX_VALUE 且 pop > 7, 转换后溢出
             * 针对负数情况 另做判断，pop < -8, 溢出
             */
            if (res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && pop > 7)) {
                return 0;
            }

            if (res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && pop < -8)) {
                return 0;
            }

            res = res*10 + pop;
            x /= 10;
        }


        return res;
    }

    public int reverse3(int x) {
        // 对x取模 得到最小位上的数，然后将x除以10，再取模 一次得到x的个十百千...位上的数字


        // 先判断 x的正负
        int neg =  x < 0 ? -1 : 1;
        // 将x转换为正数
        x *= neg;

        int res = 0;
        while (x > 0) {
            int tem = res;
            tem = tem * 10 + x % 10;

            /**
             * 判断 是否溢出
             * tem / 10 肯定等于 res 如果不等，则溢出
             *
             */
            if (tem / 10 != res) {
                return 0;
            }

            res = tem;
            x /= 10;
        }


        return res * neg;
    }

    public static void main(String[] args) {
        System.out.println(new Sol7ReverseIntegerHan().reverse3(-123));
    }
}
