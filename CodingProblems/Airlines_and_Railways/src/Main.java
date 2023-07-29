// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String[] input_line = read.readLine().trim().split("\\s+");
            int N = Integer.parseInt(input_line[0]);
            int X = Integer.parseInt(input_line[1]);

            input_line = read.readLine().trim().split("\\s+");
            int src = Integer.parseInt(input_line[0]);
            int dest = Integer.parseInt(input_line[1]);

            input_line = read.readLine().trim().split("\\s+");
            int M1 = Integer.parseInt(input_line[0]);
            int[][] airlines = new int[M1][3];
            for (int i = 0; i < M1; i++) {
                input_line = read.readLine().trim().split("\\s+");
                airlines[i][0] = Integer.parseInt(input_line[0]);
                airlines[i][1] = Integer.parseInt(input_line[1]);
                airlines[i][2] = Integer.parseInt(input_line[2]);
            }


            input_line = read.readLine().trim().split("\\s+");
            int M2 = Integer.parseInt(input_line[0]);
            int[][] railways = new int[M2][3];
            for (int i = 0; i < M2; i++) {
                input_line = read.readLine().trim().split("\\s+");
                railways[i][0] = Integer.parseInt(input_line[0]);
                railways[i][1] = Integer.parseInt(input_line[1]);
                railways[i][2] = Integer.parseInt(input_line[2]);
            }
            Solution ob = new Solution();
            long ans = ob.minTime(N, X, src, dest, airlines, railways);
            System.out.println(ans);
        }
    }
} // } Driver Code Ends


//User function Template for Java
class Solution {
    private int n;
    private ArrayList<ArrayList<int[]>> graph;

    private long[] computeDistances(int source) {
        long[] distance = new long[2 * n];
        TreeSet<ArrayList<Long>> treeSet = new TreeSet<>((a, b) ->
                (int) (!Objects.equals(a.get(1), b.get(1)) ? a.get(1) - b.get(1) : a.get(0) - b.get(0)));

        Arrays.fill(distance, Long.MAX_VALUE);

        treeSet.add(new ArrayList<>(Arrays.asList((long) source, (long) 0)));
        distance[source] = 0;

        while (!treeSet.isEmpty()) {
            ArrayList<Long> state = treeSet.first();
            long node = state.get(0);
            long currentDistance = state.get(1);
            treeSet.remove(state);
            for (int[] childState : graph.get((int) node)) {
                int child = childState[0];
                int weight = childState[1];
                long nextDistance = currentDistance + weight;
                if (distance[child] > nextDistance) {
                    ArrayList<Long> nextState = new ArrayList<>(Arrays.asList((long) child,
                            distance[child]));
                    treeSet.remove(nextState);
                    distance[child] = nextDistance;
                    nextState.set(1, distance[child]);
                    treeSet.add(nextState);
                }
            }
        }

        return distance;
    }

    public long minTime(int n, int x, int source, int destination,
                        int[][] airlines, int[][] railways) {
        // code here
        graph = new ArrayList<>();
        this.n = n;

        for (int i = 0; i < 2 * n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] airline : airlines) {
            int u = airline[0];
            int v = airline[1];
            int wt = airline[2];
            graph.get(u).add(new int[]{v, wt});
        }

        for (int[] rail : railways) {
            int u = rail[0] + n;
            int v = rail[1] + n;
            int wt = rail[2];
            graph.get(u).add(new int[]{v, wt});
        }

        for (int i = 0; i < n; ++i) {
            graph.get(i).add(new int[]{n + i, x});
            graph.get(n + i).add(new int[]{i, x});
        }

        long[] distanceData1 = computeDistances(source);
        long[] distanceData2 = computeDistances(source + n);
        long answer = Math.min(Math.min(distanceData1[destination],
                        distanceData1[destination + n]),
                Math.min(distanceData2[destination], distanceData2[destination + n]));

        return answer == Long.MAX_VALUE ? -1 : answer;
    }
}