import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a, b) -> (a[0] != b[0] ? a[0] - b[0] : b[1] - a[1]));

        int n = intervals.length;
        int maxR = intervals[0][1];
        int ans = n;

        for (int i = 1; i < n; ++i) {
            if (intervals[i][1] <= maxR) --ans;
            else maxR = intervals[i][1];
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
            int[][] intervals = new int[n][2];
            for (int i = 0; i < n; ++i) {
                intervals[i][0] = sc.nextInt();
                intervals[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.removeCoveredIntervals(intervals));
        }

        sc.close();
    }
}
