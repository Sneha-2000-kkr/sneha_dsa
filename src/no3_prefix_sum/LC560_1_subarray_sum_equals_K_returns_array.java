package no3_prefix_sum;

import java.util.*;

/*
https://leetcode.com/problems/subarray-sum-equals-k/description/
 */
public class LC560_1_subarray_sum_equals_K_returns_array {
    public List<int[]> subarraySumAll(int[] nums, int k) {
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();

        int sum = 0;
        // prefix sum 0 occurs at index -1 (means start from 0)
        map.put(0, new ArrayList<>(Arrays.asList(-1)));

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            int need = sum - k;
            if (map.containsKey(need)) {
                // for every start index j where prefixSum(j) == need
                for (int startIndex : map.get(need)) {
                    // subarray is from startIndex+1 to i (inclusive)
                    int from = startIndex + 1;
                    int to = i + 1; // exclusive for Arrays.copyOfRange
                    int[] sub = Arrays.copyOfRange(nums, from, to);
                    result.add(sub);
                }
            }

            // add current prefix sum index
            map.computeIfAbsent(sum, x -> new ArrayList<>()).add(i);
        }

        return result;
    }

    public static void main(String[] args) {
        LC560_1_subarray_sum_equals_K_returns_array obj = new LC560_1_subarray_sum_equals_K_returns_array();
        int[] nums ={1,1,1};
        int k = 2;
//        int[] nums = {1,2,3};
//        int k = 3;
//        List<int[]> res = obj.subarraySumAll(nums, k);
        // subarraySumAll() → List<int[]> return karta hai
        // .toArray() → usko Object[] me convert karta hai
        // Arrays.deepToString() → nested int[] ko actual arrays jaise print karega
        System.out.println(Arrays.deepToString(obj.subarraySumAll(nums, k).toArray()));
//        System.out.println(res); this will not work instead will give output as [[I@5b480cf9, [I@6f496d9f]
//        for (int[] arr : res) {
//            System.out.println(Arrays.toString(arr));
//        }
    }
}
