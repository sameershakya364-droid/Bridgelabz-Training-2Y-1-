package src.Arrays.Assignment.HashMap;

import java.util.HashMap;
import java.util.Map;

public class LongestConsecutiveSequence {
    static int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> values = new HashMap<>();
        for (int num : nums) values.put(num, true);

        int longest = 0;
        for (int num : values.keySet()) {
            if ((long) num - 1 < Integer.MIN_VALUE || !values.containsKey(num - 1)) {
                long current = num;
                int length = 0;
                while (current <= Integer.MAX_VALUE && values.containsKey((int) current)) {
                    length++;
                    current++;
                }
                longest = Math.max(longest, length);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutive(nums));
    }
}
