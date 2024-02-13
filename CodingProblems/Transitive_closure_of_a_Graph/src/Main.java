//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args)throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            int[][] graph = new int[N][N];

            for(int i = 0;i < N;i++)
            {
                String[] a = in.readLine().trim().split("\\s+");
                for(int j=0;j<N;j++)
                    graph[i][j] = Integer.parseInt(a[j]);}

            Solution ob = new Solution();
            ArrayList<ArrayList<Integer>> ans = ob.transitiveClosure(N, graph);
            for(int i = 0;i < N;i++)
            { for(int j = 0;j < ans.get(i).size();j++)
                System.out.print(ans.get(i).get(j) + " ");
                System.out.println();}
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<ArrayList<Integer>> transitiveClosure(int n, int[][] graph) {
        // code here
        int[][] result = graph.clone();
        ArrayList<ArrayList<Integer>> answer = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            result[i][i] = 1;
        }

        for (int k = 0; k < n; ++k) {
            for (int i = 0; i < n; ++i) {
                for (int j = 0; j < n; ++j) {
                    if (result[i][k] == 1 && result[k][j] == 1) {
                        result[i][j] = 1;
                    }
                }
            }
        }

        for (int i = 0; i < n; ++i) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < n; ++j) {
                row.add(result[i][j]);
            }
            answer.add(new ArrayList<>(row));
        }

        return answer;
    }
}