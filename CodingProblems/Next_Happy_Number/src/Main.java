//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.nextHappy(N));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    private boolean checkHappy(int num) {
        Set<Integer> visited = new HashSet<>();

        visited.add(1);

        while (!visited.contains(num)) {
            visited.add(num);
            int sum = 0;
            while (num > 0) {
                int dig = num % 10;
                sum += dig * dig;
                num /= 10;
            }
            num = sum;
        }

        return num == 1;
    }

    public int nextHappy(int n) {
        // code here
        final int MAX_N = 10000;

        for (int i = 1; i <= MAX_N; ++i) {
            if (checkHappy(i)) {
                if (i > n) return i;
            }
        }

        return -1;
    }
}