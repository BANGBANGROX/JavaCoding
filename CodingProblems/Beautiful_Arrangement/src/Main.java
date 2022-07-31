import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private boolean[] available;

    private int countArrangementUtil(int index, int n) {
        if (index > n) return 1;

        int ans = 0;

        for (int i = 1; i <= n; ++i) {
            if (available[i] && (i % index == 0 || index % i == 0)) {
                available[i] = false;
                ans += countArrangementUtil(index + 1, n);
                available[i] = true;
            }
        }

        return ans;
    }

    public int countArrangement(int n) {
         available = new boolean[n + 1];

         Arrays.fill(available, true);

         return countArrangementUtil(1, n);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.countArrangement(n));
        }

        sc.close();
    }
}
