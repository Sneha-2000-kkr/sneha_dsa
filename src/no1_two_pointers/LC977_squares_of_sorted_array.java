package no1_two_pointers;

import java.util.Arrays;

/*
https://leetcode.com/problems/squares-of-a-sorted-array/description/
 */
public class LC977_squares_of_sorted_array {

    public int[] sortedSquares(int[] arr) {
        int l = 0;
        int r = arr.length-1 ;
        int[] result = new int[arr.length];
        Arrays.fill(result, 0);
        int index = result.length - 1;

        while(l<=r){
            int leftSquared = (int)Math.pow(arr[l],2);
            int rightSquared = (int)Math.pow(arr[r],2);

            if(leftSquared < rightSquared){
                result[index] = rightSquared;
                r--;
            }
            else{
                result[index] = leftSquared;
                l++;
            }

            index--;

        }

        return result;


    }



    public static void main(String[] args) {
        LC977_squares_of_sorted_array obj = new LC977_squares_of_sorted_array();
//        test case 1
//        int[] arr = {-4,-1,0,3,10};
//        test case 2
        int[] arr = {-7,-3,2,3,11};
        int[] result = obj.sortedSquares(arr);
        System.out.println(Arrays.toString(result));
    }


}
