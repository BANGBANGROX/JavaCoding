//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    public static void main (String[] args)throws IOException {

        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String[] s =in.readLine().trim().split(" ");

            int[] gallery = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
        out.close();

    }
}





// } Driver Code Ends


//User function Template for Java

class Solution {
    private static class Pair {
        int first;
        int second;

        Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public int min_sprinklers(int[] gallery, int n) {
        // code here
        List<Pair> range = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            if (gallery[i] < 0) continue;
            int left = i - gallery[i];
            int right = i + gallery[i];
            range.add(new Pair(Math.max(left, 0), Math.min(right, n - 1)));
        }

        range.sort(Comparator.comparingInt(a -> a.first));

        int start = -1;
        int end = -1;
        int answer = 0;

        for (Pair p : range) {
            if (end >= n - 1) break;
            if (p.first <= start + 1) {
                end = Math.max(end, p.second);
            }
            else if (p.first > end + 1) {
                return -1;
            }
            else {
                start = end;
                end = p.second;
                ++answer;
            }
        }

        return answer + 1;
    }
}