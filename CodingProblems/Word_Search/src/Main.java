//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int n = Integer.parseInt(S[0]);
            int m = Integer.parseInt(S[1]);
            char [][] board = new char[n][m];
            for(int i = 0; i < n; i++){
                String[] s = br.readLine().trim().split(" ");
                for(int j = 0; j < m; j++){
                    board[i][j] = s[j].charAt(0);
                }
            }
            String word = br.readLine().trim();
            Solution obj = new Solution();
            boolean ans = obj.isWordExist(board, word);
            if(ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    private boolean search(char[][] board, int x, int y, int index, String word) {
         int m = board.length;
         int n = board[0].length;

         if (index == word.length()) return true;

         if (x < 0 || y < 0 || x >= m || y >= n || board[x][y] != word.charAt(index)) return false;

         char currentChar = board[x][y];

         board[x][y] = '#';

         boolean ans =  search(board, x + 1, y, index + 1, word) || search(board, x, y + 1, index + 1, word)
                 || search(board, x - 1, y, index + 1, word) ||
                 search(board, x, y - 1, index + 1, word);

         board[x][y] = currentChar;

         return ans;
    }

    public boolean isWordExist(char[][] board, String word) {
        // Code here
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (word.charAt(0) == board[i][j]) {
                    if (search(board, i, j, 0, word)) return true;
                }
            }
        }

        return false;
    }
}