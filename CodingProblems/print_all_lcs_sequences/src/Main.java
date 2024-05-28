//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String ss = br.readLine();
            String[] S = ss.split(" ");
            String s = S[0];
            String t = S[1];
            Solution ob = new Solution();
            List<String> ans = new ArrayList<String>();
            ans = ob.all_longest_common_subsequences(s, t);
            for(int i = 0; i < ans.size(); i++)
            {
                System.out.print(ans.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private HashSet<String> commonSubsequences;
    private String s;
    private String t;

    private void generate(int i, int j, String currentString, int lengthRemaining) {
        if (lengthRemaining == 0) {
            if (!currentString.equals("")) {
                commonSubsequences.add(currentString);
            }
            return;
        }

        if (i >= s.length() || j >= t.length()) {
            return;
        }

        if (s.charAt(i) == t.charAt(j)) {
            generate(i + 1, j + 1, currentString + s.charAt(i), lengthRemaining - 1);
        }
        else {
            generate(i + 1, j, currentString, lengthRemaining);
            generate(i, j + 1, currentString, lengthRemaining);
        }
    }

    private int findMaxLength() {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
        this.s = s;
        this.t = t;
        commonSubsequences = new HashSet<>();

        generate(0, 0, "", findMaxLength());

        List<String> answer = new ArrayList<>(commonSubsequences);

        Collections.sort(answer);

        return answer;
    }
}