//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    boolean kPangram(String str, int k) {
        // code here
        int needed = 26;
        int totalChars = 0;
        boolean[] visited = new boolean[26];

        for (char ch : str.toCharArray()) {
            if (ch == ' ') continue;
            ++totalChars;
            if (!visited[ch - 'a']) {
                --needed;
                visited[ch - 'a'] = true;
            }
        }

        return totalChars >= 26 && needed <= k;
    }
}