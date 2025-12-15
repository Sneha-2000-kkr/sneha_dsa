package no4_binary_search.sub_patterns.first_and_last_occurance;
import java.util.Arrays;

/*
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/
 */
public class OG_LC34_find_first_and_last_position_of_element_in_sorted_array {
    public int findLeft(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                right = mid - 1; // keep searching left half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    // find rightmost index of target (or -1)
    public int findRight(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                left = mid + 1; // keep searching right half
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) return new int[]{-1, -1};
        int leftIdx = findLeft(nums, target);
        if (leftIdx == -1) return new int[]{-1, -1}; // target not present
        int rightIdx = findRight(nums, target);
        return new int[]{leftIdx, rightIdx};
    }

    public static void main(String[] args) {
        OG_LC34_find_first_and_last_position_of_element_in_sorted_array obj = new OG_LC34_find_first_and_last_position_of_element_in_sorted_array();
        int[] nums = {5,7,7,8,8,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(obj.searchRange(nums, target)));

    }
}
