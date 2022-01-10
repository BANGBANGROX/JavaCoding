import java.util.*;

class Solution {
    private HashMap<String, Integer> hm = new HashMap<>();
    private List<String> ans = new ArrayList<>();

    private void wordBreakUtil(String s, String curr, int index) {
        if (index == s.length()) {
            ans.add(curr);
            return;
        }

        curr += " ";

        for (int i = index; i < s.length(); ++i) {
            if (hm.containsKey(s.substring(index, i + 1))) {
                wordBreakUtil(s, curr + s.substring(index, i + 1), i + 1);
            }
        }
    }

    public List<String> wordBreak(String s, List<String> wordDict) {
          int n = wordDict.size();
          int len = s.length();

          for (int i = 0; i < n; ++i) {
              hm.put(wordDict.get(i), 1);
          }

          for (int i = 0; i < len; ++i) {
              if (hm.containsKey(s.substring(0, i + 1))) {
                  wordBreakUtil(s, s.substring(0, i + 1), i + 1);
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
            String s = sc.next();
            int n = sc.nextInt();
            List<String> wordDict = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                String str = sc.next();
                wordDict.add(str);
            }

            Solution obj = new Solution();
            System.out.println(obj.wordBreak(s, wordDict));
        }

        sc.close();
    }
}
