import java.util.*;

class Solution {
    private HashSet<Integer> secretKnownNodes;
    private HashMap<Integer, ArrayList<Integer>> graph;

    private void dfs(int node) {
        for (int child : graph.get(node)) {
            if (secretKnownNodes.contains(node) && !secretKnownNodes.contains(child)) {
                if (secretKnownNodes.contains(node)) {
                    secretKnownNodes.add(child);
                    dfs(child);
                }
            }
        }
    }

    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, HashMap<Integer, ArrayList<Integer>>> timeGraph = new TreeMap<>();
        secretKnownNodes = new HashSet<>();

        secretKnownNodes.add(0);
        secretKnownNodes.add(firstPerson);

        for (int[] meeting : meetings) {
            int x = meeting[0];
            int y = meeting[1];
            int time = meeting[2];
            timeGraph.computeIfAbsent(time, k -> new HashMap<>()).computeIfAbsent(x, l -> new ArrayList<>()).add(y);
            timeGraph.computeIfAbsent(time, k -> new HashMap<>()).computeIfAbsent(y, l -> new ArrayList<>()).add(x);
        }

        for (int time : timeGraph.keySet()) {
            graph = timeGraph.get(time);
            for (int node : graph.keySet()) {
                if (secretKnownNodes.contains(node)) {
                    dfs(node);
                }
            }
        }

        return new ArrayList<>(secretKnownNodes);
    }
}

public class Main {
  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      int T = sc.nextInt();
      
      while (T-- > 0) {
          int n = sc.nextInt();
          int m = sc.nextInt();
          int[][] meetings = new int[m][3];
          for (int i = 0; i < m; ++i) {
              meetings[i][0] = sc.nextInt();
              meetings[i][1] = sc.nextInt();
              meetings[i][2] = sc.nextInt();
          }
          int firstPerson = sc.nextInt();

          Solution solution = new Solution();
          System.out.println(solution.findAllPeople(n, meetings, firstPerson));
      }
      
      sc.close(); 
  }
}
