import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

class Solution {
    public String[] shortestSubstrings(String[] arr) {
        int n = arr.length;
        String[] answer = new String[n];
        ArrayList<TreeSet<String>> subStrings = new ArrayList<>();

        Arrays.fill(answer, "");

        for (String s : arr) {
            TreeSet<String> currentSubStrings = new TreeSet<>((a, b) -> a.length() != b.length() ? a.length() - b.length() : a.compareTo(b));
            for (int i = 0; i < s.length(); ++i) {
                String currentString = "";
                for (int j = i; j < s.length(); ++j) {
                    currentString += s.charAt(j);
                    currentSubStrings.add(currentString);
                }
            }
            subStrings.add(new TreeSet<>(currentSubStrings));
        }

        for (int i = 0; i < n; ++i) {
            TreeSet<String> currentSubStrings = subStrings.get(i);
            for (String s : currentSubStrings) {
                boolean canTakeInAnswer = true;
                for (int j = 0; j < n; ++j) {
                    if (i != j) {
                        if (subStrings.get(j).contains(s)) {
                            canTakeInAnswer = false;
                            break;
                        }
                    }
                }
                if (canTakeInAnswer) {
                    answer[i] = s;
                    break;
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
            int n = sc.nextInt();
            String[] arr = new String[n];
            for (int i = 0; i < n; ++i) {
                arr[i] = sc.next();
            }

            Solution solution = new Solution();
            String[] answer = solution.shortestSubstrings(arr);
            for (String res : answer) {
                System.out.print(res + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
