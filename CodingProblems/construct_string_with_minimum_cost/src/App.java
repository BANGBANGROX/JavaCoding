import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

class Solution {
    private int[] power;
    private int[] inversePower;
    private final int MOD = (int) 1e9 + 7;
    private final int PRIME_NUMBER = 31;
    private final int SIZE = (int) 1e5;

    Solution() {
        computePower();
        computeInversePower();
        // print(power);
        // print(inversePower);
    }

    private int calculatePower(int a, int b) {
        int result = 1;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (int) ((1L * result * a) % MOD);
                --b;
            }
            a = (int) ((1L * a * a) % MOD);
            b >>= 1;
        }

        return result;
    }

    private void computePower() {
        power = new int[SIZE];

        power[0] = 1;

        for (int i = 1; i < SIZE; ++i) {
            power[i] = (int) ((1L * power[i - 1] * PRIME_NUMBER) % MOD);
        }
    }

    private void computeInversePower() {
        inversePower = new int[SIZE];

        inversePower[0] = 1;

        for (int i = 1; i < SIZE; ++i) {
            inversePower[i] = calculatePower(power[i], MOD - 2);
        }
    }

    private int[] calculateHash(String s) {
        int n = s.length();
        int[] hash = new int[n];

        for (int i = 0; i < n; ++i) {
            int current = (int) ((1L * power[i] * (s.charAt(i) - 'a' + 1)) % MOD);
            hash[i] = ((i > 0 ? hash[i - 1] : 0) + current) % MOD;
        }

        return hash;
    }

    private int getSubstringHash(int[] hash, int left, int right) {
        int val = (hash[right] - (left > 0 ? hash[left - 1] : 0) + MOD) % MOD;

        return (int) ((1L * val * inversePower[left]) % MOD);
    }

    public int minimumCost(String target, String[] words, int[] costs) {
        int n = target.length();
        int[] dp = new int[n];
        int[] hash = calculateHash(target);
        Map<Integer, Integer> hashToMinCostMap = new HashMap<>();
        ArrayList<Integer> uniqueLengths = new ArrayList<>();

        Arrays.fill(dp, Integer.MAX_VALUE);

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            int cost = costs[i];
            int len = word.length();
            int currentWordHash = calculateHash(word)[len - 1];
            hashToMinCostMap.put(currentWordHash,
                    Math.min(hashToMinCostMap.getOrDefault(currentWordHash, Integer.MAX_VALUE), cost));
            uniqueLengths.add(len);
        }

        System.out.println(hashToMinCostMap);

        Collections.sort(uniqueLengths);

        uniqueLengths = new ArrayList<>(new HashSet<>(uniqueLengths));

        for (int i = 0; i < n; ++i) {
            for (int len : uniqueLengths) {
                if (i >= len - 1) {
                    int substringHash = getSubstringHash(hash, i - len + 1, i);
                    System.out.println(substringHash);
                    Integer minHashCost = hashToMinCostMap.get(substringHash);
                    if (minHashCost != null) {
                        int prevValue = (i >= len ? dp[i - len] : 0);
                        if (prevValue != Integer.MAX_VALUE) {
                            dp[i] = Math.min(dp[i], prevValue + minHashCost);
                        }
                    }
                }
            }
        }

        return dp[n - 1] == Integer.MAX_VALUE ? -1 : dp[n - 1];
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
