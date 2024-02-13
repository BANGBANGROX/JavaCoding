import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public List<Integer> beautifulIndices(String s, String a, String b, int k) {
        ArrayList<Integer> aIndices = new ArrayList<>();
        ArrayList<Integer> bIndices = new ArrayList<>();
        List<Integer> answer = new ArrayList<>();

        for (int i = 0; i < s.length(); ++i) {
            String aSubString = s.substring(i, Math.min(i + a.length(), s.length()));
            String bSubString = s.substring(i, Math.min(i + b.length(), s.length()));
            if (a.equals(aSubString)) {
                aIndices.add(i);
            }
            if (b.equals(bSubString)) {
                bIndices.add(i);
            }
        }

        int ptr1 = 0;
        int ptr2 = 0;

        while (ptr1 < aIndices.size() && ptr2 < bIndices.size()) {
            int i = aIndices.get(ptr1);
            int j = bIndices.get(ptr2);
            if (Math.abs(i - j) <= k) {
                answer.add(i);
                ++ptr1;
            }
            else if (i > j) {
                ++ptr2;
            }
            else {
                ++ptr1;
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
            String a = sc.next();
            String b = sc.next();
            int k = sc.nextInt();

            Solution solution = new Solution();
            System.out.println(solution.beautifulIndices(s, a, b, k));
        }

        sc.close();
    }
}
