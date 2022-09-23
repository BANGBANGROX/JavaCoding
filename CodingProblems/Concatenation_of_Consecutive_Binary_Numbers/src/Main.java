import java.util.Scanner;

class Solution {
    public int concatenatedBinary(int n) {
        int ans = 0;
        int mul = 1;

        for (int i = n; i > 0; --i) {
            int num = i;
            while (num > 0) {
                int bit = num % 2;
                int MOD = (int) 1e9 + 7;
                if (bit > 0) {
                    ans = (ans + mul) % MOD;
                }
                num /= 2;
                mul = (mul * 2) % MOD;
            }
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
            System.out.println(solution.concatenatedBinary(n));
        }

        sc.close();
    }
}
