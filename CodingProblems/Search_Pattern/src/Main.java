// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);

            if(res.size()==0)
                System.out.print("-1 ");
            else {
                for(int i = 0;i<res.size();i++)
                    System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    private void computeLCS(String pat, int[] lps) {
        int n = pat.length();
        int i = 1;
        int len = 0;

        while (i < n) {
            if (pat.charAt(i) == pat.charAt(len)) {
                ++len;
                lps[i] = len;
                ++i;
            }
            else {
                if (len == 0) ++i;
                else len = lps[len - 1];
            }
        }
    }

    public ArrayList<Integer> search(String pat, String s) {
        // your code here
        int m = pat.length();
        int n = s.length();
        int[] lps = new int[m];
        int i = 0;
        int j = 0;
        ArrayList<Integer> ans = new ArrayList<>();

        computeLCS(pat, lps);

        while (i < n) {
            while (i < n && j < m && s.charAt(i) == pat.charAt(j)) {
                ++i;
                ++j;
            }
            if (j == m) {
                ans.add(i - j + 1);
                j = lps[j - 1];
            }
            else {
                if (j == 0) ++i;
                else j = lps[j - 1];
            }
        }

        return ans;
    }
}