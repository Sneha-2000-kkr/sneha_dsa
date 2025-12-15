package no2_sliding_window.sub_patterns.exactly_K;

import java.util.HashMap;
import java.util.HashSet;


/*
Sliding window directly “exactly K” ke liye kaam nahi karta
Sliding window naturally “at most K” ya “at least K” type problems me strong hota hai
Isliye hum indirect method use karte hain.

 */
public class OG_LC992_subarray_with_K_diff_ints {

    public int subarraysWithKDistinctBruteForce(int[] nums, int k) {
        int n = nums.length;
        int count = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(nums[j]);
                if (set.size() == k) count++;
                if (set.size() > k) break;
            }
        }
        return count;
    }


    public int subarraysWithKDistinctBetterSol(int[] nums, int k) {
        return atMost1(nums, k) - atMost1(nums, k - 1);
    }

    private int atMost1(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int left = 0, res = 0;

        for (int right = 0; right < nums.length; right++) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.size() > k) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) map.remove(nums[left]);
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public int subarraysWithKDistinctOptimisedSol(int[] nums, int k) {
        return atMost2(nums, k) - atMost2(nums, k - 1);
    }

    public int atMost2(int[] nums, int k) {
        int[] freq = new int[nums.length + 1];
        int left = 0, res = 0, distinct = 0;

        for (int right = 0; right < nums.length; right++) {
            if (freq[nums[right]]++ == 0) distinct++;

            while (distinct > k) {
                if (--freq[nums[left]] == 0) distinct--;
                left++;
            }
            res += right - left + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        OG_LC992_subarray_with_K_diff_ints obj = new OG_LC992_subarray_with_K_diff_ints();
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println("Brute Force: "+ obj.subarraysWithKDistinctBruteForce(nums,k));
        System.out.println("Better Sol: "+ obj.subarraysWithKDistinctBetterSol(nums,k));
        System.out.println("Optimised Sol: "+ obj.subarraysWithKDistinctOptimisedSol(nums,k));

    }
}
