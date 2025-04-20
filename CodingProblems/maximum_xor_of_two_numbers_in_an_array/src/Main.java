//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String s = br.readLine();
            String[] S = s.split(" ");
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(S[i]);
            }
            Solution ob = new Solution();
            System.out.println(ob.maxXor(arr));

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private static class TrieNode {
        final TrieNode[] children;

        TrieNode() {
            children = new TrieNode[2];
        }
    }

    private TrieNode root;

    public int maxXor(final int[] nums) {
        // code here
        root = new TrieNode();
        int answer = 0;

        for (final int num : nums) {
            insert(num);
        }

        for (final int num : nums) {
            answer = Math.max(answer, getMaxResult(num));
        }

        return answer;
    }

    private void insert(final int num) {
        TrieNode pCrawl = root;

        for (int bit = 20; bit >= 0; --bit) {
            int idx = (num & (1 << bit)) > 0 ? 1 : 0;
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl = pCrawl.children[idx];
        }
    }

    private int getMaxResult(final int num) {
        int result = 0;
        TrieNode pCrawl = root;

        for (int bit = 20; bit >= 0; --bit) {
            final int idx = (num & (1 << bit)) > 0 ? 1 : 0;
            final int requiredIdx = 1 - idx;
            if (pCrawl.children[requiredIdx] != null) {
                result |= (1 << bit);
                pCrawl = pCrawl.children[requiredIdx];
            } else {
                pCrawl = pCrawl.children[idx];
            }
        }

        return result;
    }
}