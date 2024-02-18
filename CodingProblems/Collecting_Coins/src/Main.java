//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int N;
            N = Integer.parseInt(br.readLine());


            int[][] Coins = IntMatrix.input(br, N);

            Solution obj = new Solution();
            int res = obj.collectingCoins(N, Coins);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private int findMaxResult(HashMap<Integer, Integer> count) {
        int result = 1;

        for (int x : count.keySet()) {
            result = Math.max(result, count.get(x));
        }

        return result;
    }

    public int collectingCoins(int n, int[][] coins) {
        // code here
        HashMap<Integer, Integer> countXCoordinates = new HashMap<>();
        HashMap<Integer, Integer> countYCoordinates = new HashMap<>();
        HashMap<Integer, Integer> countXYDiffCoordinates = new HashMap<>();
        HashMap<Integer, Integer> countXYSumCoordinates = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            int x = coins[i][0];
            int y = coins[i][1];
            countXCoordinates.put(x, countXCoordinates.getOrDefault(x, 0) + 1);
            countYCoordinates.put(y, countYCoordinates.getOrDefault(y, 0) + 1);
            countXYDiffCoordinates.put(y - x, countXYDiffCoordinates.getOrDefault(y - x, 0) + 1);
            countXYSumCoordinates.put(y + x, countXYSumCoordinates.getOrDefault(y + x, 0) + 1);
        }

        return Math.max(Math.max(findMaxResult(countXCoordinates), findMaxResult(countYCoordinates)),
                Math.max(findMaxResult(countXYDiffCoordinates), findMaxResult(countXYSumCoordinates)));
    }
}
        
