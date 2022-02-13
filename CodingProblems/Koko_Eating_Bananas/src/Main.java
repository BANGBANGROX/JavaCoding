import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean checkSpeed(int[] piles, int h, int speed) {
        int hours = 0;

        for (int pile : piles) {
            if (pile % speed == 0) hours += (pile / speed);
            else hours += (pile / speed + 1);
            if (hours > h) return false;
        }

        return true;
    }

    public int minEatingSpeed(int[] piles, int h) {
         int maxElement = Arrays.stream(piles).max().getAsInt();
         int low = 1;
         int high = maxElement + 1;

         while (low < high) {
             int mid = (low + ((high - low) >> 1));
             if (checkSpeed(piles, h, mid)) high = mid;
             else low = mid + 1;
         }

         return low;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] piles = new int[n];
            for (int i = 0; i < n; ++i) {
                piles[i] = sc.nextInt();
            }
            int h = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minEatingSpeed(piles, h));
        }

        sc.close();
    }
}
