//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] arr = br.readLine().split(" ");
            String A = arr[0];
            String B = arr[1];
            Solution obj = new Solution();
            System.out.println(obj.transform(A, B));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    public int transform(String s1, String s2) {
        // code here
        int m = s1.length();
        int n = s2.length();

        if (m != n) return -1;

        int[] count1 = new int[256];
        int[] count2 = new int[256];

        for (int i = 0; i < m; ++i) {
            ++count1[s1.charAt(i)];
            ++count2[s2.charAt(i)];
        }

        for (int i = 0; i < 256; ++i) {
            if (count1[i] != count2[i]) return -1;
        }

        int i = m - 1;
        int j = n - 1;
        int answer = 0;

        while (i >= 0) {
            if (s1.charAt(i) == s2.charAt(j)) {
                --j;
            } else {
                ++answer;
            }
            --i;
        }

        return answer;
    }
}