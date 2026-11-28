package src.Arrays.Assignment.HashMap;

import java.util.HashMap;
import java.util.Map;

public class PairWithGivenSum {
    static void findPair(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();

        for (int num : nums) {
            int needed = target - num;
            if (seen.containsKey(needed)) {
                System.out.println("Pair found: " + needed + " + " + num);
                return;
            }
            seen.put(num, 1);
        }
        System.out.println("No pair found");
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        findPair(nums, 9);
    }
}
