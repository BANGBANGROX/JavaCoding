//{ Driver Code Starts
//Initial Template for Java


/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;


public class Main {

    // Driver code

    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        Complete obj = new Complete();
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int N = Integer.parseInt(element[0]);
            int K = Integer.parseInt(element[1]);
            int[][] arr = new int[K][2];
            for (int i = 0; i < K; i++) {
                line = br.readLine();
                String[] elements = line.trim().split("\\s+");
                arr[i][0] = Integer.parseInt(elements[0]);
                arr[i][1] = Integer.parseInt(elements[1]);
            }
            int ans = obj.doctorStrange(N, arr);
            System.out.println(ans);

        }
    }
}




// } Driver Code Ends


//User function Template for Java

//User function Template for Java


class Complete {
    private ArrayList<ArrayList<Integer>> graph;
    private HashSet<Integer> articulationPoints;
    private boolean[] visited;
    private int[] inTime;
    private int[] lowTime;
    private int timer;

    private void dfs(int node, int parent) {
        visited[node] = true;
        inTime[node] = lowTime[node] = timer;
        ++timer;

        int children = 0;

        for (int child : graph.get(node)) {
            if (child != parent) {
                if (visited[child]) {
                    // Back edge
                    lowTime[node] = Math.min(lowTime[node], inTime[child]);
                }
                else {
                    ++children;
                    dfs(child, node);
                    lowTime[node] = Math.min(lowTime[node], lowTime[child]);
                    if (parent != -1 && lowTime[child] >= inTime[node]) {
                        articulationPoints.add(node);
                    }
                }
            }
        }

        if (parent == -1 && children > 1) {
            articulationPoints.add(node);
        }
    }

    // Function for finding maximum and value pair
    public int doctorStrange(int n, int[][] edges) {
        //Complete the function
        graph = new ArrayList<>();
        articulationPoints = new HashSet<>();
        visited = new boolean[n];
        inTime = new int[n];
        lowTime = new int[n];
        timer = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                dfs(i, -1);
            }
        }

        return articulationPoints.size();
    }
}