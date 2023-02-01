import java.util.*;

class Solution {
    private HashSet<String> dictionary;

    private boolean wordBreak(String word) {
        int n = word.length();
        boolean[] dp = new boolean[n + 1];

        dp[0] = true;

        for (int len = 1; len <= n; ++len) {
            for (int i = (len == n ? 1 : 0); i < len; ++i) {
                dp[len] = dp[i] && dictionary.contains(word.substring(i, len));
                if (dp[len]) break;
            }
        }

        return dp[n];
    }

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        List<String> ans = new ArrayList<>();
        dictionary = new HashSet<>(Arrays.asList(words));

        for (String word : words) {
            if (wordBreak(word)) ans.add(word);
        }

        return ans;
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

            Solution solution = new Solution();
            System.out.println(solution.findAllConcatenatedWordsInADict(words));
        }

        sc.close();
    }
}
