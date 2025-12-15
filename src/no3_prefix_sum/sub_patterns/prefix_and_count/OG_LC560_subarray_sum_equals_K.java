package no3_prefix_sum.sub_patterns.prefix_and_count;

import java.util.HashMap;

/*
https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class OG_LC560_subarray_sum_equals_K {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // empty prefix
        int sum = 0;
        int count = 0;

        for (int num : nums) {
            sum += num;
            // how many prior prefixes have value (sum - k)
            count += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        OG_LC560_subarray_sum_equals_K obj = new OG_LC560_subarray_sum_equals_K();
        int[] nums ={1,1,1};
        int k = 2;
//        int[] nums = {1,2,3};
//        int k = 3;
        System.out.println(obj.subarraySum(nums,k));
    }
}
