//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;


public class Main {

    // Driver code

    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        Complete obj = new Complete();
        obj.precompute();
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] element = line.trim().split("\\s+");
            int N = Integer.parseInt(element[0]);
            int M = Integer.parseInt(element[1]);
            int[][] arr = new int[M][2];
            for (int i = 0; i < M; i++) {
                line = br.readLine();
                String[] elements = line.trim().split("\\s+");
                arr[i][0] = Integer.parseInt(elements[0]);
                arr[i][1] = Integer.parseInt(elements[1]);
            }
            int ans = obj.helpSanta(N, M, arr);
            System.out.println(ans);

        }
    }
}




// } Driver Code Ends


//User function Template for Java


class Complete {
    private ArrayList<Integer> primeNumbers;
    private ArrayList<ArrayList<Integer>> graph;
    private int currentSize;
    private boolean[] visited;

    public void precompute() {
        //Complete the function
        primeNumbers = new ArrayList<>();
        final int MAX_N = (int) 5e6;
        boolean[] prime = new boolean[MAX_N + 1];

        Arrays.fill(prime, true);

        prime[1] = false;

        for (int i = 2; i <= MAX_N; ++i) {
            if (prime[i]) {
                primeNumbers.add(i);
                for (int j = 2 * i; j <= MAX_N; j += i) {
                    prime[j] = false;
                }
            }
        }
    }

    private void dfs(int node) {
        visited[node] = true;

        for (int child : graph.get(node)) {
            if (!visited[child]) {
                dfs(child);
            }
        }

        ++currentSize;
    }

    // Function for finding maximum and value pair
    public int helpSanta(int n, int m, int[][] relations) {
        //Complete the function
        if (m == 0) return -1;

        graph = new ArrayList<>();
        visited = new boolean[n];
        int maximumSize = 0;

        for (int i = 0; i < n; ++i) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < m; ++i) {
            int u = relations[i][0] - 1;
            int v = relations[i][1] - 1;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        for (int i = 0; i < n; ++i) {
            if (!visited[i]) {
                currentSize = 0;
                dfs(i);
                maximumSize = Math.max(maximumSize, currentSize);
            }
        }

        return primeNumbers.get(maximumSize - 1);
    }
}