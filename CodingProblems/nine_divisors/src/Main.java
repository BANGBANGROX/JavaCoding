import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

class Solution {
    public static int countNumbers(final int n) {
        // code here
        final int maxValue = (int) Math.sqrt(n);
        final boolean[] isPrime = new boolean[maxValue + 1];
        final List<Integer> primes = new ArrayList<>();
        int answer = 0;

        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= maxValue; ++i) {
            if (isPrime[i]) {
                primes.add(i);

                for (int j = 2 * i; j <= maxValue; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (final int prime : primes) {
            if ((long) Math.pow(prime, 8) <= n) {
                ++answer;
            } else {
                break;
            }
        }

        for (int i = 0; i < primes.size() - 1; ++i) {
            for (int j = i + 1; j < primes.size(); ++j) {
                if ((long) primes.get(i) * primes.get(j) <= maxValue) {
                    ++answer;
                } else {
                    break;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(Solution.countNumbers(scanner.nextInt()));
       }
       
       scanner.close();
   }
}
