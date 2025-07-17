import java.util.Scanner;

class Solution {
    public int maxKPower(final int n, final int k) {
        // code here
        int num = k;
        int answer = Integer.MAX_VALUE;

        for (int i = 2; i * i <= num; ++i) {
            if (num % i == 0) {
                int cnt = 0;
                while (num % i == 0) {
                    num /= i;
                    ++cnt;
                }
                final int occurrences = countOccurrencesInFactorial(n, i);
                answer = Math.min(answer, occurrences / cnt);
            }
        }

        if (num > 1) {
            answer = Math.min(answer, countOccurrencesInFactorial(n, num));
        }

        return answer;
    }

    private int countOccurrencesInFactorial(final int n, final int val) {
        int result = 0;
        int current = val;

        while (current <= n) {
            result += (n / current);
            current = current * val;
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().maxKPower(scanner.nextInt(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
