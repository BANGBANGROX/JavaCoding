import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private long[] power;
    private long[] inversePower;
    private final int MOD = (int) 1e9 + 7;
    private final int BASE = 31;

    private void computePowerAndInversePower(int maxSize) {
        power = new long[maxSize + 1];
        inversePower = new long[maxSize + 1];

        power[0] = 1;
        inversePower[0] = 1;

        for (int i = 1; i <= maxSize; ++i) {
            power[i] = (power[i - 1] * BASE) % MOD;
            inversePower[i] = calculateBinExponent(power[i], MOD - 2);
        }
    }

    private long calculateBinExponent(long a, long b) {
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

    private long[] computeHash(String s) {
        int n = s.length();
        long[] hash = new long[n];

        for (int i = 0; i < n; ++i) {
            hash[i] = (power[i] * (s.charAt(i) - 'a' + 1)) % MOD;
            if (i > 0) {
                hash[i] = (hash[i] + hash[i - 1]) % MOD;
            }
        }

        return hash;
    }

    private long getSubstringHash(int left, int right, long[] hash) {
        long hashValue = (hash[right] - (left > 0 ? hash[left - 1] : 0) + MOD) % MOD;

        return (hashValue * inversePower[left]) % MOD;
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();

        computePowerAndInversePower(n);

        long[] targetHash = computeHash(target);
        List<Integer> uniqueLengths = new ArrayList<>();
        Map<Long, Long> hashValueToCostMap = new HashMap<>();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int len = word.length();
            long wordHashValue = computeHash(word)[len - 1];
            Long hashCost = hashValueToCostMap.get(wordHashValue);
            if (hashCost == null) {
                hashValueToCostMap.put(wordHashValue, 1L * costs[i]);
            } else {
                hashValueToCostMap.put(wordHashValue, Math.min(1L * costs[i], hashCost));
            }
            uniqueLengths.add(len);
        }

        Collections.sort(uniqueLengths);

        uniqueLengths = new ArrayList<>(new HashSet<>(uniqueLengths));

        long[] dp = new long[n];

        Arrays.fill(dp, Long.MAX_VALUE);

        for (int i = 0; i < n; ++i) {
            for (int len : uniqueLengths) {
                if (i - len + 1 >= 0) {
                    long substringHash = getSubstringHash(i - len + 1, i, targetHash);
                    Long minCost = hashValueToCostMap.get(substringHash);
                    if (minCost != null) {
                        long previousValue = (i >= len ? dp[i - len] : 0);
                        if (previousValue != Long.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], previousValue + minCost);
                        }
                    }
                }
            }
        }

        return dp[n - 1] == Long.MAX_VALUE ? -1 : (int) dp[n - 1];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        while (testCases-- > 0) {
            String target = scanner.next();
            int totalWords = scanner.nextInt();
            String[] words = new String[totalWords];
            for (int i = 0; i < totalWords; ++i) {
                words[i] = scanner.next();
            }
            int[] costs = new int[totalWords];
            for (int i = 0; i < totalWords; ++i) {
                costs[i] = scanner.nextInt();
            }

            System.out.println(new Solution().minimumCost(target, words, costs));
        }

        scanner.close();
    }
}
