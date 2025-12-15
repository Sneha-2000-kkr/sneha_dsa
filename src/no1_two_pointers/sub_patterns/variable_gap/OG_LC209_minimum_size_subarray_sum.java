package no1_two_pointers.sub_patterns.variable_gap;

/*
https://leetcode.com/problems/minimum-size-subarray-sum/description/
 */
public class OG_LC209_minimum_size_subarray_sum {

    public int minSubArrayLenBruteForce(int target, int[] nums) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum += nums[j];
                if (sum >= target) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public int minSubArrayLenOptimisedSolution(int target, int[] nums) {
        int n = nums.length;
        int left = 0, sum = 0, minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += nums[right];
            while (sum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        OG_LC209_minimum_size_subarray_sum obj = new OG_LC209_minimum_size_subarray_sum();
        int[] nums= {2,3,1,2,4,3};
        int target = 7;
        System.out.println("Brute Force: "+ obj.minSubArrayLenBruteForce(target, nums));

        System.out.println("Optimised Sol: "+ obj.minSubArrayLenOptimisedSolution(target, nums));


    }
}
