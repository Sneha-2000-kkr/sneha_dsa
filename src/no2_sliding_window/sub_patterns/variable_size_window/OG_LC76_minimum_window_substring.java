package no2_sliding_window.sub_patterns.variable_size_window;

import java.util.HashMap;

public class OG_LC76_minimum_window_substring {

    public String minWindowBruteForce(String s, String t) {
        int minLen = Integer.MAX_VALUE;
        String ans = "";

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                HashMap<Character, Integer> map = new HashMap<>();
                for (char c : t.toCharArray())
                    map.put(c, map.getOrDefault(c, 0) + 1);

                for (int k = i; k <= j; k++) {
                    char c = s.charAt(k);
                    if (map.containsKey(c))
                        map.put(c, map.get(c) - 1);
                }

                boolean ok = true;
                for (int v : map.values()) {
                    if (v > 0) {
                        ok = false;
                        break;
                    }
                }

                if (ok && j - i + 1 < minLen) {
                    minLen = j - i + 1;
                    ans = s.substring(i, j + 1);
                }
            }
        }
        return ans;

    }

    public String minWindowBetterApproach(String s, String t) {
        if (s.length() < t.length()) return "";

        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : t.toCharArray())
            map.put(c, map.getOrDefault(c, 0) + 1);

        int left = 0, count = map.size();
        int minLen = Integer.MAX_VALUE, start = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
                if (map.get(c) == 0) count--;
            }

            while (count == 0) {
                if (right - left + 1 < minLen) {
                    minLen = right - left + 1;
                    start = left;
                }

                char lc = s.charAt(left);
                if (map.containsKey(lc)) {
                    map.put(lc, map.get(lc) + 1);
                    if (map.get(lc) > 0) count++;
                }
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }


    public String minWindowOptimisedSolution(String s, String t) {
        int[] freq = new int[128];
        for (char c : t.toCharArray()) freq[c]++;

        int left = 0, right = 0, count = t.length();
        int minLen = Integer.MAX_VALUE, start = 0;

        while (right < s.length()) {
            if (freq[s.charAt(right)]-- > 0) count--;
            right++;

            while (count == 0) {
                if (right - left < minLen) {
                    minLen = right - left;
                    start = left;
                }
                if (freq[s.charAt(left)]++ == 0) count++;
                left++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }

    public static void main(String[] args) {
        OG_LC76_minimum_window_substring obj = new OG_LC76_minimum_window_substring();
        String s = "ADOBECODEBANC";
        String t = "ABC";
        System.out.println("Brute Force: "+ obj.minWindowBruteForce(s,t));
        System.out.println("Better Sol: "+ obj.minWindowBetterApproach(s,t));
        System.out.println("Optimised Sol: "+ obj.minWindowOptimisedSolution(s,t));

    }
}
