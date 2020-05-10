package com.leetcode.solution.daily;

/**
 * 最低票价
 * https://leetcode-cn.com/problems/minimum-cost-for-tickets/
 *
 * @author yangguang14
 * @date 2020/5/10.
 */
public class Solution983 {

    /**
     * @param days
     * @param costs
     * @return
     */
    public int mincostTickets(int[] days, int[] costs) {

        if (days.length == 0) {
            return 0;
        }
        //dp数组保存如果当天没有持有票，则购票最优解
        int[] dp = new int[366];
        //最后一天出游最优解选最小票价
        dp[days[days.length - 1]] = Math.min(costs[0], Math.min(costs[1], costs[2]));

        for (int i = days.length - 2; i >= 0; i--) {
            //给间隔赋值
            for (int j = days[i] + 1; j < days[i + 1]; j++) {
                dp[j] = dp[days[i + 1]];
            }
            //买当天
            int cost0 = costs[0] + ((days[i] + 1) >= dp.length ? 0 : dp[days[i] + 1]);
            //买七天
            int cost1 = costs[1] + ((days[i] + 7) >= dp.length ? 0 : dp[days[i] + 7]);
            //买三十天
            int cost2 = costs[2] + ((days[i] + 30) >= dp.length ? 0 : dp[days[i] + 30]);
            //记录最优解
            dp[days[i]] = Math.min(cost0, Math.min(cost1, cost2));
        }

        return dp[days[0]];
    }

    public static void main(String[] args) {
        int[] days = new int[]{6,9,10,14,15,16,17,18,20,22,23,24,29,30,31,33,35,37,38,40,41,46,47,51,54,57,59,65,70,76,77,81,85,87,90,91,93,94,95,97,98,100,103,104,105,106,107,111,112,113,114,116,117,118,120,124,128,129,135,137,139,145,146,151,152,153,157,165,166,173,174,179,181,182,185,187,188,190,191,192,195,196,204,205,206,208,210,214,218,219,221,225,229,231,233,235,239,240,245,247,249,251,252,258,261,263,268,270,273,274,275,276,280,283,285,286,288,289,290,291,292,293,296,298,299,301,303,307,313,314,319,323,325,327,329,334,339,340,341,342,344,346,349,352,354,355,356,357,358,359,363,364};
        int[] costs = new int[]{21, 115, 345};
        System.out.println(new Solution983().mincostTickets(days, costs));
    }
}
