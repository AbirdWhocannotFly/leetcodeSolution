package com.leetcode.solution.daily;

/**
 * 面试题46. 把数字翻译成字符串
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
 *
 * @author yangguang14
 * @date 2020/6/9.
 */
public class SolutionInterview46 {

    public int translateNum(int num) {
        //初始化变量记录之前位置的统计数用于动态规划
        int pre = 1;
        int ppre = 1;
        //处理边界
        if (num < 10) {
            return num < 0 ? 0 : pre;
        }
        //将数字转换为字符串遍历
        String numStr = String.valueOf(num);
        int preValue = numStr.charAt(0) - '0';
        for (int i = 1; i < numStr.length(); i++) {
            //计算当前位置组合数(直接统计前一位+1)
            int curr = pre;
            int currValue = numStr.charAt(i) - '0';
            if (  (preValue == 1) || (preValue == 2 &&currValue < 6)) {
                //如果可以和前一位组成i之后的字母
                curr += ppre;
            }
            //变量变更
            ppre = pre;
            pre = curr;
            preValue = currValue;
        }
        return pre;
    }

    public static void main(String[] args) {
        int num = 18580;
        System.out.println(new SolutionInterview46().translateNum(num));
    }
}
