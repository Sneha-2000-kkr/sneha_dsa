package no4_binary_search.sub_patterns.binary_search_on_answer;

// k is number of bananas she can have per hr, such that she can eat all the piles in given time frame

public class OG_LC875_koko_eating_banana {

    public int minEatingSpeedBruteForce(int[] piles, int h) {
        int max = 0;
        for (int p : piles) max = Math.max(max, p);

        for (int k = 1; k <= max; k++) {
            int hours = 0;
            for (int p : piles) {
                hours += (int) Math.ceil((double) p / k);
            }
            if (hours <= h) return k;
        }
        return max;

    }

    public int minEatingSpeedOptimisedSol(int[] piles, int h) {
        int low = 1, high = 0;
        for (int p : piles) high = Math.max(high, p);

        while (low < high) {
            int mid = low + (high - low) / 2;
            int time = 0;

            for (int p : piles) {
                time += (p + mid - 1) / mid;
            }

            if (time > h) low = mid + 1;
            else high = mid;
        }
        return low;

    }

    public static void main(String[] args) {
        OG_LC875_koko_eating_banana obj = new OG_LC875_koko_eating_banana();
        int[] piles = {30,11,23,4,20};
        int h = 5;
        System.out.println("Brute Force: " + obj.minEatingSpeedBruteForce(piles,h));
        System.out.println("Optimised Sol: " + obj.minEatingSpeedOptimisedSol(piles,h));
    }
}
