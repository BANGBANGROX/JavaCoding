import java.util.*;

class Solution {
    private static class TrieNode {
        int index;
        TrieNode[] children = new TrieNode[26];

        TrieNode() {
            index = -1;
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private final TrieNode root = new TrieNode();

    private void insert(String s, int i) {
        TrieNode pCrawl = root;

        for (char ch: s.toCharArray()) {
            if (pCrawl.children[ch - 'a'] == null)
                pCrawl.children[ch - 'a'] = new TrieNode();
            pCrawl = pCrawl.children[ch - 'a'];
        }

        pCrawl.index = i;
    }

    private int search(String s) {
        TrieNode pCrawl = root;

        for (char ch: s.toCharArray()) {
            if (pCrawl.children[ch - 'a'] == null) return -1;
            pCrawl = pCrawl.children[ch - 'a'];
        }

        return pCrawl.index;
    }

    private boolean isPalindrome(String s) {
        int n = s.length();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            ++l;
            --r;
        }

        return true;
    }

    public List<List<Integer>> palindromePairs(String[] words) {
         List<List<Integer>> ans = new ArrayList<>();
         HashSet<List<Integer>> visited = new HashSet<>();
         int n = words.length;

         for (int i = 0; i < n; ++i) {
             StringBuilder revWord = new StringBuilder(words[i]);
             revWord.reverse();
             insert(revWord.toString(), i);
         }

         for (int i = 0; i < n; ++i) {
             String word = words[i];
             int m = word.length();
             for (int j = 0; j <= m; ++j) {
                 if (isPalindrome(word.substring(0, j))) {
                     int index = search(word.substring(j));
                     ArrayList<Integer> res = new ArrayList<>(Arrays.asList(index, i));
                     if (index != -1 && index != i && !visited.contains(res))
                         ans.add(new ArrayList<>(res));
                     visited.add(res);
                 }
                 if (isPalindrome(word.substring(j))) {
                     int index = search(word.substring(0, j));
                     ArrayList<Integer> res = new ArrayList<>(Arrays.asList(i, index));
                     if (index != -1 && index != i)
                         ans.add(new ArrayList<>(res));
                     visited.add(res);
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
