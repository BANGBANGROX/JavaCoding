//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String[] s1 = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(s1[0]);
            int m = Integer.parseInt(s1[1]);
            String s = in.readLine();

            Solution ob = new Solution();
            System.out.println(ob.isPossible(n, m, s));
        }
    }
}
// } Driver Code Ends


// User function Template for 

class Solution {
    public int isPossible(int m, int n, String s) {
        // code here
        HashMap<Character, Integer> pathLength = new HashMap<>();
        HashMap<Character, Character> complementary = new HashMap<>();

        complementary.put('L', 'R');
        complementary.put('R', 'L');
        complementary.put('U', 'D');
        complementary.put('D', 'U');
        pathLength.put('L', 0);
        pathLength.put('R', 0);
        pathLength.put('U', 0);
        pathLength.put('D', 0);

        for (char ch : s.toCharArray()) {
            pathLength.put(ch, pathLength.get(ch) + 1);
            if (pathLength.get(complementary.get(ch)) > 0) {
                pathLength.put(complementary.get(ch), pathLength.get(complementary.get(ch)) - 1);
            }
            if (pathLength.get('L') < 0 || pathLength.get('R') < 0 || pathLength.get('U') < 0 ||
                    pathLength.get('D') < 0) return 0;
            if (pathLength.get('L') >= n || pathLength.get('R') >= n || pathLength.get('U') >= m ||
                    pathLength.get('D') >= m) return 0;
        }

        return 1;
    }
}