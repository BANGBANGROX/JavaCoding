import java.util.Scanner;

class Solution {
    private static class TrieNode {
        TrieNode[] children;
        int cnt;

        TrieNode() {
            cnt = 0;
            children = new TrieNode[26];

            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private final TrieNode root = new TrieNode();

    private void insert(String s) {
        TrieNode pCrawl = root;

        for (char ch: s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            ++pCrawl.children[idx].cnt;
            pCrawl = pCrawl.children[idx];
        }
    }

    public int[] sumPrefixScores(String[] words) {
        int n = words.length;
        int[] ans = new int[n];

        for (String word: words) {
            insert(word);
        }

        for (int i = 0; i < n; ++i) {
            TrieNode pCrawl = root;
            for (char ch: words[i].toCharArray()) {
                if (pCrawl.children[ch - 'a'] == null) break;
                ans[i] += pCrawl.children[ch - 'a'].cnt;
                pCrawl = pCrawl.children[ch - 'a'];
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
            int[] ans = solution.sumPrefixScores(words);
            for (int x: ans) {
                System.out.println(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
