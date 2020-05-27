package com.leetcode.solution.daily.han;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description Given an array A of integers, return the number of (contiguous, non-empty) subarrays that have a sum divisible by K.
 *
 *  
 *
 * Example 1:
 *
 * Input: A = [4,5,0,-2,-3,1], K = 5
 * Output: 7
 * Explanation: There are 7 subarrays with a sum divisible by K = 5:
 * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
 *  
 *
 * Note:
 *
 * 1 <= A.length <= 30000
 * -10000 <= A[i] <= 10000
 * 2 <= K <= 10000
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/subarray-sums-divisible-by-k
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-05-27 22:51
 * @Param
 * @return
 */
public class Sol974SbuArrayDivisibledByKHan {

    // 方法一 暴力解法，遍历数组，统计 满足情况的数组出现的情况
    // 时间复杂度O(n^3)  双重循环是O(n^2)  累加数组和 是O(n)，空间复杂度是O(1)
    public int subArraysDivisibleByK1(int[] A, int K) {
        // 遍历数组 A 统计子序列和
        // 考虑以下标i为结尾，遍历i之前的数，依次相加
        int count = 0;
        int len = A.length;
        for (int begain = 0; begain < len; begain++) {
             int sum = 0;
            for (int end = begain; end >=0; end--) {
                sum += A[end];
                if (sum % K == 0) {
                    count++;
                }
            }

        }

        return count;
    }

    // 方法二  暴力解法优化 遍历+前缀和

    /**
     * P[i]=A[0]+A[1]+...+A[i]
     * sum（i,j） = P[j] -p[i-1];
     * 判断子数组和能否被整除 sum(i,j) % k == 0
     * 等价 判断 P[j] - P[i-1] & k == 0
     * 依据同余定理 等价判断  p[j] % k == p[i-1] % k
     * 建立 一个哈希表 key--P[j]%k， value -- 没有重复就是1，后续P[j+i]%k == P[j]%k 对应 key的value++
     *
     * 初始化 map 时 给一个 （0,1）；
     *
     * 同时 后续 前缀和 对k取模时 出现负数 应该将值转化为正数  (p[j]%k + k)%k
     *
     *
     *
     */
    public int subArraysDivisibleByK2(int[] A, int K) {
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        int count = 0;
        int preSum = 0;
        for (int a : A) {
            preSum += a;

            int temp = (preSum % K + K) % K;

            if (map.containsKey(temp)) {
                int same = map.get(temp);
                count += same;
                map.put(temp,same +1);
            } else {
                map.put(temp,1);
            }
//
//            int same = map.getOrDefault(temp,0);
//            count += same;
//            map.put(temp,same + 1);

        }

        return count;

    }



    public  static void main(String[] args){
        int[] A = new int[]{4,5,0,-2,-3,1};
        int k = 5;

        System.out.println(new Sol974SbuArrayDivisibledByKHan().subArraysDivisibleByK2(A,k));
    }

}
