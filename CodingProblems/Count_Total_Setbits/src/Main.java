//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            long N;
            N = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            long res = obj.countBits(N);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    private long binaryExponent(int power) {
        long answer = 1;
        long initialNumber = 2;

        while (power > 0) {
            if ((power & 1) > 0) {
                answer = (answer * initialNumber);
                --power;
            }
            initialNumber = (initialNumber * initialNumber);
            power >>= 1;
        }

        return answer;
    }

    public long countBits(long n) {
        // code here
        if (n <= 1) return n;

        int x = (int) (Math.log10(n) / Math.log10(2));
        long power2X = binaryExponent(x - 1);

        return x * power2X + (n - power2X * 2 + 1) + countBits(n - binaryExponent(x));
    }
}

