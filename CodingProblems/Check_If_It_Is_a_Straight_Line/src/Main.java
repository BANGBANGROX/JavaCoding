import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
         Arrays.sort(coordinates, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

         int x1 = coordinates[0][0];
         int y1 = coordinates[0][1];
         int x2 = coordinates[1][0];
         int y2 = coordinates[1][1];
         int n = coordinates.length;
         boolean infiniteSlope = false;
         double slope = -1;

         if (x1 == x2) {
             infiniteSlope = true;
         } else {
             slope = (double) (y2 - y1) / (x2 - x1);
         }

         for (int i = 2; i < n; ++i) {
             int prevX = coordinates[i - 1][0];
             int prevY = coordinates[i - 1][1];
             int currX = coordinates[i][0];
             int currY = coordinates[i][1];
             if (infiniteSlope && prevX != currX) return false;
             if (prevX == currX) {
                 if (!infiniteSlope) return false;
                 continue;
             }
             double currentSlope = (double) (currY - prevY) / (currX - prevX);
             if (currentSlope != slope) return false;
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
            int[][] coordinates = new int[n][2];
            for (int i = 0; i < n; ++i) {
                coordinates[i][0] = sc.nextInt();
                coordinates[i][1] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.checkStraightLine(coordinates));
        }

        sc.close();
    }
}
