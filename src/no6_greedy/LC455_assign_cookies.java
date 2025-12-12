package no6_greedy;
import java.util.Arrays;

/*
https://leetcode.com/problems/assign-cookies/description/
 */
public class LC455_assign_cookies {

    /*
    this is a unworked method for example like:
    g =[250,490,328,149,495,325,314,360,333,418,430,458]
    s =[376,71,228,110,215,410,363,135,508,268,494,288,24,362,20,5,247,118,152,393,458,354,201,188,425,167,220,114,148,43,403,385,512,459,71,425,142,102,361,102,232,203,25,461,298,437,252,364,171,240,233,257,305,346,307,408,163,216,243,261,137,319,33,91,116,390,139,283,174,409,191,338,123,231,101,458,497,306,400,513,175,454,273,88,169,250,196,109,505,413,371,448,12,193,396,321,466,526,276,276,198,260,131,322,65,381,204,32,83,431,81,108,366,188,443,331,102,72,496,521,502,165,439,161,257,324,348,176,272,341,230,323,124,13,51,241,186,329,70,387,93,126,159,370,292,16,211,327,431,26,70,239,379,368,215,501,382,299,481,163,100,488,259,524,481,87,118,112,1]
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;
        if(s.length==0) return 0;
        int len = Math.min(s.length,g.length);
        int j=0;
        while(j<g.length){
            for(int i=0; i<len;i++)
            {
                if(g[j]<=s[i])
                {
                    count++;
                    s[i]=0;
                    break;
                }
            }
            j++;
        }
        return count;
    }
     */

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int i = 0; // child pointer
        int j = 0; // cookie pointer
        int count = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) { // cookie j can satisfy child i
                count++;
                i++;
                j++;
            } else {
                // cookie too small, try bigger cookie
                j++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        LC455_assign_cookies obj = new LC455_assign_cookies();
//        int[] g = {1,2,3};
//        int[] s = {1,1};
        int[] g = {1,2};
        int[] s = {1,2,3};
//        int[] g = {10,9,8,7};
//        int[] s = {5,6,7,8};
        System.out.println(obj.findContentChildren(g,s));

    }
}
