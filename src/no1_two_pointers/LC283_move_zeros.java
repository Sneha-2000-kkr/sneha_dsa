package no1_two_pointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/move-zeroes/description/
 */
public class LC283_move_zeros {

    public void moveZeroApproach1(int[] arr){
        int j=0;

        for(int i=0; i < arr.length; i++){
            if(arr[i]!=0){
                arr[j] = arr[i];
                j++;
            }
        }

        for(int i =j; i< arr.length; i++){
            arr[i] = 0;
        }

    }

    public void moveZeroApproach2(int[] nums){
        int j = 0; // index to place the next non-zero value

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                // Swap nums[i] and nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;

                j++;
            }
        }

    }

    public static void main(String[] args) {
        LC283_move_zeros obj = new LC283_move_zeros();
        int[] arr = {0,1,0,0,0,3,12};
//        obj.moveZeroApproach1(arr);
        obj.moveZeroApproach2(arr);
        System.out.println(Arrays.toString(arr));
    }
}
