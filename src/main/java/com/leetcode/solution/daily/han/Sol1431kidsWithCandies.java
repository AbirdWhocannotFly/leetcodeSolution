package com.leetcode.solution.daily.han;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description Given the array candies and the integer extraCandies, where candies[i] represents the number of candies that the ith kid has.
 *
 * For each kid check if there is a way to distribute extraCandies among the kids such that he or she can have the greatest number of candies among them. Notice that multiple kids can have the greatest number of candies.
 *
 *  
 *
 * Example 1:
 *
 * Input: candies = [2,3,5,1,3], extraCandies = 3
 * Output: [true,true,true,false,true]
 * Explanation:
 * Kid 1 has 2 candies and if he or she receives all extra candies (3) will have 5 candies --- the greatest number of candies among the kids.
 * Kid 2 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Kid 3 has 5 candies and this is already the greatest number of candies among the kids.
 * Kid 4 has 1 candy and even if he or she receives all extra candies will only have 4 candies.
 * Kid 5 has 3 candies and if he or she receives at least 2 extra candies will have the greatest number of candies among the kids.
 * Example 2:
 *
 * Input: candies = [4,2,1,1,2], extraCandies = 1
 * Output: [true,false,false,false,false]
 * Explanation: There is only 1 extra candy, therefore only kid 1 will have the greatest number of candies among the kids regardless of who takes the extra candy.
 * Example 3:
 *
 * Input: candies = [12,1,12], extraCandies = 10
 * Output: [true,false,true]
 *  
 *
 * Constraints:
 *
 * 2 <= candies.length <= 100
 * 1 <= candies[i] <= 100
 * 1 <= extraCandies <= 50
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Author Broccoli
 * @Date 2020-06-01 22:15
 * @Param
 * @return
 */
public class Sol1431kidsWithCandies {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
       // 枚举 candies 获得最大值，然后再枚举 candies + extraCandies 如果 加上额外的糖果后，大于枚举出来的最大值，则满足条件
        int len = candies.length;
        int maxCandies = 0;

        // 枚举candies 获取小朋友手中拥有最大的糖果数
        for (int c : candies) {
            maxCandies = Math.max(maxCandies, c);
        }

        // 枚举 candies 判断加上extraCandies后是否大于 maxCandies；
        List<Boolean> res  = new ArrayList<>(len);

        for (int i = 0; i < len; i++) {
            res.add(candies[i] + extraCandies >= maxCandies);
        }

        return res;
    }

}
