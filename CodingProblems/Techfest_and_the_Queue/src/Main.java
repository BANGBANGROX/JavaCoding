//{ Driver Code Starts

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            long a;
            a = Long.parseLong(br.readLine().trim());


            long b;
            b = Long.parseLong(br.readLine().trim());

            Solution obj = new Solution();
            long res = obj.sumOfPowers(a, b);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends



class Solution {
    private int[] generateSPFArray(int maxN) {
        int[] spf = new int[maxN + 1];

        for (int i = 2; i <= maxN; ++i) {
            spf[i] = i;
        }

        for (int i = 2; i <= maxN; ++i) {
            if (spf[i] == i) {
                for (int j = 2 * i; j <= maxN; j += i) {
                    if (spf[j] == j) {
                        spf[j] = i;
                    }
                }
            }
        }

        return spf;
    }

    private int calculatePFPowerSum(int num, int[] spf) {
        int result = 0;
        int pf = spf[num];

        while (num > 1) {
            while (num % pf == 0) {
                ++result;
                num /= pf;
            }
            pf = spf[num];
        }

        return result;
    }

    public long sumOfPowers(long a, long b) {
        // code here
        int[] spf = generateSPFArray((int) b);
        long answer = 0;

        while (a <= b) {
            answer += calculatePFPowerSum((int) a, spf);
            ++a;
        }

        return answer;
    }
}

