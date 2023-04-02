// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
public class Main{
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            int n = Integer.parseInt(br.readLine().trim());
            String s[] = br.readLine().trim().split(" ");
            int a[] = new int[n];
            for(int i = 0; i < n; i++)
                a[i] = Integer.parseInt(s[i]);
            ot.println(new Solution().makePermutation(a, n));
        }
        ot.close();
    }
} // } Driver Code Ends


//User function Template for Java

class Solution {
    public int makePermutation(int[] nums, int n) {
        // Code Here.
        int op = 0;
        boolean[] visited = new boolean[n + 1];
        ArrayList<Integer> greaterNums = new ArrayList<>();

        for (int num : nums) {
            if (num <= n) visited[num] = true;
            else greaterNums.add(num);
        }

        Collections.sort(greaterNums);

        for (int i = 1; i <= n; ++i) {
            if (visited[i]) continue;
            if (2 * i - 1 > greaterNums.get(op)) return -1;
            ++op;
        }

        return op;
    }
}