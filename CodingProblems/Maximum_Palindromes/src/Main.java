import java.io.*;
import java.util.stream.IntStream;

class Result {
    private static long[] factorial;
    private static long[] inverseFactorial;
    private static int[][] charactersPrefixSum;
    private static final int MOD = (int) 1e9 + 7;

    private static long modularInverse(long num) {
        int power = MOD - 2;
        long result = 1;

        while (power > 0) {
            if ((power & 1) > 0) {
                result = (result * num) % MOD;
                --power;
            }
            num = (num * num) % MOD;
            power >>= 1;
        }

        return result;
    }

    /*
     * Complete the 'initialize' function below.
     *
     * The function accepts STRING s as parameter.
     */

    public static void initialize(String s) {
        // This function is called once before all queries.
        int n = s.length();
        factorial = new long[n + 1];
        inverseFactorial = new long[n + 1];
        charactersPrefixSum = new int[n + 1][26];

        factorial[0] = inverseFactorial[0] = 1;

        for (int i = 1; i <= n; ++i) {
            factorial[i] = (i * factorial[i - 1]) % MOD;
            inverseFactorial[i] = modularInverse(factorial[i]);
            ++charactersPrefixSum[i][s.charAt(i - 1) - 'a'];
            for (int j = 0; j < 26; ++j) {
                charactersPrefixSum[i][j] += charactersPrefixSum[i - 1][j];
            }
        }
    }

    /*
     * Complete the 'answerQuery' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER l
     *  2. INTEGER r
     */

    public static int answerQuery(int l, int r) {
        // Return the answer for this query modulo 1000000007.
        long answer = 1;
        int oddCount = 0;
        int total = 0;

        for (int i = 0; i < 26; ++i) {
            int rangeCount = charactersPrefixSum[r][i] - charactersPrefixSum[l - 1][i];
            if ((rangeCount & 1) > 0) {
                ++oddCount;
            }
            int mid = rangeCount / 2;
            answer = (answer * inverseFactorial[mid]) % MOD;
            total += mid;
        }

        answer = (answer * factorial[total]) % MOD;

        if (oddCount > 0) {
            answer = (answer * oddCount) % MOD;
        }

        return (int) answer;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        Result.initialize(s);

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int l = Integer.parseInt(firstMultipleInput[0]);

                int r = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.answerQuery(l, r);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
