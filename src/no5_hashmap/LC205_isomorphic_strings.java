package no5_hashmap;

import java.util.HashMap;

/*
https://leetcode.com/problems/isomorphic-strings/description/
 */
public class LC205_isomorphic_strings {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        HashMap<Character, Character> sCharMap = new HashMap<>();
        HashMap<Character, Character> tCharMap = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            // s -> t
            if (sCharMap.containsKey(cs)) {
                if (sCharMap.get(cs) != ct) return false;
            } else {
                sCharMap.put(cs, ct);
            }

            // t -> s
            if (tCharMap.containsKey(ct)) {
                if (tCharMap.get(ct) != cs) return false;
            } else {
                tCharMap.put(ct, cs);
            }
        }

        return true;
    }


    public static void main(String[] args) {
        LC205_isomorphic_strings obj = new LC205_isomorphic_strings();
        String s = "egg";
        String t = "add";
        System.out.println(obj.isIsomorphic(s,t));

    }
}
