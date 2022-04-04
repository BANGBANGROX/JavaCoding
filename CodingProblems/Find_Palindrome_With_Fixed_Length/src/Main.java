import java.util.Scanner;

class Solution {
    private long reverseNum(long num, int skip) {
        long ans = 0;

        for (long n = skip == 0 ? num : num / 10; n > 0; n /= 10) {
            ans = ans * 10 + n % 10;
        }

        return ans;
    }

    public long[] kthPalindrome(int[] queries, int intLength) {
        int q = queries.length;
        long[] ans = new long[q];
        long start = (long)Math.pow(10, (intLength + 1) / 2 - 1);
        long end = (long)Math.pow(10, (intLength + 1) / 2) - 1;
        long mul = (long)Math.pow(10, intLength / 2);

        for (int i = 0; i < q; ++i) {
            int query = queries[i];
            long firstNum = start + query - 1;
            ans[i] = firstNum > end ? -1 : firstNum * mul + reverseNum(firstNum, intLength % 2);
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int q = sc.nextInt();
            int[] queries = new int[q];
            for (int i = 0; i < q; ++i) {
                queries[i] = sc.nextInt();
            }
            int intLength = sc.nextInt();

            Solution solution = new Solution();
            long[] ans = solution.kthPalindrome(queries, intLength);
            for (long x : ans) System.out.print(x + " ");
            System.out.println();
        }

        sc.close();
    }
}
