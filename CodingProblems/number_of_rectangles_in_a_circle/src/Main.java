//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            int ans = ob.rectanglesInCircle(N);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   public int rectanglesInCircle(int radius) {
       // code here
       int left = 1;
       int right = 2 * radius;
       int diameter = 2 * radius;
       int answer = 0;

       while (left <= right) {
           if (left * left + right * right <= diameter * diameter) {
               answer += 2 * (right - left + 1) - 1;
               ++left;
           } else {
               --right;
           }
       }

       return answer;
   }
}