// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main{
    public static void main(String args[])throws IOException{
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String a[] = in.readLine().trim().split("\\s+");
            int N = Integer.parseInt(a[0]);
            long M = Long.parseLong(a[1]);
            long L = Long.parseLong(a[2]);
            long H[] = new long[N];
            long A[] = new long[N];
            for(int i = 0; i < N; i++){
                String a1[] = in.readLine().trim().split("\\s+");
                H[i] = Long.parseLong(a1[0]);
                A[i] = Long.parseLong(a1[1]);
            }

            Solution ob = new Solution();
            System.out.println(ob.buzzTime(N, M, L, H, A));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean check(int N, long M, long L, long H[], long A[], long time) {
        long total = 0;

        for (int i = 0; i < N; ++i) {
            long finalSpeed = H[i] + A[i] * time;
            if (finalSpeed >= L) {
                total += finalSpeed;
                if (total >= M) return true;
            }
        }

        return  false;
    }
    static long buzzTime(int N, long M, long L, long H[], long A[]){
        // code here
        long l = 0;
        long r = Math.max(M, L);
        long ans = -1;

        while (l <= r) {
            long mid = (l + ((r - l) >> 1));
            if (check(N, M, L, H, A, mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }
}
