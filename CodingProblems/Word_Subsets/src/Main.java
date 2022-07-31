import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
          List<String> ans = new ArrayList<>();
          int[] maxCount = new int[26];

          for (String word : words2) {
              int[] currentCount = new int[26];
              for (char ch : word.toCharArray()) {
                  ++currentCount[ch - 'a'];
              }
              for (int i = 0; i < 26; ++i) {
                  maxCount[i] = Math.max(maxCount[i], currentCount[i]);
              }
          }

          for (String word : words1) {
              int[] currentCount = new int[26];
              boolean possible = true;
              for (char ch : word.toCharArray()) {
                  ++currentCount[ch - 'a'];
              }
              for (int i = 0; i < 26; ++i) {
                  if (maxCount[i] > currentCount[i]) {
                      possible = false;
                      break;
                  }
              }
              if (possible) ans.add(word);
          }

          return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] words1 = new String[m];
            for (int i = 0; i < m; ++i) {
                words1[i] = sc.next();
            }
            int n = sc.nextInt();
            String[] words2 = new String[n];
            for (int i = 0; i < n; ++i) {
                words2[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.wordSubsets(words1, words2));
        }

        sc.close();
    }
}
