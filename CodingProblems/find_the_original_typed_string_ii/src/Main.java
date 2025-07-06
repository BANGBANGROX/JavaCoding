import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public int possibleStringCount(final String word, final int k) {
        final List<Integer> runLengths = new ArrayList<>();
        final int mod = (int) 1e9 + 7;
        long totalCount = 1;
        long[] prefixSum = new long[k];
        long[] count = new long[k];
        char lastChar = '#';
        int currentLength = 0;

        for (final char ch : word.toCharArray()) {
            if (ch == lastChar) {
                ++currentLength;
            } else {
                if (currentLength > 0) {
                    runLengths.add(currentLength);
                }
                lastChar = ch;
                currentLength = 1;
            }
        }

        if (currentLength > 0) {
            runLengths.add(currentLength);
        }

        for (final int len : runLengths) {
            totalCount = (totalCount * len) % mod;
        }

        if (runLengths.size() >= k) {
            return (int) totalCount;
        }

        int maxLength = runLengths.getFirst();

        for (int i = 1; i < Math.min(maxLength + 1, k); ++i) {
            count[i] = 1;
        }

        for (int i = 1; i < k; ++i) {
            prefixSum[i] = (prefixSum[i - 1] + count[i]) % mod;
        }

        for (int i = 2; i <= runLengths.size(); ++i) {
            final int runLength = runLengths.get(i - 1);
            count = new long[k];

            maxLength += runLength;

            for (int j = i; j < Math.min(maxLength + 1, k); ++j) {
                count[j] = (prefixSum[j - 1] - (j - runLength - 1 >= 0 ? prefixSum[j - runLength - 1] : 0)
                        + mod) % mod;
            }
            for (int j = 1; j < k; ++j) {
                prefixSum[j] = (prefixSum[j - 1] + count[j]) % mod;
            }
        }

        return (int) ((totalCount - prefixSum[k - 1] + mod) % mod);
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().possibleStringCount(scanner.next(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
