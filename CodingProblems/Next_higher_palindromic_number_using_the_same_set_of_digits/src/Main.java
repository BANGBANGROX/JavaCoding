//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();
            System.out.println(obj.nextPalin(s));
        }

    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean nextPermutation(char[] arr) {
        int n = arr.length;
        int last = n - 2;

        while (last >= 0 && arr[last + 1] <= arr[last]) --last;

        if (last < 0) return false;

        int nextGreater = n - 1;

        for (int i = n - 1; i > last; --i) {
            if (arr[i] > arr[last]) {
                nextGreater = i;
                break;
            }
        }

        char temp = arr[last];
        arr[last] = arr[nextGreater];
        arr[nextGreater] = temp;

        int l = last + 1;
        int r = n / 2 - 1;

        while (l < r) {
            char t = arr[l];
            arr[l] = arr[r];
            arr[r] = t;
            ++l;
            --r;
        }

        return true;
    }

    public String nextPalin(String s) {
        //complete the function here
        int n = s.length();
        StringBuilder halfNum = new StringBuilder();

        for (int i = 0; i < n / 2; ++i) {
            halfNum.append(s.charAt(i));
        }

        char[] halfNumArr = halfNum.toString().toCharArray();

        if (!nextPermutation(halfNumArr)) return "-1";

        char[] revHalfNumArr = halfNumArr.clone();
        int l = 0;
        int r = n - 1;

        while (l < r) {
            char t = revHalfNumArr[l];
            revHalfNumArr[l] = revHalfNumArr[r];
            revHalfNumArr[r] = t;
            ++l;
            --r;
        }

        String ans;

        if ((n & 1) == 0) {
            ans = new String(halfNumArr) + new String(revHalfNumArr);
        }
        else {
            ans = new String(halfNumArr) + s.charAt(n / 2) + new String(revHalfNumArr);
        }

        return ans;
    }
}
