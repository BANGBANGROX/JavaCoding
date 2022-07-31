import java.util.Scanner;

class Solution {
    public int consecutiveNumbersSum(int n) {
          int ans = 0;

          for (int l = 1; l * (l + 1) < 2 * n; ++l) {
              if ((2 * n - l * (l + 1)) % (2 * (l + 1)) == 0) ++ans;
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

            Solution solution = new Solution();
            System.out.println(solution.consecutiveNumbersSum(n));
        }

        sc.close();
    }
}
