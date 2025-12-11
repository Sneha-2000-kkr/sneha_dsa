package no1_two_pointers;

/*
https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
*/
public class LC26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int j =0; j < nums.length; j++){
           if(nums[i]!=nums[j]){
               i++;
               nums[i]=nums[j];
           }
        }

        return i+1;
    }


    public static void main(String[] args) {
        LC26_remove_duplicates_from_sorted_array obj = new LC26_remove_duplicates_from_sorted_array();
        int[] inputArray = {0,0,1,1,1,2,2,3,3,4};
        int result = obj.removeDuplicates(inputArray);
        System.out.println(result);


    }
}
