package no5_hashmap;

import java.util.HashMap;

/*
https://leetcode.com/problems/word-pattern/
 */
public class LC290_word_pattern {
    public boolean wordPattern(String pattern, String s) {
        String[] wordArray = s.split(" ");
        if(pattern.length()!=wordArray.length) return false;
        HashMap<Character,String> charToWordMap = new HashMap<>();
        HashMap<String,Character> wordToCharMap = new HashMap<>();
        for(int i=0; i<pattern.length(); i++){
            char a = pattern.charAt(i);
            String b = wordArray[i];
            if(charToWordMap.containsKey(a)){
                if(!charToWordMap.get(a).equals(b)) return false;
            }
            else charToWordMap.put(a,b);

            if(wordToCharMap.containsKey(b)){
                if(wordToCharMap.get(b)!=a) return false;
            }
            else wordToCharMap.put(b,a);
        }
        return true;
    }

    public static void main(String[] args) {
        LC290_word_pattern obj = new LC290_word_pattern();
//        String pattern = "abba";
//        String s = "dog cat cat dog";
//        String pattern = "aaaa";
//        String s = "dog cat cat dog";
        String pattern = "abba";
        String s = "dog cat cat fish";
        System.out.println(obj.wordPattern(pattern,s));

    }
}
