// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

public class Main
{
    public static void main(String[] args) throws IOException {

        BufferedReader read =
                new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String[] str = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);

            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<>());
            }

            int i=0;
            while (i++<E) {
                String[] S = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<>();
                ArrayList<Integer> t2 = new ArrayList<>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }

            int S = Integer.parseInt(read.readLine());

            int[] ptr = Solution.dijkstra(V, adj, S);

            for(i=0; i<V; i++)
                System.out.print(ptr[i] + " ");
            System.out.println();
        }
    }
}// } Driver Code Ends


//User function Template for Java


class Solution
{
    private static class PAIR {
        public int a;
        public int b;

        public PAIR(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int v, ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {
        // Write your code here
        int[] distance = new int[v];
        PriorityQueue<PAIR> pq = new PriorityQueue<>((a, b) -> (a.a != b.a ? a.a - b.a : a.b - b.b));

        for (int i = 0; i < v; ++i) {
            distance[i] = Integer.MAX_VALUE;
        }

        pq.add(new PAIR(0, s));
        distance[s] = 0;

        while (!pq.isEmpty()) {
            PAIR current = pq.poll();
            int node = current.b;
            for (ArrayList<Integer> child : adj.get(node)) {
                int childNode = child.get(0);
                int weight = child.get(1);
                if (distance[childNode] > distance[node] + weight) {
                    distance[childNode] = distance[node] + weight;
                    pq.add(new PAIR(distance[childNode], childNode));
                }
            }
        }

        return distance;
    }
}

