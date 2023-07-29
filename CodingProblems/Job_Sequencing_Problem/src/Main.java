//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z;
    }
}

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //testcases
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0){
            String[] inputLine = br.readLine().trim().split(" ");

            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");

            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }

            Solution ob = new Solution();

            //function call
            int[] res = ob.JobScheduling(arr);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job[] jobs) {
        // Your code here
        int maximumProfit = 0;
        int jobsCompleted = 0;
        int lastDeadline = 0;
        HashMap<Integer, ArrayList<Integer>> deadlineWiseProfit = new HashMap<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        for (Job job : jobs) {
            int profit = job.profit;
            int deadline = job.deadline;
            lastDeadline = Math.max(lastDeadline, deadline);
            if (!deadlineWiseProfit.containsKey(deadline)) {
                deadlineWiseProfit.put(deadline, new ArrayList<>());
            }
            deadlineWiseProfit.get(deadline).add(profit);
        }

        for (int i = lastDeadline; i > 0; --i) {
            pq.addAll(deadlineWiseProfit.getOrDefault(i, new ArrayList<>()));
            if (!pq.isEmpty()) {
                maximumProfit += pq.poll();
                ++jobsCompleted;
            }
        }

        return new int[]{jobsCompleted, maximumProfit};
    }
}