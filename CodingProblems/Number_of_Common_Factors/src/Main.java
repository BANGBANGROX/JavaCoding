import java.util.Scanner;

class Solution {
    public int commonFactors(int a, int b) {
         int ans = 0;

         if (a > b) return commonFactors(b, a);

         for (int i = 1; i * i <= a; ++i) {
             if (a % i == 0 && b % i == 0) {
                 ++ans;
                 if (a / i != i) {
                     if (b % (a / i) == 0) ++ans;
                 }
             }
             else if (a % i == 0 && b % (a / i) == 0) ++ans;
         }

         return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.commonFactors(a, b));
        }

        sc.close();
    }
}
