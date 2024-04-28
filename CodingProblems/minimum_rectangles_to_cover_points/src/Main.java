import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int totalPoints = points.length;
        int requiredRectangles = 1;

        Arrays.sort(points, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int lastXCoordinate = points[0][0];

        for (int i = 1; i < totalPoints; ++i) {
            if (points[i][0] > lastXCoordinate + w) {
                lastXCoordinate = points[i][0];
                ++requiredRectangles;
            }
        }

        return requiredRectangles;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int totalPoints = sc.nextInt();
            int[][] points = new int[totalPoints][2];
            for (int i = 0; i < totalPoints; ++i) {
                points[i][0] = sc.nextInt();
                points[i][1] = sc.nextInt();
            }
            int w = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minRectanglesToCoverPoints(points, w));
        }

        sc.close();
    }
}
