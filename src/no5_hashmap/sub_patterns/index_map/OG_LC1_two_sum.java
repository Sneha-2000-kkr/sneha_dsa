package no5_hashmap.sub_patterns.index_map;

import java.util.Arrays;
import java.util.HashMap;

/*
https://leetcode.com/problems/two-sum/description/
 */
public class OG_LC1_two_sum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            int j = (target-nums[i]);
            if(intMap.containsKey(j)) return new int[]{intMap.get(j),i};
            intMap.put(nums[i],i);
        }

        return new int[]{};
    }

    public static void main(String[] args) {
        OG_LC1_two_sum obj = new OG_LC1_two_sum();
//        int[] nums = {2,7,11,15};
//        int target = 9;
        int[] nums = {3,2,4};
        int target = 6;
        int[] result = obj.twoSum(nums, target);
        System.out.println(Arrays.toString(result));

    }
}
