//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] a = in.readLine().trim().split("\\s+");

            Solution ob = new Solution();
            System.out.println(ob.minFind(a));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minFind(String[] color) {
        // code here
        int rCount = 0;
        int gCount = 0;
        int bCount = 0;

        for (String col : color) {
            if (col.equals("R")) ++rCount;
            if (col.equals("G")) ++gCount;
            if (col.equals("B")) ++bCount;
        }

        if ((rCount % 2 == 0 && gCount % 2 == 0 && bCount % 2 == 0) ||
                (rCount % 2 == 1 && gCount % 2 == 1 && bCount % 2 == 1)) return 2;

        return 1;
    }
}