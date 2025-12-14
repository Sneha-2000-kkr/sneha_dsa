package no6_monotonic_stack.sub_patterns.next_greater_or_smaller;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class OG_LC739_daily_temp {

    // brute force approach h, mst O(n^2) TC lagega and O(n) ki SC bhi
//    public int[] dailyTemperatures(int[] temps) {
//        int n = temps.length;
//        int[] res = new int[n];
//
//        for (int i = 0; i < n; i++) {
//            for (int j = i + 1; j < n; j++) {
//                if (temps[j] > temps[i]) {
//                    res[i] = j - i;
//                    break;
//                }
//            }
//        }
//        return res;
//    }

    // optimised approach h ye, stack DS bhi use kr skte the but that's old better to use
    // ArrayDeque
    public int[] dailyTemperatures(int[] temps) {
        int n = temps.length;
        int[] res = new int[n];
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && temps[i] > temps[stack.peek()]) {
                int prev = stack.pop();
                res[prev] = i - prev;
            }
            stack.push(i);
        }
        return res;
    }

    public static void main(String[] args) {
        OG_LC739_daily_temp obj = new OG_LC739_daily_temp();
        int[] temperatures = {73,74,75,71,69,72,76,73};
        System.out.println(Arrays.toString( obj.dailyTemperatures(temperatures)));



    }
}
