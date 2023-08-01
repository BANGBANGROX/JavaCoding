// https://www.hackerrank.com/challenges/bear-and-steady-gene/problem

import java.io.*;

class Result {
    private static int getIndex(char ch) {
        if (ch == 'A') return 0;

        if (ch == 'C') return 1;

        if (ch == 'G') return 2;

        return 3;
    }

    private static boolean isSteady(int[] count, int limit) {
        return count[0] == limit && count[1] == limit &&
                count[2] == limit && count[3] == limit;
    }

    private static boolean canBeSteady(int[] count, int limit) {
        return count[0] <= limit && count[1] <= limit &&
                count[2] <= limit && count[3] <= limit;
    }

    /*
     * Complete the 'steadyGene' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING gene as parameter.
     */

    public static int steadyGene(String gene) {
        // Write your code here
        final int n = gene.length();
        int l = 0;
        int answer = n;
        int limit = n / 4;
        int[] count = new int[4];

        for (char ch : gene.toCharArray()) {
            ++count[getIndex(ch)];
        }

        if (isSteady(count, limit)) {
            return 0;
        }

        if (canBeSteady(count, limit)) {
            return n;
        }

        for (int r = 0; r < n; ++r) {
            --count[getIndex(gene.charAt(r))];
            while (canBeSteady(count, limit)) {
                answer = Math.min(answer, r - l + 1);
                ++count[getIndex(gene.charAt(l))];
                ++l;
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String gene = bufferedReader.readLine();

        int result = Result.steadyGene(gene);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
