import java.util.*;

class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Map<String, Set<String>> graph = new HashMap<>();
        int n = recipes.length;

        for (int i = 0; i < n; ++i) {
            graph.put(recipes[i], new HashSet<>(ingredients.get(i)));
        }

        List<String> ans = new ArrayList<>();

        Queue<String> q = new LinkedList<>(Arrays.asList(supplies));

        while (!q.isEmpty()) {
            String supply = q.poll();
            Set<String> recipesToBeRemoved = new HashSet<>();
            for (String recipe : graph.keySet()) {
                if (graph.get(recipe).contains(supply)) {
                    graph.get(recipe).remove(supply);
                }
                if (graph.get(recipe).size() == 0) {
                    q.add(recipe);
                    ans.add(recipe);
                    recipesToBeRemoved.add(recipe);
                }
            }
            for (String recipe : recipesToBeRemoved) {
                graph.remove(recipe);
            }
        }

        return ans;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] recipes = new String[n];
            for (int i = 0; i < n; ++i) recipes[i] = sc.next();
            List<List<String>> ingredients = new ArrayList<>();
            for (int i = 0; i < n; ++i) {
                int m = sc.nextInt();
                List<String> curr = new ArrayList<>();
                for (int j = 0; j < m; ++j) {
                    String s = sc.next();
                    curr.add(s);
                }
                ingredients.add(new ArrayList<>(curr));
            }
            int m = sc.nextInt();
            String[] supplies = new String[m];
            for (int i = 0; i < m; ++i) {
                supplies[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.findAllRecipes(recipes, ingredients, supplies));
        }

        sc.close();
    }
}
