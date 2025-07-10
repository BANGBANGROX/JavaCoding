import java.util.Scanner;

class Solution {
    private static class TrieNode {
        private final TrieNode[] children;
        private boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }

        public void add(final String s) {
            TrieNode trieNode = this;

            for (final char ch : s.toCharArray()) {
                final int idx = ch - 'a';
                if (trieNode.children[idx] == null) {
                    trieNode.children[idx] = new TrieNode();
                }
                trieNode = trieNode.children[idx];
            }

            trieNode.isEnd = true;
        }

        public boolean check(final String s) {
            TrieNode trieNode = this;

            for (final char ch : s.toCharArray()) {
                final int idx = ch - 'a';
                if (trieNode.children[idx] == null || !trieNode.children[idx].isEnd) {
                    return false;
                }
                trieNode = trieNode.children[idx];
            }

            return true;
        }
    }

    public String longestString(final String[] words) {
        // code here
        final TrieNode trieNode = new TrieNode();
        String answer = "";

        for (final String word : words) {
            trieNode.add(word);
        }

        for (final String word : words) {
            if (trieNode.check(word)) {
                if (answer.length() < word.length()) {
                    answer = word;
                } else if (answer.length() == word.length() && answer.compareTo(word) > 0) {
                    answer = word;
                }
            }
        }

        return answer;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int n = scanner.nextInt();
           final String[] words = new String[n];
           for (int i = 0; i < n; ++i) {
               words[i] = scanner.next();
           }

           System.out.println(new Solution().longestString(words));
       }
       
       scanner.close();
   }
}
