import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<String, Integer> stringMovesMap;

    private String swap(String current, int pos1, int pos2) {
        char[] currentArray = current.toCharArray();
        char temp = currentArray[pos1];
        currentArray[pos1] = currentArray[pos2];
        currentArray[pos2] = temp;

        return new String(currentArray);
    }

    private void dfs(String current, int currentPos, int moves) {
        if (stringMovesMap.containsKey(current) && stringMovesMap.get(current) <= moves)
            return;

        stringMovesMap.put(current, moves);

        int[][] directions = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

        for (int nextPos : directions[currentPos]) {
            String next = swap(current, currentPos, nextPos);
            dfs(next, nextPos, moves + 1);
        }
    }

    public int slidingPuzzle(int[][] board) {
        StringBuilder startingString = new StringBuilder();
        stringMovesMap = new HashMap<>();

        for (int[] row : board) {
            for (int val : row) {
                startingString.append(val);
            }
        }

        dfs(startingString.toString(), startingString.indexOf("0"), 0);

        return stringMovesMap.getOrDefault("123450", -1);
    }
}

public class Main {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           int[][] board = new int[2][3];
           for (int[] row : board) {
               for (int i = 0; i < row.length; ++i) {
                   row[i] = scanner.nextInt();
               }
           }

           System.out.println(new Solution().slidingPuzzle(board));
       }
       
       scanner.close();
   }
}
