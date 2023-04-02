// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class Main{
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String args[]) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int a[][] = new int[n][3];
            for(int i = 0; i < n; i++){
                s = br.readLine().trim().split(" ");
                a[i][0] = Integer.parseInt(s[0]);
                a[i][1] = Integer.parseInt(s[1]);
                a[i][2] = Integer.parseInt(s[2]);
            }
            int ans[] = new Solution().juggling(a, n);
            ot.println(ans[0] + " " + ans[1]);
        }

        ot.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private int calculateScore(int currentCup, int[][] arr) {
        int score = 0;

        for (int[] current : arr) {
            int a = current[0];
            int b = current[1];
            int p = current[2];
            if (a == currentCup) {
                currentCup = b;
            } else if (b == currentCup) {
                currentCup = a;
            }
            if (p == currentCup) ++score;
        }

        return score;
    }

    public int[] juggling(int[][] arr, int n) {
        // Code Here.
        int score1 = calculateScore(1, arr);
        int score2 = calculateScore(2, arr);
        int score3 = calculateScore(3, arr);
        int maxScore = Math.max(score1, Math.max(score2, score3));

        if (score1 == maxScore) return new int[]{1, score1};

        if (score2 == maxScore) return new int[]{2, score2};

        return new int[]{3, score3};
    }
}