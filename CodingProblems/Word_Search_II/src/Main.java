import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    private static class TrieNode {
        TrieNode[] children;
        String word;

        TrieNode() {
            children = new TrieNode[26];
            word = null;
        }
    }

    private final List<String> ans = new ArrayList<>();

    private void dfs(int x, int y, char[][] board, TrieNode pCrawl) {
        int m = board.length;
        int n = board[0].length;

        if (pCrawl.word != null) {
            ans.add(pCrawl.word);
            pCrawl.word = null;
        }

        if (x < 0 || y < 0 || x >= m || y >= n ||
                board[x][y] == '#' || pCrawl.children[board[x][y] - 'a'] == null)
            return;

        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        char ch = board[x][y];

        board[x][y] = '#';

        for (int i = 0; i < 4; ++i) {
            dfs(x + dx[i], y + dy[i], board, pCrawl.children[ch - 'a']);
        }

        board[x][y] = ch;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String s : words) {
            TrieNode pCrawl = root;
            for (char ch : s.toCharArray()) {
                int idx = ch - 'a';
                if (pCrawl.children[idx] == null) {
                    pCrawl.children[idx] = new TrieNode();
                }
                pCrawl = pCrawl.children[idx];
            }
            pCrawl.word = s;
        }

        return root;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(i, j, board, root);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            char[][] boards = new char[m][n];
            for (int i = 0; i < m; ++i) {
                for (int j = 0; j < n; ++j) {
                    boards[i][j] = sc.next().charAt(0);
                }
            }
            int len = sc.nextInt();
            String[] words = new String[len];
            for (int i = 0; i < len; ++i) {
                words[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.findWords(boards, words));
        }

        sc.close();
    }
}
