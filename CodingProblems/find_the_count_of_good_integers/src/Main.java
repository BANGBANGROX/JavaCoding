import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
    private int k;
    private Set<String> visited;
    private long[] factorial;
    private int requiredLength;
    private boolean isOddLength;
    private long answer;

    private void init(int n) {
        factorial = new long[n + 1];

        factorial[0] = factorial[1] = 1;

        for (int i = 2; i <= n; ++i) {
            factorial[i] = factorial[i - 1] * i;
        }
    }

    private long getTotalPermutationsWithoutLeadingZeroes(String num) {
        int[] count = new int[10];
        int n = num.length();

        for (char ch : num.toCharArray()) {
            ++count[ch - '0'];
        }

        long totalPermutations = factorial[n];

        for (int i = 0; i < 10; ++i) {
            if (count[i] > 0) {
                totalPermutations /= factorial[count[i]];
            }
        }

        if (count[0] == 0) {
            return totalPermutations;
        }

        long permutationsWithLeadingZero = factorial[n - 1];
        permutationsWithLeadingZero /= factorial[count[0] - 1];

        for (int i = 1; i < 10; ++i) {
            if (count[i] > 0) {
                permutationsWithLeadingZero /= factorial[count[i]];
            }
        }

        return totalPermutations - permutationsWithLeadingZero;
    }

    private boolean isDivisibleByK(String num) {
        int result = 0;

        for (char ch : num.toCharArray()) {
            result = (result * 10 + ch - '0') % k;
        }

        return result == 0;
    }

    private void generatePalindromeNumbers(int idx, int currentNumber)
    {
        if (idx == requiredLength) {
            StringBuilder strBuilderNum = new StringBuilder(String.valueOf(currentNumber));
            int end = (isOddLength ? requiredLength - 1 : requiredLength);
            StringBuilder reverseStrBuilderNum = new StringBuilder(new StringBuilder
                    (strBuilderNum).substring(0, end)).reverse();

            strBuilderNum.append(reverseStrBuilderNum, 0, end);

            String finalNum = strBuilderNum.toString();

            if (isDivisibleByK(finalNum)) {
                char[] finalNumArray = finalNum.toCharArray();

                Arrays.sort(finalNumArray);

                String sortedFinalNum = new String(finalNumArray);

                if (!visited.contains(sortedFinalNum)) {
                    answer += getTotalPermutationsWithoutLeadingZeroes(finalNum);
                    visited.add(sortedFinalNum);
                }
            }

            return;
        }

        for (int i = (idx == 0 ? 1 : 0); i < 10; ++i) {
            generatePalindromeNumbers(idx + 1, currentNumber * 10 + i);
        }
    }

    public long countGoodIntegers(int n, int k) {
        this.k = k;
        visited = new HashSet<>();
        requiredLength = (n + 1) / 2;
        isOddLength = ((n & 1) > 0);
        answer = 0;

        init(n);
        generatePalindromeNumbers(0, 0);

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().countGoodIntegers(scanner.nextInt(),
                   scanner.nextInt()));
       }
       
       scanner.close();
   }
}
