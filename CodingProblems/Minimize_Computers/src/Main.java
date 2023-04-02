// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int k = Integer.parseInt(s[1]);

            s = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);

            ot.println(new Solution().minimizeComputers(a, n, k));
        }
        ot.close();
    }
} // } Driver Code Ends


//User function Template for Java

class Solution {
    private int[] times;
    private int n;
    private int k;

    private boolean check(int numOfComputers) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int timePassed = 0;

        for (int i = 0; i < n; ++i) {
            int currentTime = times[i];
            if (numOfComputers > 0) {
                if (currentTime + timePassed > k) return false;
                pq.add(currentTime + timePassed);
                --numOfComputers;
            }
            else {
                assert pq.peek() != null;
                timePassed = pq.poll();
                if (timePassed + currentTime > k) return false;
                ++numOfComputers;
                while (!pq.isEmpty() && pq.peek() <= timePassed) {
                    pq.poll();
                    ++numOfComputers;
                }
                --numOfComputers;
                pq.add(timePassed + currentTime);
            }
        }

        return true;
    }

    public int minimizeComputers(int[] times, int n, int k) {
        // Code Here.
        this.times = times;
        this.n = n;
        this.k = k;
        int l = 1;
        int r = n;
        int ans = 0;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (check(mid)) {
                ans = mid;
                r = mid - 1;
            }
            else l = mid + 1;
        }

        return ans;
    }
}

