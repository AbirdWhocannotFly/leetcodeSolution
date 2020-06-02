package com.leetcode.solution.daily.han;

/**
 * @Description //求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *  
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *  
 *
 * 限制：
 *
 * 1 <= n <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/qiu-12n-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-06-03 0:02
 * @Param
 * @return
 */
public class Sol64SumNumsHan {

    public int sumNums(int n) {
        // 只能使用加法，但是还不让使用循环语句，意思是要搞位运算了么？
        // 此时只有 逻辑运算符可以使用了，逻辑运算符的短路特性 来控制递归的结束条件

        boolean flag = n > 0 && (n += sumNums(n-1)) > 0;
        return n;


    }

    public static void main(String[] args) {
        System.out.println(new Sol64SumNumsHan().sumNums(9));
    }
}
