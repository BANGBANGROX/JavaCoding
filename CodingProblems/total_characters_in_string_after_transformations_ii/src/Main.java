import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private final int MOD = (int) 1e9 + 7;
    private final int MAX_SIZE = 26;

    public int lengthAfterTransformations(final String s, final int t, final List<Integer> nums) {
        final long[][] initialFrequency = new long[1][MAX_SIZE];
        long[][] initialMatrix = new long[MAX_SIZE][MAX_SIZE];
        long answer = 0;

        for (final char ch : s.toCharArray()) {
            ++initialFrequency[0][ch - 'a'];
        }

        for (char ch = 'a'; ch <= 'z'; ++ch) {
            for (char nextCh = 'a'; nextCh <= 'z'; ++nextCh) {
                if (ch != nextCh && ((MAX_SIZE + nextCh - ch) % MAX_SIZE) <= nums.get(ch - 'a')) {
                    initialMatrix[ch - 'a'][nextCh - 'a'] = 1;
                }
            }
        }

        final long[][] exponentMatrix = matrixExponentiation(initialMatrix, t);
        final long[][] finalFrequency = multiplyMatrix(initialFrequency, exponentMatrix);

        for (final long val : finalFrequency[0]) {
            answer = (answer + val) % MOD;
        }

        return (int) answer;
    }

    private long[][] multiplyMatrix(final long[][] a, final long[][] b) {
        final int firstCols = a[0].length;
        final int firstRows = a.length;
        final int secondCols = b[0].length;
        final long[][] result = new long[firstRows][secondCols];

        for (int i = 0; i < firstRows; ++i) {
            for (int j = 0; j < secondCols; ++j) {
                result[i][j] = 0;
                for (int k = 0; k < firstCols; ++k) {
                    result[i][j] = (result[i][j] + (a[i][k] * b[k][j]) % MOD) % MOD;
                }
            }
        }

        return result;
    }

    private long[][] matrixExponentiation(long[][] matrix, int power) {
        long[][] result = new long[MAX_SIZE][MAX_SIZE];

        for (int i = 0; i < MAX_SIZE; ++i) {
            result[i][i] = 1;
        }

        while (power > 0) {
            if ((power & 1) > 0) {
                result = multiplyMatrix(result, matrix);
                --power;
            }
            matrix = multiplyMatrix(matrix, matrix);
            power >>= 1;
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final String s = scanner.next();
           final int t = scanner.nextInt();
           final List<Integer> nums = new ArrayList<>();
           for (int i = 0; i < 26; ++i) {
               nums.add(scanner.nextInt());
           }

           System.out.println(new Solution().lengthAfterTransformations(s, t, nums));
       }
       
       scanner.close();
   }
}
