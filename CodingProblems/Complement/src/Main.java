//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String str = br.readLine().trim();

            Vector ans = new Solve().findRange(str, n);
            if (ans.size() == 1) {
                System.out.println(ans.get(0));
            } else {
                System.out.println(ans.get(0) + " " + ans.get(1));
            }
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solve {
    Vector findRange(String s, int n) {
        // code here
        int start = -1;
        int end = -1;
        int l = 0;
        int currentCount = 0;
        int maxCount = 0;
        Vector<Integer> ans = new Vector<>();

        for (int i = 0; i < n; ++i) {
            currentCount += (s.charAt(i) == '0' ? 1 : -1);
            if (currentCount < 0) {
                l = i + 1;
                currentCount = 0;
            }
            if (currentCount > maxCount) {
                maxCount = currentCount;
                start = l;
                end = i;
            }
        }

        if (end == -1) ans.add(-1);
        else {
            ans.add(start + 1);
            ans.add(end + 1);
        }

        return ans;
    }
}