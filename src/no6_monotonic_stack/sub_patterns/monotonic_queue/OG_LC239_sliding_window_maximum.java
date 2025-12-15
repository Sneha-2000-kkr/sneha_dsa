package no6_monotonic_stack.sub_patterns.monotonic_queue;

import java.util.ArrayDeque;
import java.util.Arrays;

/*
https://leetcode.com/problems/sliding-window-maximum/description/

“Window fixed hai, sliding window use ho raha hai.
Deque bas maximum ko O(1) me maintain karta hai.”

Method	    Meaning
addLast(x)	peeche add karo
pollFirst()	aage se hatao
pollLast()	peeche se hatao
peekFirst()	aage ka element dekho
peekLast()	peeche ka element dekho
 */
public class OG_LC239_sliding_window_maximum {

    public int[] maxSlidingWindowBruteForce(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];

        for (int i = 0; i <= n - k; i++) {
            int max = nums[i];
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            res[i] = max;
        }
        return res;
    }

    public int[] maxSlidingWindowOptimisedApproach(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        ArrayDeque<Integer> dq = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; i++) {

            // 1️⃣ Remove elements which are out of this window
            if (!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }

            // 2️⃣ Remove smaller elements from the back
            while (!dq.isEmpty() && nums[dq.peekLast()] < nums[i]) {
                dq.pollLast();
            }

            // 3️⃣ Add current index at the back
            dq.addLast(i);

            // 4️⃣ Window formed, take max
            if (i >= k - 1) {
                result[i - k + 1] = nums[dq.peekFirst()];
            }
        }
        return result;
    }


    public static void main(String[] args) {
        OG_LC239_sliding_window_maximum obj = new OG_LC239_sliding_window_maximum();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println("Brute Force: " + Arrays.toString(obj.maxSlidingWindowBruteForce(nums, k)));
        System.out.println("Optimised Sol: " + Arrays.toString(obj.maxSlidingWindowOptimisedApproach(nums, k)));

    }
}
