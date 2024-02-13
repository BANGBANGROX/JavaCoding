import java.util.Scanner;

class Solution {
    public int kthGrammar(int n, int k) {
         if (n == 1) {
             return 0;
         }

         int len = 1 << (n - 2);

         if (k <= len) {
             return kthGrammar(n - 1, k);
         }

         return 1 - kthGrammar(n - 1, k - len);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.kthGrammar(n, k));
        }

        sc.close();
    }
}
