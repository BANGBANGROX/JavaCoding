// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);

            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class TrieNode {
        public TrieNode[] children = new TrieNode[26];
        int frequency;
        int index;

        public TrieNode() {
            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
            frequency = 1;
            index = -1;
        }
    }

    TrieNode root;
    String[] ans;

    private void insert(String word, int ind) {
        TrieNode pCrawl = root;

        for (char ch : word.toCharArray()) {
            int i = ch - 'a';
            if (pCrawl.children[i] == null) {
                pCrawl.children[i] = new TrieNode();
            }
            else {
                ++pCrawl.children[i].frequency;
            }
            pCrawl.children[i].index = ind;
            pCrawl = pCrawl.children[i];
        }
    }

    private void findPrefixesUtil(TrieNode rootNode, String current) {
        if (rootNode == null) return;

        if (rootNode.frequency == 1) {
            ans[rootNode.index] = current;
            return;
        }

       for (char ch = 'a'; ch <= 'z'; ++ch) {
           if (rootNode.children[ch - 'a'] != null) {
               findPrefixesUtil(rootNode.children[ch - 'a'],current + ch);
           }
       }
    }

    public String[] findPrefixes(String[] arr, int n) {
        // code here
        String current = "";

        root = new TrieNode();
        ans = new String[n];

        root.frequency = 0;

        for (int i = 0; i < n; ++i) {
            insert(arr[i], i);
        }

        findPrefixesUtil(root, current);

        return ans;
    }
};