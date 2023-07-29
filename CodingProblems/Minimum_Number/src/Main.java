//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            int res = obj.minimumNumber(n, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int minimumNumber(int n, int[] nums) {
        // code here
        boolean odd = false;
        int minimumValue = Integer.MAX_VALUE;

        for (int i = 0; i < n; ++i) {
            if ((nums[i] & 1) > 0) {
                odd = true;
            }
            minimumValue = Math.min(minimumValue, nums[i]);
        }

        return odd ? 1 : minimumValue;
    }
}

