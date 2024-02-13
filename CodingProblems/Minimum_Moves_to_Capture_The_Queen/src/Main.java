import java.util.Scanner;

class Solution {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        // Try for rook -> Same file or same rank
        if (a == e) {
            if (a != c) return 1;
            int maxValue = Math.max(b, f);
            int minValue = Math.min(b, f);
            if (d > maxValue || d < minValue) return 1;
        }

        if (b == f) {
            if (b != d) return 1;
            int maxValue = Math.max(a, e);
            int minValue = Math.min(a, e);
            if (c > maxValue || c < minValue) return 1;
        }

        // For bishop -> Same diagonal
        if (Math.abs(c - e) == Math.abs(d - f)) {
            if (Math.abs(c - a) != Math.abs(d - b)) return 1;
            int maxValueX = Math.max(c, e);
            int minValueX = Math.min(c, e);
            int maxValueY = Math.max(d, f);
            int minValueY = Math.min(d, f);
            if (!(a < maxValueX && a > minValueX && b < maxValueY && b > minValueY)) return 1;
        }

        return 2;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            int e = sc.nextInt();
            int f = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.minMovesToCaptureTheQueen(a, b, c, d, e, f));
        }

        sc.close();
    }
}
