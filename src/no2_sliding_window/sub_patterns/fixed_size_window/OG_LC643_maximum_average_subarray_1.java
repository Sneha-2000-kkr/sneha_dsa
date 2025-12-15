package no2_sliding_window.sub_patterns.fixed_size_window;

public class OG_LC643_maximum_average_subarray_1 {
    public double findMaxAverageBruteForce(int[] nums, int k) {
        double maxAvg = -Double.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += nums[j];
            }
            maxAvg = Math.max(maxAvg, (double) sum / k);
        }
        return maxAvg;

    }

    public double findMaxAverageOptimisedSolution(int[] nums, int k) {
        int windowSum = 0;
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            windowSum += nums[i];

            if (i >= k - 1) {
                maxSum = Math.max(maxSum, windowSum);
                windowSum -= nums[i - k + 1];
            }
        }
        return (double) maxSum / k;

    }

    public static void main(String[] args) {
        OG_LC643_maximum_average_subarray_1 obj = new OG_LC643_maximum_average_subarray_1();
        int[] nums = {1,12,-5,-6,50,3};
        int k = 4;
        System.out.println("Brute Force: "+ obj.findMaxAverageBruteForce(nums,k));
        System.out.println("Optimised Sol: "+ obj.findMaxAverageOptimisedSolution(nums,k));

    }
}
