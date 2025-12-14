package no9_greedy.sub_patterns.partition_labels;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
https://leetcode.com/problems/partition-labels/description/
 */
public class OG_LC763_partition_labels {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> last = new HashMap<>();

        // char[] charArray = s.toCharArray();
        for(int i=0; i<s.length();i++){
                last.put(s.charAt(i), i);
        }

        List<Integer> res = new ArrayList<>();
        int end = 0;
        int size = 0;

        // Step 2: greedy scan
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            size++;

            end = Math.max(end, last.get(c));   // fetch last index from Map

            if (i == end) {  // partition complete
                res.add(size);
                size = 0;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        OG_LC763_partition_labels obj = new OG_LC763_partition_labels();
        String s = "ababcbacadefegdehijhklij";
        System.out.println(obj.partitionLabels(s));

    }
}
