package src.Arrays.Assignment.HashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindAllSubarraysWithZeroSum {
    static void printSubarrays(int[] nums) {
        Map<Long, List<Integer>> positions = new HashMap<>();
        positions.put(0L, new ArrayList<>());
        positions.get(0L).add(-1);

        long sum = 0;
        boolean found = false;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            List<Integer> previous = positions.get(sum);
            if (previous != null) {
                for (int start : previous) {
                    System.out.println("(" + (start + 1) + ", " + i + ")");
                    found = true;
                }
            }
            positions.computeIfAbsent(sum, key -> new ArrayList<>()).add(i);
        }
        if (!found) System.out.println("No zero-sum subarray found");
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, -3, 3, -1, 2};
        printSubarrays(nums);
    }
}
