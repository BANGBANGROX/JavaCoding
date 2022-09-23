import java.util.*;

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> mp = new HashMap<>();

        if (paths.length == 0) return ans;

        for (String path: paths) {
            String[] strings = path.split(" ");
            String directory = strings[0];
            for (int i = 1; i < strings.length; ++i) {
                int idx = strings[i].indexOf('(');
                String content = strings[i].substring(idx);
                String filename = directory + '/' + strings[i].substring(0, idx);
                ArrayList<String> filenames = mp.getOrDefault(content, new ArrayList<>());
                filenames.add(filename);
                mp.put(content, filenames);
            }
        }

        for (String key: mp.keySet()) {
            if (mp.get(key).size() > 1)
                ans.add(new ArrayList<>(mp.get(key)));
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
            String[] paths = new String[n];
            for (int i = 0; i < n; ++i) {
                paths[i] = sc.next();
            }

            Solution solution = new Solution();
            System.out.println(solution.findDuplicate(paths));
        }

        sc.close();
    }
}
