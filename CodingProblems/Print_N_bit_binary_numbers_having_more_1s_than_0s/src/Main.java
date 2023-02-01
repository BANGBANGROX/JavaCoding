//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            ArrayList<String> result = ob.NBitBinary(n);
            for(String value  : result){
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private final ArrayList<String> ans = new ArrayList<>();
    private int n;

    private void generate(int onesCount, int zeroesCount, String current) {
        if (onesCount + zeroesCount == n) {
            ans.add(current);
            return;
        }

        generate(onesCount + 1, zeroesCount, current + '1');

        if (onesCount > zeroesCount) {
            generate(onesCount, zeroesCount + 1, current + '0');
        }
    }

    public ArrayList<String> NBitBinary(int n) {
        // code here
        this.n = n;

        generate(1, 0, "1");

        return ans;
    }
}