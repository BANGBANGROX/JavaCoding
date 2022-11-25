//{ Driver Code Starts
//Initial Template for Java

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            String[] dictionary = new String[N];
            for (int i = 0; i < N; i++) {
                dictionary[i] = sc.next();
            }

            int R = Integer.parseInt(sc.next());
            int C = Integer.parseInt(sc.next());

            char[][] board = new char[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    board[i][j] = sc.next().charAt(0);
                }
            }

            Solution obj = new Solution();
            String[] ans = obj.wordBoggle(board, dictionary);

            if (ans.length == 0) System.out.println("-1");
            else {
                Arrays.sort(ans);
                for (String an : ans) {
                    System.out.print(an + " ");
                }
                System.out.println();
            }

            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean dfs(String s, int index, int x, int y, char[][] board) {
        if (index == s.length()) return true;

        int m = board.length;
        int n = board[0].length;

        if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != s.charAt(index)) return false;

        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        boolean ans = false;

        board[x][y] = '#';

        for (int i = 0; i < 8; ++i) {
            int newX = x + dx[i];
            int newY = y + dy[i];
            ans = dfs(s, index + 1, newX, newY, board);
            if (ans) break;
        }

        board[x][y] = s.charAt(index);

        return ans;
    }

    private boolean search(String s, char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (board[i][j] == s.charAt(0)) {
                    if (dfs(s, 0, i, j, board)) return true;
                }
            }
        }

        return false;
    }

    public String[] wordBoggle(char[][] board, String[] dictionary) {
        // Write your code here
        ArrayList<String> ans = new ArrayList<>();
        LinkedHashSet<String> newDictionary = new LinkedHashSet<>(Arrays.asList(dictionary));

        for (String s : newDictionary) {
            if (search(s, board)) {
                ans.add(s);
            }
        }

        return ans.toArray(new String[0]);
    }
}