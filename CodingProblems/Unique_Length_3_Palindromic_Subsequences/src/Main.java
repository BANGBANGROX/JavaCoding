import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

class Solution {
    public int countPalindromicSubsequence(String s) {
        int n = s.length();
        int answer = 0;
        HashMap<Character, ArrayList<Integer>> characterIndex = new HashMap<>();

        for (int i = 0; i < n; ++i) {
            characterIndex.computeIfAbsent(s.charAt(i), k -> new ArrayList<>()).add(i);
        }

        for (char ch1 : characterIndex.keySet()) {
            ArrayList<Integer> indexes = characterIndex.get(ch1);
            if (indexes.size() == 1) continue;
            if (indexes.size() > 2) {
                ++answer;
            }
            int firstIndex = indexes.get(0);
            int lastIndex = indexes.get(indexes.size() - 1);
            for (char ch2 : characterIndex.keySet()) {
                if (ch1 != ch2) {
                    ArrayList<Integer> indexes2 = characterIndex.get(ch2);
                    for (int x : indexes2) {
                        if (firstIndex < x && lastIndex > x) {
                            ++answer;
                            break;
                        }
                    }
                }
            }
        }

        return answer;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.countPalindromicSubsequence(s));
        }

        sc.close();
    }
}
