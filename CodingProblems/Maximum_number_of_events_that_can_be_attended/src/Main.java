// { Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());

            String S1[] = read.readLine().split(" ");
            String S2[] = read.readLine().split(" ");
            int[] start = new int[N];
            int[] end = new int[N];

            for(int i=0; i<N; i++)
            {
                start[i] = Integer.parseInt(S1[i]);
                end[i] = Integer.parseInt(S2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.maxEvents(start,end,N));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    static int maxEvents(int[] start, int[] end, int n) {
        // code here
        HashMap<Integer, ArrayList<Integer>> startDays = new HashMap<>();
        int firstDay = Integer.MAX_VALUE;
        int lastDay = Integer.MIN_VALUE;

        for (int i = 0; i < n; ++i) {
            if (startDays.containsKey(start[i])) {
                startDays.get(start[i]).add(i);
            }
            else {
                startDays.put(start[i], new ArrayList<>(Arrays.asList(i)));
            }
            firstDay = Math.min(firstDay, start[i]);
            lastDay = Math.max(lastDay, end[i]);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int ans = 0;

        for (int i = firstDay; i <= lastDay; ++i) {
            if (startDays.containsKey(i)) {
                for (int j : startDays.get(i)) {
                    pq.add(end[j]);
                }
            }
            if (!pq.isEmpty()) {
                ++ans;
                pq.poll();
            }
            while (!pq.isEmpty() && pq.peek() == i) {
                pq.poll();
            }
        }

        return ans;
    }
}