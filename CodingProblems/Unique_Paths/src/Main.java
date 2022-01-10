import java.util.Scanner;

class Solution {
    public int uniquePaths(int m, int n) {
         if (m == 1 || n == 1) return 1;

         long ans = 1;

         for (int i = 1; i < n; ++i) {
             ans *= (m + i - 1);
             ans /= i;
         }

         return (int)ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();

            Solution obj = new Solution();
            System.out.println(obj.uniquePaths(m, n));
        }

        sc.close();
    }
}
