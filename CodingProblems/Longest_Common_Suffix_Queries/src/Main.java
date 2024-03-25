import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static class TrieNode {
        int index;
        TrieNode[] children;

        TrieNode(int index) {
            this.index = index;
            children = new TrieNode[26];
        }
    }

    private static class IndexedString {
        String s;
        int index;

        IndexedString(String s, int index) {
            this.s = s;
            this.index = index;
        }
    }

    private TrieNode root;

    private void insertIntoTrie(String s, int index) {
        TrieNode pCrawl = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode(index);
            }
            pCrawl = pCrawl.children[idx];
        }
    }

    private int getMatchingIndex(String s) {
        TrieNode pCrawl = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) return pCrawl.index;
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.index;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {
        int m = wordsContainer.length;
        int n = wordsQuery.length;
        int[] answer = new int[n];
        IndexedString[] indexedStrings = new IndexedString[m];

        for (int i = 0; i < m; ++i) {
            indexedStrings[i] = new IndexedString(wordsContainer[i], i);
        }

        Arrays.sort(indexedStrings, (a, b) -> a.s.length() != b.s.length() ? a.s.length() - b.s.length() : a.index - b.index);

        root = new TrieNode(indexedStrings[0].index);

        for (IndexedString indexedString : indexedStrings) {
            insertIntoTrie(new StringBuilder(indexedString.s).reverse().toString(), indexedString.index);
        }

        for (int i = 0; i < n; ++i) {
            answer[i] = getMatchingIndex(new StringBuilder(wordsQuery[i]).reverse().toString());
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            String[] wordContainer = new String[m];
            for (int i = 0; i < m; ++i) {
                wordContainer[i] = sc.next();
            }
            int n = sc.nextInt();
            String[] wordQuery = new String[n];
            for (int i = 0; i < n; ++i) {
                wordQuery[i] = sc.next();
            }

            Solution solution = new Solution();
            int[] answer = solution.stringIndices(wordContainer, wordQuery);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
