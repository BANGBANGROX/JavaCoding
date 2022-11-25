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
            int[] num = new int[n];
            String[] str = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                num[i] = Integer.parseInt(str[i]);
            }

            Vector<Integer> ans = new Solution().generateNextPalindrome(num, n);
            for (Integer x : ans) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    private int[] makePalindrome(int[] num, int n) {
        int[] ans = new int[n];

        for (int i = 0; i < n / 2; ++i) {
            ans[i] = num[i];
            ans[n - i - 1] = num[i];
        }

        return ans;
    }

    private boolean all9(int[] num) {
        for (int d : num) {
            if (d != 9) return false;
        }

        return true;
    }

    private boolean compare(int[] a, int[] b, int n) {
        for (int i = 0; i < n; ++i) {
            if (a[i] > b[i]) return true;
            if (a[i] < b[i]) return false;
        }

        return false;
    }

    public Vector<Integer> generateNextPalindrome(int[] num, int n) {
        // code here
        Vector<Integer> ans = new Vector<>();

        if (all9(num)) {
            ans.add(1);
            for (int i = 1; i < n; ++i) ans.add(0);
            ans.add(1);
            return ans;
        }

        int[] palindromeNum = makePalindrome(num, n);

        if (compare(palindromeNum, num, n)) {
            for (int i = 0; i < n; ++i) {
                ans.add(palindromeNum[i]);
            }
            return ans;
        }

        int carry = 1;

        for (int i = n / 2 - 1; i >= 0; --i) {
            int value = palindromeNum[i] + carry;
            palindromeNum[i] = value % 10;
            carry = value / 10;
        }

        palindromeNum = makePalindrome(palindromeNum, n);

        for (int i = 0; i < n; ++i) {
            ans.add(palindromeNum[i]);
        }

        return ans;
    }
}