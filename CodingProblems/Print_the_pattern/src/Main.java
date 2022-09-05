//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine());

            Solution ob = new Solution();
            List<String> ans = ob.pattern(n);
            for (int i = 0; i < n; i++)
                System.out.println(ans.get(i));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public List<String> pattern(int n) {
        // code here
        int num = 1;
        List<String> ans = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            StringBuilder current = new StringBuilder();
            current.append("-".repeat(Math.max(0, 2 * i)));
            for (int j = 0; j < n - i; ++j) {
                current.append(num);
                current.append('*');
                ++num;
            }
            ans.add(current.toString());
        }

        for (int i = n - 1; i >= 0; --i) {
            for (int j = 0; j < n - i; ++j) {
                ans.set(i, ans.get(i) + num);
                if (j != n - i - 1) ans.set(i, ans.get(i) + '*');
                ++num;
            }
        }

        return ans;
    }
}