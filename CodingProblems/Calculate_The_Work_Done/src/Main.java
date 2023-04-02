// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;
    public static void main(String[] args) throws IOException{
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int cap = Integer.parseInt(s[1]);
            int[] a = new int[n];
            s = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                a[i] = Integer.parseInt(s[i]);
            }
            ot.println(new Solution().workDone(n, a, cap));
        }

        ot.close();
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    public int workDone(int n, int[] nums, int cap){
        // Code Here.
        HashMap<Integer, Integer> count = new HashMap<>();
        LinkedList<Integer> listNums = new LinkedList<>();
        int ans = 0;

        for (int num : nums) {
            if (count.getOrDefault(num, 0) > 0) continue;
            ++ans;
            if (listNums.size() == cap) {
                assert listNums.getFirst() != null;
                int val = listNums.pollFirst();
                count.put(val, count.get(val) - 1);
            }
            listNums.add(num);
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        return ans;
    }
}