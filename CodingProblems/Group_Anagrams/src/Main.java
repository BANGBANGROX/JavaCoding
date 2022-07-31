import java.util.*;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, ArrayList<String>> mp = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();

        for (String s : strs) {
            char[] tempArray = s.toCharArray();
            Arrays.sort(tempArray);
            String sortedS = new String(tempArray);
            if (!mp.containsKey(sortedS)) {
                mp.put(sortedS, new ArrayList<>());
            }
            mp.get(sortedS).add(s);
        }

        for (String x : mp.keySet()) {
            ans.add(new ArrayList<>(mp.get(x)));
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
            String[] strs = new String[n];

            for (int i = 0; i < n; ++i) {
                strs[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.groupAnagrams(strs));
        }

        sc.close();
    }
}
