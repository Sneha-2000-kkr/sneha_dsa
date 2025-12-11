package no2_sliding_window;
import java.util.LinkedHashSet;

public class LC3_longest_substring_without_repeating_char {

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        int n = s.length();
        int left = 0;
        int maxLen = 0;

        // Use LinkedHashSet<Character> so the set's iteration order == insertion order.
        LinkedHashSet<Character> set = new LinkedHashSet<>();

        for (int right = 0; right < n; right++) {
            char cur = s.charAt(right);

            if (!set.contains(cur)) {
                set.add(cur);
                maxLen = Math.max(maxLen, right - left + 1);
            } else {
                // remove from left until duplicate 'cur' is removed
                while (set.contains(cur)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                // now safe to add current char
                set.add(cur);
            }
        }

        return maxLen;
    }

    public static void main(String[] args) {
        LC3_longest_substring_without_repeating_char obj = new LC3_longest_substring_without_repeating_char();
        String input = "abcabcbb";
        int result = obj.lengthOfLongestSubstring(input);
        System.out.println("Input: \"" + input + "\" → Output: " + result);

    }

}
