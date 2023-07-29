//{ Driver Code Starts
//Initial Template for Java

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.next();
            }

            int k = Integer.parseInt(sc.next());

            String str = sc.next();

            Solution obj = new Solution();
            int ans = obj.klengthpref(arr, n, k, str);
            System.out.println(ans);

            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int klengthpref(String[] strs, int n, int k, String s) {
        // code here
        if (s.length() < k) return 0;

        String prefix = s.substring(k);
        int answer = 0;

        for (int i = 0; i < n; ++i) {
            int j = 0;
            if (strs[i].length() < k) continue;
            while (j < k) {
                if (prefix.charAt(j) != strs[i].charAt(j)) break;
                ++j;
            }
            if (j == k) ++answer;
        }

        return answer;
    }
}