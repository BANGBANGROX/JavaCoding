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
            int res = obj.bitMagic(n, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int bitMagic(int n, int[] nums) {
        // code here
        int l = 0;
        int r = n - 1;
        int answer = 0;

        while (l < r) {
            if (nums[l] != nums[r]) {
                ++answer;
            }
            ++l;
            --r;
        }

        return (answer + 1) / 2;
    }
}

