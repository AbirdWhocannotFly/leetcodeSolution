package com.leetcode.solution.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Z 字形变换
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * @author yangguang14
 * @date 2020/6/4.
 */
public class ConvertZ {

    public String convert(String s, int numRows) {
        //处理边界
        if (numRows == 1){
            return s;
        }
        List<StringBuilder> stringBuilders = new ArrayList<>(numRows);
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }
        //计算在哪行
        int index = 0;
        //计算变向时机
        int count = 0;
        //控制方向
        int direct = 1;
        for (int i = 0; i < s.length(); i++) {
            StringBuilder sb = stringBuilders.get(index);
            sb.append(s.charAt(i));
            //如果到头了就转向
            if (count == numRows - 1) {
                count = 0;
                direct *= -1;
            }

            count++;
            index += direct;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) {
            sb.append(stringBuilder);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        int rows = 1;
        System.out.println(new ConvertZ().convert(s, rows));
    }
}
