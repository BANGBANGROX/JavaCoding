//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while(t-- > 0){

            String S = read.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.removeReverse(S);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends
//User function Template for Java

class Solution {
    public String removeReverse(String s) {
        // code here
        int n = s.length();
        int l = 0;
        int r = n - 1;
        int[] count = new int[26];
        boolean flag = true;
        StringBuilder begin = new StringBuilder();
        StringBuilder end = new StringBuilder();

        for (char ch : s.toCharArray()) {
            ++count[ch - 'a'];
        }

        while (l <= r) {
            char ch;
            if (flag) {
                ch = s.charAt(l);
                ++l;
            }
            else {
                ch = s.charAt(r);
                --r;
            }
            if (count[ch - 'a'] > 1) {
                --count[ch - 'a'];
                flag = !flag;
            }
            else {
                if (flag) {
                    begin.append(ch);
                }
                else {
                    end.insert(0, ch);
                }
            }
        }

        StringBuilder ans = new StringBuilder();

        ans.append(begin);
        ans.append(end);

        if (!flag) ans.reverse();

        return ans.toString();
    }
}

//{ Driver Code Starts.

// } Driver Code Ends