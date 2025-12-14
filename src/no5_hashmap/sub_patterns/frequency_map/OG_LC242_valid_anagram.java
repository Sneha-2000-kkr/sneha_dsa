package no5_hashmap.sub_patterns.frequency_map;


import java.util.HashMap;

/*
https://leetcode.com/problems/valid-anagram/description/
 */
public class OG_LC242_valid_anagram {

    public boolean isAnagram(String s, String t) {
        // if string len does not even match they can not be anagram
        if(s.length()!=t.length()) return false;

        HashMap<Character, Integer> charMap = new HashMap<>();

        // making a map of char vs it's frequency in string
        for(char c: s.toCharArray()) charMap.put(c, charMap.getOrDefault(c,0)+1);

        System.out.println("after making charMap "+ charMap);

        for(char c: t.toCharArray()){
            if(!charMap.containsKey(c)||charMap.get(c)<1) return false;
            charMap.put(c, charMap.getOrDefault(c,0)-1);
        }
        System.out.println("after reducing charMap "+ charMap);

        return true;

    }

    public static void main(String[] args) {
        OG_LC242_valid_anagram obj = new OG_LC242_valid_anagram();
//        test case 1
//        String s = "anagram";
//        String t = "nagaram";
//        test case 2
        String s = "rat";
        String t = "car";
        Boolean result = obj.isAnagram(s,t);
        System.out.println(result);

    }
}
