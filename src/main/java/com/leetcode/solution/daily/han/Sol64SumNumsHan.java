package com.leetcode.solution.daily.han;

import com.leetcode.solution.daily.han.entity.Person;

import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
//        System.out.println(new Sol64SumNumsHan().sumNums(9));

//        List<Person> personList = new ArrayList<>();
//        personList.add(new Person("a","10101"));
//        personList.add(new Person("b","10102"));
//        personList.add(new Person("c","10103"));
//        System.out.println(personList.stream().toString());

        String  reg = "^(([0]+\\.[0-9]*[1-9][0-9]*)|([1-9]*[1-9][0-9]*\\.[0-9]+)|([1-9]*[1-9][0-9]*))$";
        Pattern p=Pattern.compile(reg);
         Matcher m = p.matcher("0.1");
        Matcher m1 = p.matcher("0");
        Matcher m2 = p.matcher("001");
        Matcher m3 = p.matcher("1044.8");

        System.out.println(m.find());
        System.out.println(m1.find());
        System.out.println(m2.find());
        System.out.println(m3.find());

//        String s = "2020/07/02";
//        String s1 = "2020-07-02";
//        String s2 = "2020-07-04";
//        System.out.println(s2 + "相对于" + s+ "的结果为：" +s2.compareTo(s));
//        System.out.println(s2 + "相对于" + s1 + "的结果为：" + s2.compareTo(s1));
    }
}
