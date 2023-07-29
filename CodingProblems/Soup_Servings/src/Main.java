import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private HashMap<Integer, HashMap<Integer, Double>> dp;

    private double soupServingsHandler(int i, int j) {
        if (i <= 0 && j <= 0) return 0.5;

        if (i <= 0) return 1.0;

        if (j <= 0) return 0.0;

        if (dp.containsKey(i) && dp.get(i).containsKey(j)) return dp.get(i).get(j);

        double result = (soupServingsHandler(i - 4, j) +
                soupServingsHandler(i - 3, j - 1) +
                soupServingsHandler(i - 2, j - 2) +
                soupServingsHandler(i - 1, j - 3)) / 4.0;

        dp.computeIfAbsent(i, k -> new HashMap<>()).put(j, result);

        return result;
    }

    public double soupServings(int n) {
        dp = new HashMap<>();
        int m = (int) Math.ceil(n / 25.0);
        double maxGap = 1 - 1e-5;

        for (int i = 1; i <= m; ++i) {
            if (soupServingsHandler(i, i) > maxGap) {
                return 1.0;
            }
        }

        return soupServingsHandler(m, m);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.soupServings(n));
        }

        sc.close();
    }
}
