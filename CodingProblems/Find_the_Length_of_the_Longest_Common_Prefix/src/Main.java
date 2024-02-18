import java.util.Scanner;

class Solution {
    private static class TrieNode {
        TrieNode[] children;

        TrieNode() {
            children = new TrieNode[10];

            for (int i = 0; i < 10; ++i) {
                children[i] = null;
            }
        }
    }

    private TrieNode root;

    private void insertIntoTrie(int num) {
        String numString = String.valueOf(num);
        TrieNode pCrawl = root;

        for (char ch : numString.toCharArray()) {
            if (pCrawl.children[ch - '0'] == null) {
                pCrawl.children[ch - '0'] = new TrieNode();
            }
            pCrawl = pCrawl.children[ch - '0'];
        }
    }

    private int maxPrefixMatch(int num) {
        int result = 0;
        String numString = String.valueOf(num);
        TrieNode pCrawl = root;

        for (char ch : numString.toCharArray()) {
            if (pCrawl.children[ch - '0'] == null) {
                return result;
            }
            ++result;
            pCrawl = pCrawl.children[ch - '0'];
        }

        return result;
    }

    public int longestCommonPrefix(int[] arr1, int[] arr2) {
          root = new TrieNode();
          int answer = 0;

          for (int num : arr1) {
              insertIntoTrie(num);
          }

          for (int num : arr2) {
              answer = Math.max(answer, maxPrefixMatch(num));
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
            int[] arr1 = new int[m];
            for (int i = 0; i < m; ++i) {
                arr1[i] = sc.nextInt();
            }
            int n = sc.nextInt();
            int[] arr2 = new int[n];
            for (int i = 0; i < n; ++i) {
                arr2[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            System.out.println(solution.longestCommonPrefix(arr1, arr2));
        }

        sc.close();
    }
}
