package src.Queue.Assignment;

import java.util.ArrayDeque;
import java.util.Queue;

public class CircularTourProblem {
    static int findStartingPoint(int[] petrol, int[] distance) {
        int n = petrol.length;
        if (n == 0 || n != distance.length) return -1;

        for (int start = 0; start < n; start++) {
            Queue<Integer> route = new ArrayDeque<>();
            for (int i = 0; i < n; i++) route.offer((start + i) % n);

            int fuel = 0;
            boolean possible = true;
            while (!route.isEmpty()) {
                int station = route.poll();
                fuel += petrol[station] - distance[station];
                if (fuel < 0) {
                    possible = false;
                    break;
                }
            }
            if (possible) return start;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] petrol = {4, 6, 7, 4};
        int[] distance = {6, 5, 3, 5};
        System.out.println(findStartingPoint(petrol, distance));
    }
}
