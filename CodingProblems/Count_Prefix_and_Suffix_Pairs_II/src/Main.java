import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    private static class TrieNode {
        HashMap<ArrayList<Character>, TrieNode> children;
        int cnt;

        TrieNode() {
            children = new HashMap<>();
            cnt = 0;
        }
    }

    public long countPrefixSuffixPairs(String[] words) {
         TrieNode root = new TrieNode();
         long answer = 0;

         for (String word : words) {
             TrieNode pCrawl = root;
             int len = word.length();
             for (int i = 0; i < len; ++i) {
                 ArrayList<Character> firstAndLastChar = new ArrayList<>(Arrays.asList(word.charAt(i), word.charAt(len - i - 1)));
                 if (!pCrawl.children.containsKey(firstAndLastChar)) {
                     pCrawl.children.put(firstAndLastChar, new TrieNode());
                 }
                 pCrawl = pCrawl.children.get(firstAndLastChar);
                 answer += pCrawl.cnt;
             }
             ++pCrawl.cnt;
         }

         return answer;
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
            System.out.println(solution.countPrefixSuffixPairs(words));
        }

        sc.close();
    }
}
