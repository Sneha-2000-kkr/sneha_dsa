package no1_two_pointers.sub_patterns.opposite_ends;


import java.util.Arrays;

/*
https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
*/
public class OG_LC167_two_sum_with_sorted_array {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                return new int[] {left + 1, right + 1}; // 1-based indices
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return new int[]{0,0};
    }

    public static void main(String[] args) {
        OG_LC167_two_sum_with_sorted_array obj = new OG_LC167_two_sum_with_sorted_array();
//        test case 1
//        int[] inputArray = {2,7,11,15};
//        int target = 9;
//        test case 2
//        int[] inputArray = {2,3,4};
//        int target = 6;
//        test case 3
        int[] inputArray = {-1,0};
        int target = -1;
        int[] result = obj.twoSum(inputArray, target);
        System.out.println(Arrays.toString(result));
    }
}
