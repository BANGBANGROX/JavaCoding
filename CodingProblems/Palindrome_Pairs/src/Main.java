import java.util.*;

class Solution {
    private boolean isPalindrome(String word) {
        int l = 0;
        int r = word.length() - 1;

        while (l < r) {
            if (word.charAt(l) != word.charAt(r)) return false;
            ++l;
            --r;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
      List<List<Integer>> ans = new ArrayList<>();
      Map<String, Integer> indices = new HashMap<>();
      int n = words.length;

      for (int i = 0; i < n; ++i) {
          indices.put(words[i], i);
      }

      // Empty string case
      if (indices.containsKey("")) {
          int index = indices.get("");
          for (int i = 0; i < n; ++i) {
              if (index == i || !isPalindrome(words[i])) continue;
              ans.add(Arrays.asList(index, i));
              ans.add(Arrays.asList(i, index));
          }
      }

      // Mirror strings like "abc" and "cba"
      for (int i = 0; i < n; ++i) {
          String revWord = new StringBuilder(words[i]).reverse().toString();
          if (indices.containsKey(revWord)) {
              int index = indices.get(revWord);
              if (index == i) continue;
              ans.add(Arrays.asList(i, index));
          }
      }

      // Cutting case
        for (int i = 0; i < n; ++i) {
            String word = words[i];
            int m = word.length();
            for (int cut = 1; cut < m; ++cut) {
                String leftCut = word.substring(0, cut);
                String rightCut = word.substring(cut);
                if (isPalindrome(leftCut)) {
                    String reversedRight = new StringBuilder(rightCut).reverse().toString();
                    if (indices.containsKey(reversedRight)) {
                        int index = indices.get(reversedRight);
                        ans.add(Arrays.asList(index, i));
                    }
                }
                if (isPalindrome(rightCut)) {
                    String reversedLeft = new StringBuilder(leftCut).reverse().toString();
                    if (indices.containsKey(reversedLeft)) {
                        int index = indices.get(reversedLeft);
                        ans.add(Arrays.asList(i, index));
                    }
                }
            }
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
            System.out.println(solution.palindromePairs(words));
        }

        sc.close();
    }
}
