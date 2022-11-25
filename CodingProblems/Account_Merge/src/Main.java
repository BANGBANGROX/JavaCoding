//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            List<List<String>> accounts = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                ArrayList<String> temp = new ArrayList<>();
                int x = sc.nextInt();
                for (int j = 0; j < x; j++) {
                    String s1 = sc.next();
                    temp.add(s1);
                }
                accounts.add(temp);
            }
            Solution obj = new Solution();
            List<List<String>> res = obj.accountsMerge(accounts);
            res.sort((a, b) -> {
                int al = a.size();
                int bl = b.size();
                int min = Math.min(al, bl);
                for (int i = 0; i < min; i++) {
                    String xx = a.get(i);
                    String yy = b.get(i);
                    if (xx.compareTo(yy) < 0)
                        return -1;
                    else if (xx.compareTo(yy) > 0)
                        return 1;
                }
                if (al < bl)
                    return -1;
                else if (al > bl)
                    return 1;
                return -1;
            });
            System.out.print("[");
            for (int i = 0; i < res.size(); ++i) {
                System.out.print("[");
                for (int j = 0; j < res.get(i).size(); j++) {
                    if (j != res.get(i).size() - 1)
                        System.out.print(res.get(i).get(j) + ", ");
                    else
                        System.out.print(res.get(i).get(j));
                }
                if (i != res.size() - 1)
                    System.out.println("], ");
                else
                    System.out.print("]");
            }
            System.out.println("]");
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    private final HashMap<String, ArrayList<String>> graph = new HashMap<>();
    private final HashSet<String> visited = new HashSet<>();
    private final ArrayList<String> currentResult = new ArrayList<>();

    private void dfs(String currentString) {
        visited.add(currentString);

        for (String next : graph.getOrDefault(currentString, new ArrayList<>())) {
            if (!visited.contains(next)) dfs(next);
        }

        currentResult.add(currentString);
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        // code here
        LinkedHashMap<String, String> emailToName = new LinkedHashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (List<String> currentAccount : accounts) {
            String name = currentAccount.get(0);
            String firstMail = currentAccount.get(1);
            if (!emailToName.containsKey(firstMail)) {
                emailToName.put(firstMail, name);
            }
            int n = currentAccount.size();
            for (int i = 2; i < n; ++i) {
                if (!graph.containsKey(currentAccount.get(i - 1))) {
                    graph.put(currentAccount.get(i - 1), new ArrayList<>());
                }
                if (!graph.containsKey(currentAccount.get(i))) {
                    graph.put(currentAccount.get(i), new ArrayList<>());
                }
                graph.get(currentAccount.get(i - 1)).add(currentAccount.get(i));
                graph.get(currentAccount.get(i)).add(currentAccount.get(i - 1));
            }
        }

        for (String currentString : emailToName.keySet()) {
            if (visited.contains(currentString)) continue;
            dfs(currentString);
            currentResult.sort(Collections.reverseOrder());
            currentResult.add(emailToName.get(currentString));
            Collections.reverse(currentResult);
            ans.add(new ArrayList<>(currentResult));
            currentResult.clear();
        }

        return ans;
    }
}
     