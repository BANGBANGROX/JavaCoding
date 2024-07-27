import java.util.Scanner;

class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        final int TOTAL_CHARS = 26;
        long[][] distance = new long[TOTAL_CHARS][TOTAL_CHARS];
        int availableChars = original.length;
        int n = source.length();
        long answer = 0;

        for (int i = 0; i < TOTAL_CHARS; ++i) {
            for (int j = 0; j < TOTAL_CHARS; ++j) {
                if (i != j) {
                    distance[i][j] = Long.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < availableChars; ++i) {
            distance[original[i] - 'a'][changed[i] - 'a'] = Math.min(distance[original[i] - 'a'][changed[i] - 'a'], cost[i]);
        }

        for (int k = 0; k < TOTAL_CHARS; ++k) {
            for (int i = 0; i < TOTAL_CHARS; ++i) {
                for (int j = 0; j < TOTAL_CHARS; ++j) {
                    if (distance[i][k] != Long.MAX_VALUE && distance[k][j] != Long.MAX_VALUE) {
                        distance[i][j] = Math.min(distance[i][j], distance[i][k] + distance[k][j]);
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            if (distance[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Long.MAX_VALUE) return -1;
            answer += distance[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
        }

        return answer;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            String source = scanner.next();
            String target = scanner.next();
            int availableChars = scanner.nextInt();
            char[] original = new char[availableChars];
            for (int i = 0; i < availableChars; ++i) {
                original[i] = scanner.next().charAt(0);
            }
            char[] changed = new char[availableChars];
            for (int i = 0; i < availableChars; ++i) {
                changed[i] = scanner.next().charAt(0);
            }
            int[] cost = new int[availableChars];
            for (int i = 0; i < availableChars; ++i) {
                cost[i] = scanner.nextInt();
            }

            System.out.println(new Solution().minimumCost(source, target, original, changed, cost));
        }

        scanner.close();
    }
}
