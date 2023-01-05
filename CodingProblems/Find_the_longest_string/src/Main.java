//{ Driver Code Starts
import java.io.*;


class StringArray {
    public static String[] input(BufferedReader br) throws IOException {
        return br.readLine().trim().split(" ");
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {


            String[] arr = StringArray.input(br);

            Solution obj = new Solution();
            String res = obj.longestString(arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private static class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }

    private TrieNode root;

    private void insert(String s) {
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

    public String longestString(String[] strs) {
        // code here
        root = new TrieNode();
        StringBuilder ans = new StringBuilder();

        for (String s : strs) {
            insert(s);
        }

        for (String s : strs) {
            TrieNode pCrawl = root;
            StringBuilder currentResult = new StringBuilder();
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                if (!pCrawl.children[idx].isEnd) break;
                currentResult.append(ch);
                pCrawl = pCrawl.children[idx];
            }
            if (currentResult.length() > ans.length()) {
                ans = currentResult;
            }
            else if (currentResult.length() == ans.length() && ans.compareTo(currentResult) > 0) {
                ans = currentResult;
            }
        }

        return ans.toString();
    }
}

