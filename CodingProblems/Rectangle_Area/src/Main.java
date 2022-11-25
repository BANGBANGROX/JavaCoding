import java.util.Scanner;

class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1,
                           int by1, int bx2, int by2) {
        int aArea = (ay2 - ay1) * (ax2 - ax1);
        int bArea = (by2 - by1) * (bx2 - bx1);
        int minX = Math.min(ax2, bx2);
        int maxX = Math.max(ax1, bx1);
        int xOverlap = minX - maxX;
        int minY = Math.min(ay2, by2);
        int maxY = Math.max(ay1, by1);
        int yOverlap = minY - maxY;

        if (xOverlap > 0 && yOverlap > 0) return aArea + bArea - xOverlap * yOverlap;

        return aArea + bArea;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int[] coordinates = new int[8];
            for (int i = 0; i < 8; ++i) {
                coordinates[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.computeArea(coordinates[0], coordinates[1],
                    coordinates[2], coordinates[3], coordinates[4], coordinates[5],
                    coordinates[6], coordinates[7]));
        }

        sc.close();
    }
}
