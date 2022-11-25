//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());
            String[] contact = in.readLine().trim().split("\\s+");
            String s = in.readLine();

            Solution ob = new Solution();
            ArrayList<ArrayList<String>> ans = ob.displayContacts(n, contact, s);
            for (ArrayList<String> an : ans) {
                for (String value : an) System.out.print(value + " ");
                System.out.println();
            }
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class TrieNode {
        ArrayList<Integer> indexes;
        TrieNode[] children;

        TrieNode() {
            indexes = new ArrayList<>();
            children = new TrieNode[26];

            for (int i = 0; i < 26; ++i) {
                children[i] = null;
            }
        }
    }

    private TrieNode root;

    private void add(String s, int i) {
        TrieNode pCrawl = root;

        for (char ch : s.toCharArray()) {
            int idx = ch - 'a';
            if (pCrawl.children[idx] == null) {
                pCrawl.children[idx] = new TrieNode();
            }
            pCrawl.children[idx].indexes.add(i);
            pCrawl = pCrawl.children[idx];
        }
    }

    public ArrayList<ArrayList<String>> displayContacts(int n,
                                                        String[] contact, String prefix) {
        // code here
        root = new TrieNode();
        ArrayList<ArrayList<String>> ans = new ArrayList<>();

        Arrays.sort(contact);

        for (int i = 0; i < n; ++i) {
            add(contact[i], i);
        }

        int len = prefix.length();

        for (char ch : prefix.toCharArray()) {
            int idx = ch - 'a';
            if (root.children[idx] == null) break;
            root = root.children[idx];
            LinkedHashSet<String> current = new LinkedHashSet<>();
            for (int j : root.indexes) {
                current.add(contact[j]);
            }
            ans.add(new ArrayList<>(current));
        }

        while (ans.size() < len) {
            ans.add(new ArrayList<>(List.of("0")));
        }

        return ans;
    }
}