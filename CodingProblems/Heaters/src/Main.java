import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private int lowerBound(int[] heaters, int key) {
        int l = 0, r = heaters.length - 1;

        while (l < r) {
            int mid = (l + ((r - l) >> 1));
            if (heaters[mid] > key) r = mid;
            else l = mid + 1;
        }

        return l;
    }

    public int findRadius(int[] houses, int[] heaters) {
        int ans = 0;

        Arrays.sort(houses);
        Arrays.sort(heaters);

        for (int house : houses) {
           int lower = lowerBound(heaters, house);
           if (lower == 0 || heaters[lower] == house) {
               ans = Math.max(ans, Math.abs(heaters[lower] - house));
               continue;
           }
           ans = Math.max(ans,Math.min(Math.abs(house - heaters[lower - 1]), Math.abs(heaters[lower] - house)));
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int[] houses = new int[n];
            for (int i = 0; i < n; ++i) {
                houses[i] = sc.nextInt();
            }
            int m = sc.nextInt();
            int[] heaters = new int[m];
            for (int i = 0; i < m; ++i) {
                heaters[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.findRadius(houses, heaters));
        }

        sc.close();
    }
}
