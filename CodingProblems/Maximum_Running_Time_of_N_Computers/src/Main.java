import java.util.Scanner;

class Solution {
    private boolean checkTime(long time, int n, int[] batteries) {
        long totalTime = n * time;
        long currentTime = 0;

        for (int battery : batteries) {
            currentTime += Math.min(battery, time);
            if (currentTime >= totalTime) return true;
        }

        return false;
    }

    public long maxRunTime(int n, int[] batteries) {
       long totalTime = 0;
       int minTime = Integer.MAX_VALUE;

       for (int battery : batteries) {
           totalTime += battery;
           minTime = Math.min(minTime, battery);
       }

       long low = minTime;
       long high = (totalTime) / n;
       long ans = -1;

       while (low <= high) {
           long mid = (low + ((high - low) >> 1));
           if (checkTime(mid, n, batteries)) {
               ans = mid;
               low = mid + 1;
           }
           else high = mid;
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
            int m = sc.nextInt();
            int[] batteries = new int[m];
            for (int i = 0; i < m; ++i) {
                batteries[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.maxRunTime(n, batteries));
        }

        sc.close();
    }
}
