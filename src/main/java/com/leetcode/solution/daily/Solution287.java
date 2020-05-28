package com.leetcode.solution.daily;

/**
 * 寻找重复数
 * https://leetcode-cn.com/problems/find-the-duplicate-number/
 *
 * @author yangguang14
 * @date 2020/5/26.
 */
public class Solution287 {
    /**
     * 我们定义 cnt[i] 表示 nums[] 数组中小于等于 i 的数有多少个，
     * 假设我们重复的数是target，那么 [1,target−1]里的所有数满足 cnt[i]≤i，[target,n] 里的所有数满足 cnt[i]>i，具有单调性
     * 第二种解法：二进制统计每位的1，如果当前位的1多于1-n的，则当前1需要进行还原计算
     * 第三种解法：双指针...
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int n = nums.length;
        int l = 1, r = n - 1, ans = -1;
        while (l <= r) {
            //即使找到统计数>当前值的也不结束
            //直到找到l,r相等才能确认最小符合值，即所求结果
            int mid = (l + r) >> 1;
            int cnt = 0;
            //遍历一遍，统计小于当前值的数
            for (int i = 0; i < n; ++i) {
                if (nums[i] <= mid) {
                    cnt++;
                }
            }
            //如果统计数比值小，说明均未重复。更新左边界
            if (cnt <= mid) {
                l = mid + 1;
            } else {
                //否则更新右边界，并更新当前结果
                r = mid - 1;
                ans = mid;
            }
        }
        return ans;

    }
}
