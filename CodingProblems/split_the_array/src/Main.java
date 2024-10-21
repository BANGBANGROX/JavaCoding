//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


// } Driver Code Ends
// User function Template for Java

class Solution {
    private final int MOD = (int) 1e9 + 7;

    private long binaryExponentiation(long b) {
        long result = 1;
        long a = 2;

        while (b > 0) {
            if ((b & 1) > 0) {
                result = (result * a) % MOD;
                --b;
            }
            a = (a * a) % MOD;
            b >>= 1;
        }

        return result;
    }

    public int countgroup(int[] arr) {
        // Complete the function
        int totalXor = 0;
        int n = arr.length;

        for (int num : arr) {
            totalXor ^= num;
        }

        if (totalXor != 0) return 0;

        return ((int) binaryExponentiation(n - 1) - 1 + MOD) % MOD;
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            // int k = Integer.parseInt(br.readLine());
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;
            Solution obj = new Solution();
            int ans = obj.countgroup(arr);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends