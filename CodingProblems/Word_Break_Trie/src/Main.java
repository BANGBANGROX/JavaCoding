//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n;
            n = sc.nextInt();
            ArrayList<String> arr = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                String p = sc.next();
                arr.add(p);
            }
            String line = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.wordBreak(line, arr));

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];

            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private TrieNode root;

    private void add(String s) {
        TrieNode pCrawl = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }

        pCrawl.isEnd = true;
    }

    private boolean search(TrieNode pCrawl, String s, int index) {
        if (pCrawl == null) return false;

        if (index == s.length()) return pCrawl.isEnd;

        for (int i = index; i < s.length(); ++i) {
            if (pCrawl == null) return false;
            int idx = s.charAt(i) - 'a';
            if (pCrawl.isEnd) {
                if (pCrawl.children[idx] != null) {
                    return search(pCrawl.children[idx], s, i + 1) ||
                            search(root.children[idx], s, i + 1);
                }
                return search(root.children[idx], s, i + 1);
            }
            pCrawl = pCrawl.children[idx];
        }

        return pCrawl != null && pCrawl.isEnd;
    }

    public int wordBreak(String s, ArrayList<String> dict) {
        //code here
        root = new TrieNode();

        for (String word : dict) {
            add(word);
        }

        if (search(root, s, 0)) return 1;

        return 0;
    }
}