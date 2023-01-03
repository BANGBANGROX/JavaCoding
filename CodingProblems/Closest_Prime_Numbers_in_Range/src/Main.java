import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Solution {
    public int[] closestPrimes(int left, int right) {
        boolean[] isPrime = new boolean[right + 1];
        ArrayList<Integer> primes = new ArrayList<>();
        int num1 = -1;
        int num2 = -1;
        int minDiff = Integer.MAX_VALUE;

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= right; ++i) {
            if (isPrime[i]) {
                if (i >= left) {
                    primes.add(i);
                }
                for (int j = 2 * i; j <= right; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 1; i < primes.size(); ++i) {
            int diff = primes.get(i) - primes.get(i - 1);
            if (diff < minDiff) {
                num1 = primes.get(i - 1);
                num2 = primes.get(i);
                minDiff = diff;
            }
        }

        return new int[] {num1, num2};
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int left = sc.nextInt();
            int right = sc.nextInt();

            Solution solution = new Solution();
            int[] ans = solution.closestPrimes(left, right);
            System.out.println(ans[0] + " " + ans[1]);
        }

        sc.close();
    }
}
