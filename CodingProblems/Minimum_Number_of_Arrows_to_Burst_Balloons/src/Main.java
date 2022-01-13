import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int findMinArrowShots(int[][] points) {
        int n = points.length;
        int ans = 1;

        Arrays.sort(points, (a, b) -> {
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });

        int position = points[0][1];

        for (int i = 1; i < n; ++i) {
            int l = points[i][0];
            int r = points[i][1];
            if (position >= l && position <= r) continue;
            ++ans;
            position = r;
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
            int[][] points = new int[n][2];
            for (int i = 0; i < n; ++i) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.findMinArrowShots(points));
        }

        sc.close();
    }
}
