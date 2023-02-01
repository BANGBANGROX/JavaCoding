// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s = in.readLine().trim().split(" ");
            long A = Long.parseLong(s[0]);
            long B = Long.parseLong(s[1]);
            Solution ob = new Solution();
            ArrayList<Long> arr = ob.allNumbers(A, B);
            for (long i : arr) {
                out.print(i + " ");
            }
            out.println();
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public ArrayList<Long> allNumbers(long a, long b) {
        ArrayList<Long> ans = new ArrayList<>();

        for (long i = a; i <= b; i += a) {
            if (b % i == 0) {
                ans.add(i);
            }
        }

        return ans;
    }
}