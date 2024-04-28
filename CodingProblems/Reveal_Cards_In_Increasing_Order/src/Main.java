import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        int[] answer = new int[n];
        Deque<Integer> deque = new LinkedList<>();

        Arrays.sort(deck);

        for (int i = 0; i < n; ++i) {
            deque.add(i);
        }

        for (int cardNumber : deck) {
            assert deque.size() > 0;
            int idx = deque.poll();
            answer[idx] = cardNumber;
            if (!deque.isEmpty()) {
                deque.add(deque.poll());
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
            int[] deck = new int[n];

            for (int i = 0; i < n; ++i) {
                deck[i] = sc.nextInt();
            }

            Solution solution = new Solution();
            int[] answer = solution.deckRevealedIncreasing(deck);
            for (int x : answer) {
                System.out.print(x + " ");
            }
            System.out.println();
        }

        sc.close();
    }
}
