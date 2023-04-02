//{ Driver Code Starts
//Initial Template for JAVA

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String[] S = read.readLine().split(" ");

            int[] arr = new int[N];

            for (int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(S[i]);

            Solution ob = new Solution();
            System.out.println(ob.singleElement(arr));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int singleElement(int[] nums) {
        // code here
        int ans = 0;
        int shift = 1;

        for (int bit = 0; bit < 32; ++bit) {
            int cnt = 0;
            for (int num : nums) {
                if ((num & shift) > 0) {
                    ++cnt;
                }
            }
            if (cnt % 3 == 1) {
                ans |= shift;
            }
            shift <<= 1;
        }

        return ans;
    }
}