//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            Solution ob = new Solution();
            int ans = ob.countZeroes(N);
            System.out.println(ans);
        }
    }
}



// } Driver Code Ends


//User function Template for Java

class Solution {
    private int countFives(int num) {
        int result = 0;

        for (int i = 5; num / i > 0; i *= 5) {
            result += num / i;
        }

        return result;
    }

    int countZeroes(int n) {
        // code here
        int l = 0;
        int r = n * 5;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            int cnt = countFives(mid);
            if (cnt == n) return 5;
            if (cnt > n) r = mid - 1;
            else l = mid + 1;
        }

        return 0;
    }
}
