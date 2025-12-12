package no4_binary_search;

/*
https://leetcode.com/problems/peak-index-in-a-mountain-array/description/
 */
public class LC852_peak_index_in_a_mountain_array {
    public int peakIndexInMountainArray(int[] arr) {
        int left =0;
        int right = arr.length -1;

        while(left < right){
            int mid = (left+right)/2;
            if(arr[mid]<arr[mid+1]) left= mid+1;
            else right= mid;
        }
        return left;

    }

    public static void main(String[] args) {
        LC852_peak_index_in_a_mountain_array obj = new LC852_peak_index_in_a_mountain_array();
//        int[] arr = {0,2,1,0};
        int[] arr = {0,10,5,2};
        System.out.println(obj.peakIndexInMountainArray(arr));
    }
}
