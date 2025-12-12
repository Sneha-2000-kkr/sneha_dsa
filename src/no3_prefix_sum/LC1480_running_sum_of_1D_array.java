package no3_prefix_sum;

import java.util.Arrays;

/*
https://leetcode.com/problems/running-sum-of-1d-array/description/
 */
public class LC1480_running_sum_of_1D_array {

    public int[] runningSum(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result,0);
        result[0]=nums[0];
        for(int i=1; i<nums.length;i++){
            result[i] = result[i-1]+nums[i];
        }
    return result;
    }

    public static void main(String[] args) {
        LC1480_running_sum_of_1D_array obj = new LC1480_running_sum_of_1D_array();
        int[] nums = {1,2,3,4};
//        int[] nums = {1,1,1,1,1};
//        int[] nums = {3,1,2,10,1};
        System.out.println(Arrays.toString(obj.runningSum(nums)));
    }
}
