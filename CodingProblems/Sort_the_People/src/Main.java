import java.util.Arrays;
import java.util.Scanner;

class Solution {
    private static class Pair {
        int first;
        String second;

        Pair(int first, String second) {
            this.first = first;
            this.second = second;
        }
    }

    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        Pair[] nameWithHeight = new Pair[n];

        for (int i = 0; i < n; ++i) {
            nameWithHeight[i] = new Pair(heights[i], names[i]);
        }

        Arrays.sort(nameWithHeight, (a, b) -> b.first - a.first);

        for (int i = 0; i < n; ++i) {
            names[i] = nameWithHeight[i].second;
        }

        return names;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int n = sc.nextInt();
            String[] names = new String[n];
            for (int i = 0; i < n; ++i) {
                names[i] = sc.next();
            }
            int[] heights = new int[n];
            for (int i = 0; i < n; ++i) {
                heights[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            String[] ans = solution.sortPeople(names, heights);
            for (int i = 0; i < n; ++i) {
                System.out.println(ans[i]);
            }
        }

        sc.close();
    }
}
