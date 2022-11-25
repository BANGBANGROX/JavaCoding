import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int largestOverlap(int[][] img1, int[][] img2) {
        int n = img1.length;
        ArrayList<Integer> a = new ArrayList<>();
        ArrayList<Integer> b = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        int ans = 0;

        for (int i = 0; i < n * n; ++i) {
            int e = i / n * 100 + i % n;
            if (img1[i / n][i % n] == 1) {
                a.add(e);
            }
            if (img2[i / n][i % n] == 1) {
                b.add(e);
            }
        }

        for (int x : a) {
            for (int y : b) {
                count.put(x - y, count.getOrDefault(x - y, 0) + 1);
            }
        }

        for (int x : count.keySet()) {
            ans = Math.max(ans, count.get(x));
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
            int[][] img1 = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    img1[i][j] = sc.nextInt();
                }
            }
            int[][] img2 = new int[n][n];
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    img2[i][j] = sc.nextInt();
                }
            }

            Solution solution = new Solution();
            System.out.println(solution.largestOverlap(img1, img2));
        }

        sc.close();
    }
}
