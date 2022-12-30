import java.util.HashSet;
import java.util.Scanner;

class Solution {
    private int computePrimeFactorSum(int n) {
        int ans = 0;

        for (int i = 2; i * i <= n; ++i) {
            int cnt = 0;
            while (n % i == 0) {
                ++cnt;
                n /= i;
            }
            ans += cnt * i;
        }

        if (n > 1) ans += n;

        return ans;
    }

    public int smallestValue(int n) {
       HashSet<Integer> visited = new HashSet<>();

       while (!visited.contains(n)) {
           visited.add(n);
           n = computePrimeFactorSum(n);
       }

       return n;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.smallestValue(n));
        }

        sc.close();
    }
}
