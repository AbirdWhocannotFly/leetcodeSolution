package com.leetcode.solution.daily.han;

/**
 * @Description 你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。
 *
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，一夜之内能够偷窃到的最高金额。
 *
 * 示例 1:
 *
 * 输入: [1,2,3,1]
 * 输出: 4
 * 解释: 偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 *      偷窃到的最高金额 = 1 + 3 = 4 。
 * 示例 2:
 *
 * 输入: [2,7,9,3,1]
 * 输出: 12
 * 解释: 偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
 *      偷窃到的最高金额 = 2 + 9 + 1 = 12 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/house-robber
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-31 22:33
 * @Param
 * @return
 */
public class Sol198RobHan {
    // 等价判断 数组 奇数项 之后 和偶数项之后 的大小 X 错误的思路

    /**
     * 动态规划， 如果房间数大于2， 对于第k个房间，有两个选项
     * 1，偷窃k这个房子，那么 就不能偷窃k-1这个房子，总金额为 前k-2个房子的最大金额 + k房间的金额
     * 2，不偷k这个房子， 那么 总额为 前k-1个房子的 最高金额
     *
     * 在以上两个选项中， 选择金额最大的那个，此值为前k个房间能偷到的最高金额
     * 对应的状态转移方程为：dp[i] 为前i个房子能偷取的最高金额
     * dp[i] = Max(dp[i-2] + num[i], dp[i-1]);
     *
     * 边界条件：
     * dp[0] = num[0]   --只有一间房
     * dp[1] = max(num[0],mun[1]) --只有两间房，选择金额最高的那个
     *
     * 最终答案 即为dp[n-1] n为数组长度
      */


    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int len = nums.length;

        if (len == 1) {
            return nums[0];
        }

        int[] dp =  new int[len];

        dp[0] = nums[0];

        dp[1] = Math.max(nums[0],nums[1]);

        // 此处采用了数组存储结果值， 可以优化为 只存 前两间房屋的最高值，第k个房间的结果 只与前两个房间的结果值有关
        int first = nums[0];
        int second = Math.max(nums[0],nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);

            int temp = second;

            second = Math.max(first+ nums[i], second);
            first = temp;
        }

//        return dp[len - 1] ;
        return second ;
    }


}
