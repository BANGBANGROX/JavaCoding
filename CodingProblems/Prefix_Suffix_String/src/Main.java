//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s1 = in.readLine().trim().split(" ");
            String[] s2 = in.readLine().trim().split(" ");

            Solution ob = new Solution();
            int ans = ob.prefixSuffixString(s1, s2);
            out.println(ans);

        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution {
    private static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[26];

            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }

        public void addToTrie(String word) {
            TrieNode pCrawl = this;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (pCrawl.children[idx] == null) {
                    pCrawl.children[idx] = new TrieNode();
                }
                pCrawl = pCrawl.children[idx];
            }
        }

        public boolean searchInTrie(String word) {
            TrieNode pCrawl = this;

            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (pCrawl.children[idx] == null) return false;
                pCrawl = pCrawl.children[idx];
            }

            return pCrawl != null;
        }
    }

    public int prefixSuffixString(String[] s1, String[] s2) {
        TrieNode straightRoot = new TrieNode();
        TrieNode reverseRoot = new TrieNode();
        int answer = 0;

        for (String word : s1) {
            straightRoot.addToTrie(word);
            reverseRoot.addToTrie(new StringBuilder(word).reverse().toString());
        }

        for (String word : s2) {
            if (straightRoot.searchInTrie(word) ||
                    reverseRoot.searchInTrie(new StringBuilder(word).reverse().toString())) {
                ++answer;
            }
        }

        return answer;
    }
}