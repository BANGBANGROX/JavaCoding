import java.util.*;

class Solution {
    public String customSortString(String order, String s) {
        HashMap<Character, Integer> givenOrder = new HashMap<>();
        ArrayList<Character> orderChars = new ArrayList<>();
        StringBuilder answer = new StringBuilder();

        for (int i = 0; i < order.length(); ++i) {
            givenOrder.put(order.charAt(i), i);
        }

        for (char ch : s.toCharArray()) {
            orderChars.add(ch);
        }

        orderChars.sort(Comparator.comparingInt(a -> givenOrder.getOrDefault(a, Integer.MAX_VALUE)));

        for (char ch : orderChars) {
            answer.append(ch);
        }

        return answer.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            String order = sc.next();
            String s = sc.next();

            Solution solution = new Solution();
            System.out.println(solution.customSortString(order, s));
        }

        sc.close();
    }
}
