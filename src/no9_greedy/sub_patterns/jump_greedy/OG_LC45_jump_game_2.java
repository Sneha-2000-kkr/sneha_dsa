package no9_greedy.sub_patterns.jump_greedy;

public class OG_LC45_jump_game_2 {

    public int jump(int[] nums) {
        int jumps = 0;
        int currentEnd = 0;
        int farthest = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (i == currentEnd) {
                jumps++;
                currentEnd = farthest;
            }
        }

        return jumps;
    }


    public static void main(String[] args) {
        OG_LC45_jump_game_2 obj = new OG_LC45_jump_game_2();
        int[] nums = {2,3,1,1,4};
        System.out.println( obj.jump(nums));


    }
}
