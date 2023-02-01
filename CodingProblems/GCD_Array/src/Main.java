//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){

            int N;
            N = Integer.parseInt(br.readLine());


            int K;
            K = Integer.parseInt(br.readLine());


            int[] arr = IntArray.input(br, N);

            Solution obj = new Solution();
            int res = obj.solve(K, arr);

            System.out.println(res);

        }
    }
}

// } Driver Code Ends


class Solution {
    public int solve(int k, int[] nums) {
        // code here
        int totalSum = Arrays.stream(nums).sum();
        ArrayList<Integer> factors = new ArrayList<>();

        for (int i = 1; i * i <= totalSum; ++i) {
            if (totalSum % i == 0) {
                factors.add(i);
                if (totalSum / i != i) {
                    factors.add(totalSum / i);
                }
            }
        }

        factors.sort(Collections.reverseOrder());

        for (int x : factors) {
            int cnt = 0;
            int runningSum = 0;
            for (int y : nums) {
                runningSum += y;
                if (runningSum % x == 0) {
                    ++cnt;
                    runningSum = 0;
                }
            }
            if (cnt >= k) return x;
        }

        return 1;
    }
}

