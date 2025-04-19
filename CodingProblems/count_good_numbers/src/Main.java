import java.util.Scanner;

class Solution {
    private final int MOD = (int) 1e9 + 7;

    private long binaryExponentiation(long a, long b) {
        long result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }

    public int countGoodNumbers(long n) {
        long mid = ((n + 1) >> 1);
        long answer = binaryExponentiation(5, mid);

        if ((n & 1) > 0) {
            --mid;
        }

        answer = (answer * binaryExponentiation(4, mid)) % MOD;

        return (int) answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countGoodNumbers(scanner.nextLong()));
       }
       
       scanner.close();
   }
}
