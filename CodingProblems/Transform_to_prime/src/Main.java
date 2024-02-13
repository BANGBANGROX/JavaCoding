//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcases = Integer.parseInt(br.readLine());
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(a1[i]);
            }
            Solution ob = new Solution();
            int ans=ob.minNumber(a);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution {
    public int minNumber(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        final int MAX_VALUE = 3 * totalSum;
        boolean[] isPrime = new boolean[MAX_VALUE];

        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i < MAX_VALUE; ++i) {
            if (isPrime[i]) {
                if (i >= totalSum) return i - totalSum;
                for (int j = 2 * i; j < MAX_VALUE; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return -1;
    }
}
