//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        while (t-- > 0) {

            int n = sc.nextInt();
            List<List<String>> adj = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                List<String> l = new ArrayList<>();

                String name = sc.next();
                l.add(name);

                int tmp = sc.nextInt();

                sc.nextLine();
                for (int j = 0; j < tmp; j++) {
                    String h = sc.next();

                    l.add(h);
                }

                adj.add(l);
            }

            Solution obj = new Solution();
            List<List<String>> ans = obj.mergeDetails(adj);
            ans.sort(Comparator.comparing(x -> x.get(0)));

            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    private final HashMap<String, ArrayList<String>> graph = new HashMap<>();
    private final HashSet<String> visited = new HashSet<>();
    private final HashMap<String, String> emailToName = new HashMap<>();
    private final ArrayList<String> path = new ArrayList<>();

    private void dfs(String node) {
        visited.add(node);
        path.add(node);

        if (!graph.containsKey(node)) return;

        for (String child: graph.get(node)) {
            if (!visited.contains(child)) {
                dfs(child);
            }
        }

    }

    public List<List<String>> mergeDetails(List<List<String>> details) {
        // Your code here
        List<List<String>> ans = new ArrayList<>();
        graph.clear();
        visited.clear();
        emailToName.clear();
        path.clear();

        for (List<String> current: details) {
            String name = current.get(0);
            for (int i = 1; i < current.size(); ++i) {
                if (emailToName.containsKey(current.get(i))) {
                    name = emailToName.get(current.get(i));
                    break;
                }
            }
            if (!graph.containsKey(current.get(1))) {
                graph.put(current.get(1), new ArrayList<>());
            }
            emailToName.put(current.get(1), name);
            for (int i = 2; i < current.size(); ++i) {
                if (!graph.containsKey(current.get(i))) {
                    graph.put(current.get(i), new ArrayList<>());
                }
                graph.get(current.get(i - 1)).add(current.get(i));
                graph.get(current.get(i)).add(current.get(i - 1));
                emailToName.put(current.get(i), name);
            }
        }

        for (String node: graph.keySet()) {
            if (!visited.contains(node)) {
                dfs(node);
                Collections.sort(path);
                String name = emailToName.get(node);
                ArrayList<String> current = new ArrayList<>();
                current.add(name);
                current.addAll(path);
                ans.add(new ArrayList<>(current));
                path.clear();
            }
        }

        return ans;
    }
}