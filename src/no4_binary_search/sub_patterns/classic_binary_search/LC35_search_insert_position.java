package no4_binary_search.sub_patterns.classic_binary_search;

/*
https://leetcode.com/problems/search-insert-position/description/
 */
public class LC35_search_insert_position {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left< right){
            int mid = (left + right)/2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) left=mid+1;
            else right=mid-1;

        }
        return left;

    }

    public static void main(String[] args) {
        LC35_search_insert_position obj = new LC35_search_insert_position();
        int[] nums = {1,3,5,6};
//        int target = 7;
//        int target = 5;
        int target = 2;
        System.out.println(obj.searchInsert(nums, target));



    }
}
