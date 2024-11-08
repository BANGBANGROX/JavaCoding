//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String A = read.readLine();
            String B = read.readLine();

            Solution ob = new Solution();
            out.println(ob.minRepeats(A, B));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int minRepeats(String a, String b) {
        // code here
        if (a.contains(b)) return 1;

        for (char ch : b.toCharArray()) {
            if (!a.contains("" + ch)) {
                return -1;
            }
        }

        String initialString = a;
        int ans = 1;
        StringBuilder aBuilder = new StringBuilder(a);

        while (aBuilder.length() < b.length()) {
            aBuilder.append(initialString);
            ++ans;
        }

        a = aBuilder.toString();

        if (a.contains(b)) return ans;

        a += initialString;
        ++ans;

        if (a.contains(b)) return ans;

        return -1;
    }
}