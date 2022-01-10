import java.util.Scanner;

class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int lower = Integer.MAX_VALUE;
        int upper = Integer.MIN_VALUE;

        for (int[] trip : trips) {
            lower = Math.min(lower, trip[1]);
            upper = Math.max(upper, trip[2]);
        }

        int[] passengers = new int[upper + 1];
        int currentlyFilled = 0;

        for (int[] trip : trips) {
            passengers[trip[1]] += trip[0];
            passengers[trip[2]] -=trip[0];
        }

        for (int i = lower; i <= upper; ++i) {
            currentlyFilled += passengers[i];
            if (currentlyFilled > capacity) return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[][] trips = new int[n][3];
            for (int i = 0; i < n; ++i) {
                trips[i][0] = sc.nextInt();
                trips[i][1] = sc.nextInt();
                trips[i][2] = sc.nextInt();
            }
            int capacity = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.carPooling(trips, capacity));
        }

        sc.close();
    }
}
