import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private HashMap<DpKey, Integer> dp;
    private String[] words;
    private int[] score;

    private static class DpKey {
        int idx;
        HashMap<Character, Integer> count;

        DpKey(int idx, HashMap<Character, Integer> count) {
            this.idx = idx;
            this.count = count;
        }
    }

    private int calculateScore(String word) {
        int result = 0;

        for (char ch : word.toCharArray()) {
            result += score[ch - 'a'];
        }

        return result;
    }

    private int maxScoreWordsHandler(int idx, HashMap<Character, Integer> count) {
        if (idx >= words.length) return 0;

        DpKey dpKey = new DpKey(idx, count);

        if (dp.containsKey(dpKey)) return dp.get(dpKey);

        int result = maxScoreWordsHandler(idx + 1, count);
        HashMap<Character, Integer> currentCount = new HashMap<>();

        for (char ch : words[idx].toCharArray()) {
            currentCount.put(ch, currentCount.getOrDefault(ch, 0) + 1);
        }

        boolean canTake = true;
        HashMap<Character, Integer> nextCount = new HashMap<>(count);

        for (Map.Entry<Character, Integer> entry : currentCount.entrySet()) {
            char ch = entry.getKey();
            int cnt = entry.getValue();
            if (cnt > count.getOrDefault(ch, 0)) {
                canTake = false;
                break;
            }
            nextCount.put(ch, count.get(ch) - cnt);
        }

        if (canTake) {
            result = Math.max(result, maxScoreWordsHandler(idx + 1, nextCount) + calculateScore(words[idx]));
        }

        dp.put(dpKey, result);

        return result;
    }

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        dp = new HashMap<>();
        this.score = score;
        this.words = words;
        HashMap<Character, Integer> count = new HashMap<>();

        for (char ch : letters) {
            count.put(ch, count.getOrDefault(ch, 0) + 1);
        }

        return maxScoreWordsHandler(0, count);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] words = new String[n];
            for (int i = 0; i < n; ++i) {
                words[i] = sc.next();
            }
            int lettersCount = sc.nextInt();
            char[] letters = new char[lettersCount];
            for (int i = 0; i < lettersCount; ++i) {
                letters[i] = sc.next().charAt(0);
            }
            int[] score = new int[26];
            for (int i = 0; i < 26; ++i) {
                score[i] = sc.nextInt();
            }

            System.out.println(new Solution().maxScoreWords(words, letters, score));
        }

        sc.close();
    }
}
