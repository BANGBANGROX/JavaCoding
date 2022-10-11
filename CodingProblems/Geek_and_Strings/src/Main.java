//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(in.readLine());
            String[] li = new String[N];
            for (int i = 0; i < N; i++)
                li[i] = in.readLine();
            int Q = Integer.parseInt(in.readLine());
            String[] query = new String[Q];
            for (int i = 0; i < Q; i++)
                query[i] = in.readLine();

            Solution ob = new Solution();
            List<Integer> ans;
            ans = ob.prefixCount(li, query);
            for (Integer an : ans) System.out.println(an);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class TrieNode {
        int cnt;
        TrieNode[] children;

        TrieNode() {
            cnt = 0;
            children = new TrieNode[26];
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private final TrieNode root = new TrieNode();

    private void addToTrie(String s) {
        TrieNode pCrawl = root;

        for (char ch: s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) pCrawl.children[idx] = new TrieNode();
            ++pCrawl.children[idx].cnt;
            pCrawl = pCrawl.children[idx];
        }
    }

    private int queryTrie(String s) {
        TrieNode pCrawl = root;

        for (char ch: s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) return 0;
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl.cnt;
    }

    public List<Integer> prefixCount(String[] li, String[] query) {
        // code here
        List<Integer> ans = new ArrayList<>();

        for (String s: li) {
            addToTrie(s);
        }

        for (String s: query) {
            ans.add(queryTrie(s));
        }

        return ans;
    }
}