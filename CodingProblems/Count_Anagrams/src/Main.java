import java.util.Scanner;

class Solution {
    private final int MOD = 1_000_000_007;

    private long binExp(long a) {
        long res = 1;
        long b = MOD - 2;

        while (b > 0) {
            if ((b & 1) > 0) {
                res = (res * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return res;
    }

    public int countAnagrams(String s) {
        int n = s.length();
        long[] factorial = new long[n + 1];

        factorial[0] = 1;

        for (int i = 1; i <= n; ++i) {
            factorial[i] = (factorial[i - 1] * i) % MOD;
        }

        String[] words = s.split(" ");
        long ans = 1;

        for (String word : words) {
            int m = word.length();
            long res = factorial[m];
            int[] count = new int[26];
            for (char ch : word.toCharArray()) {
                ++count[ch - 'a'];
            }
            for (int i = 0; i < 26; ++i) {
                res = (res * binExp(factorial[count[i]])) % MOD;
            }
            ans = (ans * res) % MOD;
        }

        return (int) ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.nextLine();

            Solution solution = new Solution();
            System.out.println(solution.countAnagrams(s));
        }

        sc.close();
    }
}
