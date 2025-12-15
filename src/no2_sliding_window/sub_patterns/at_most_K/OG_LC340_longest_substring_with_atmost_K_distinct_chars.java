package no2_sliding_window.sub_patterns.at_most_K;

import java.util.HashMap;
import java.util.HashSet;

/*
Problem Statement

You are given a string s and an integer k.
Return the length of the longest substring that contains at most k distinct characters.

A substring is a continuous sequence of characters.

Input:
s = "eceba"
k = 2

Output:
3
 */
public class OG_LC340_longest_substring_with_atmost_K_distinct_chars {
    public int lengthOfLongestSubstringKDistinctBruteForce(String s, int k) {
        int n = s.length();
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            HashSet<Character> set = new HashSet<>();
            for (int j = i; j < n; j++) {
                set.add(s.charAt(j));
                if (set.size() > k) break;
                maxLen = Math.max(maxLen, j - i + 1);
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstringKDistinctOptimisedSolution(String s, int k) {
        if (k == 0) return 0;

        HashMap<Character, Integer> freq = new HashMap<>();
        int left = 0, ans = 0;

        for (int right = 0; right < s.length(); right++) {
            freq.put(s.charAt(right), freq.getOrDefault(s.charAt(right), 0) + 1);

            while (freq.size() > k) {
                char ch = s.charAt(left);
                freq.put(ch, freq.get(ch) - 1);
                if (freq.get(ch) == 0) freq.remove(ch);
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }


    public static void main(String[] args) {
        OG_LC340_longest_substring_with_atmost_K_distinct_chars obj = new OG_LC340_longest_substring_with_atmost_K_distinct_chars();
        String s = "aaabbccd";
        int k =2;
        System.out.println("Brute Force: " + obj.lengthOfLongestSubstringKDistinctBruteForce(s,k));
        System.out.println("Optimised Sol: " + obj.lengthOfLongestSubstringKDistinctOptimisedSolution(s,k));


    }
}
