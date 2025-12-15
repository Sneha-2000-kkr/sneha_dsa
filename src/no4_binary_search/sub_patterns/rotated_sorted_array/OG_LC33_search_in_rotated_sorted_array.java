package no4_binary_search.sub_patterns.rotated_sorted_array;

public class OG_LC33_search_in_rotated_sorted_array {
    public int searchBruteForce(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) return i;
        }
        return -1;
    }

    public int searchOptimisedSearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) return mid;

            // left part sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid])
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            // right part sorted
            else {
                if (target > nums[mid] && target <= nums[right])
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        OG_LC33_search_in_rotated_sorted_array obj = new OG_LC33_search_in_rotated_sorted_array();
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println("Brute Force: " + obj.searchBruteForce(nums,target));
        System.out.println("Optimised Sol: " + obj.searchOptimisedSearch(nums,target));

    }
}
