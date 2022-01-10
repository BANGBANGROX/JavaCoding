import java.util.Scanner;

class Solution {
    public int bitwiseComplement(int n) {
         int fullMask = 0;
         int N = n;

         if (n == 0) return 1;

         while (n > 0) {
             fullMask = fullMask * 2 + 1;
             n /= 2;
         }

         return fullMask - N;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.bitwiseComplement(n));
        }

        sc.close();
    }
}
