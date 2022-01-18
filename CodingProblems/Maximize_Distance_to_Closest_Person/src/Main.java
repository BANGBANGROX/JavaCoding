import java.util.Scanner;

class Solution {
    public int maxDistToClosest(int[] seats) {
        int n = seats.length;
        int maxDistance = 0;
        int lastPosition = -1;

        for (int i = 0; i < n; ++i) {
            if (seats[i] == 1) {
               if (lastPosition == -1) {
                   maxDistance = i;
               }
               else {
                   maxDistance = Math.max(maxDistance, (i - lastPosition) / 2);
               }
               lastPosition = i;
            }
        }

        maxDistance = Math.max(maxDistance, (n - 1 - lastPosition));

        return maxDistance;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] seats = new int[n];
            for (int i = 0; i < n; ++i) {
                seats[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxDistToClosest(seats));
        }

        sc.close();
    }
}
