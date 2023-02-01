//{ Driver Code Starts
//Initial Template for Java

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while (t-- > 0) {
            long n = Long.parseLong(br.readLine().trim());
            long[] a = new long[(int) (n)];

            String[] inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }

            Solution obj = new Solution();
            System.out.println(obj.countDivisorsMulti(a));

        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution {
    public long countDivisorsMulti(long[] nums) {
        HashMap<Long, Long> mp = new HashMap<>();
        long ans = 1;

        for (long num : nums) {
            for (long i = 2; i * i <= num; ++i) {
                if (num % i == 0) {
                    long cnt = 0;
                    while (num % i == 0) {
                        num /= i;
                        ++cnt;
                    }
                    mp.put(i, mp.getOrDefault(i, 0L) + cnt);
                }
            }
            if (num > 1) {
                mp.put(num, mp.getOrDefault(num, 0L) + 1);
            }
        }

        for (long x : mp.keySet()) {
            ans *= (mp.get(x) + 1);
        }

        return ans;
    }
}