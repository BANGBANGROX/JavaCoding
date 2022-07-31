//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {

            String[] input = read.readLine().split(" ");
            String a = input[0];
            String b = input[1];
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a,b));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    String addBinary(String x, String y) {
        // code here
        int m = x.length();
        int n = y.length();
        int i = m - 1;
        int j = n - 1;
        int carry = 0;
        StringBuilder ans = new StringBuilder();

        while (i >= 0 && j >= 0) {
            char a = x.charAt(i);
            char b = y.charAt(j);
            if (a == '1' && b == '1') {
                if (carry == 1) {
                    ans.append('1');
                }
                else {
                    ans.append('0');
                    carry = 1;
                }
            }
            else if ((a == '1' && b == '0') || (a == '0' && b == '1')) {
                if (carry == 1) {
                    ans.append('0');
                }
                else {
                    ans.append('1');
                }
            }
            else {
                if (carry == 1) {
                    ans.append('1');
                    carry = 0;
                }
                else ans.append('0');
            }
            --i;
            --j;
        }

        while (i >= 0) {
            char a = x.charAt(i);
            if (a == '1') {
                if (carry == 0) {
                    ans.append('1');
                }
                else {
                    ans.append('0');
                }
            }
            else {
                if (carry == 1) {
                    ans.append('1');
                    carry = 0;
                }
                else {
                    ans.append('0');
                }
            }
            --i;
        }

        while (j >= 0) {
            char b = y.charAt(j);
            if (b == '1') {
                if (carry == 1) {
                    ans.append('0');
                }
                else {
                    ans.append('1');
                }
            }
            else {
                if (carry == 1) {
                    ans.append('1');
                    carry = 0;
                }
                else {
                    ans.append('0');
                }
            }
            --j;
        }

        if (carry == 1) ans.append('1');

        ans.reverse();

        int start = 0;

        while (start < ans.length() && ans.charAt(start) == '0') {
            ++start;
        }

        return ans.substring(start);
    }
}