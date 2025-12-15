package no4_binary_search.sub_patterns.classic_binary_search;

/*
https://leetcode.com/problems/binary-search/description/
 */
public class OG_LC704_binary_search {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left<= right){
            int mid = (left + right)/2;
            if(target == nums[mid]) return mid;
            else if(target > nums[mid]) left=mid+1;
            else right=mid-1;

        }
        return -1;
    }

    public static void main(String[] args) {
        OG_LC704_binary_search obj = new OG_LC704_binary_search();
//        int[] nums = {-1,0,3,5,9,12};
//        int target = 9;
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println("Binary Search: " + obj.search(nums,target));


    }
}
