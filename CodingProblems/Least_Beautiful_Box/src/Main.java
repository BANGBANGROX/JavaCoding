// { Driver Code Starts
//Initial Template for Java

import com.sun.source.tree.Tree;

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String s[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int id[] = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                id[i] = Integer.parseInt(s[i]);

            ot.println(new Solution().minimumBeauty(id, n));
        }
        ot.close();
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public int minimumBeauty(int ids[], int n){
        // Code Here.
        TreeSet<Integer> ts = new TreeSet<>();
        ArrayList<Integer>

        for (int x : ids) {
            ts.add(x);
        }



        int minLength = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            int cnt = 1;
            while (i + 1 < n && ids[i] == ids[i + 1]) {
                ++i;
                ++cnt;
            }
            minLength = Math.min(minLength, cnt);
        }

        return minLength;
    }
}