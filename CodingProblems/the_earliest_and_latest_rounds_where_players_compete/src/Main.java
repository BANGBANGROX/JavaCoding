import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    private Map<List<Integer>, int[]> dp;
    private int firstPlayer;
    private int secondPlayer;

    public int[] earliestAndLatest(final int n, final int firstPlayer, final int secondPlayer) {
        final List<Integer> playersList = new ArrayList<>();
        dp = new HashMap<>();
        this.firstPlayer = Math.min(firstPlayer, secondPlayer);
        this.secondPlayer = Math.max(firstPlayer, secondPlayer);

        for (int i = 1; i <= n; ++i) {
            playersList.add(i);
        }

        return earliestAndLatestHandler(playersList);
    }

    private int[] earliestAndLatestHandler(final List<Integer> playersList) {
        if (dp.containsKey(playersList)) {
            return dp.get(playersList);
        }

        int i = 0;
        int j = playersList.size() - 1;
        int minRound = Integer.MAX_VALUE;
        int maxRound = Integer.MIN_VALUE;
        final List<List<Integer>> matchups = new ArrayList<>();

        while (i < j) {
            final List<Integer> currentMatch = List.of(playersList.get(i), playersList.get(j));

            if (currentMatch.contains(firstPlayer) && currentMatch.contains(secondPlayer)) {
                return new int[]{1, 1};
            } else if (currentMatch.contains(firstPlayer)) {
                matchups.add(List.of(firstPlayer));
            } else if (currentMatch.contains(secondPlayer)) {
                matchups.add(List.of(secondPlayer));
            } else {
                matchups.add(currentMatch);
            }

            ++i;
            --j;
        }

        if (i == j) {
            matchups.add(List.of(playersList.get(i)));
        }

        final List<List<Integer>> newPlayersLists = generateNextLists(matchups);

        for (final List<Integer> newPlayersList : newPlayersLists) {
            Collections.sort(newPlayersList);

            final int[] result = earliestAndLatestHandler(newPlayersList);
            minRound = Math.min(minRound, result[0] + 1);
            maxRound = Math.max(maxRound, result[1] + 1);
        }

        dp.put(playersList, new int[]{minRound, maxRound});

        return dp.get(playersList);
    }

    private List<List<Integer>> generateNextLists(final List<List<Integer>> matchupWinners) {
        List<List<Integer>> result = new ArrayList<>();

        result.add(new ArrayList<>());

        for (final List<Integer> pool : matchupWinners) {
            final List<List<Integer>> newResult = new ArrayList<>();

            for (final List<Integer> partial : result) {
                for (final int item : pool) {
                    final List<Integer> extended = new ArrayList<>(partial);

                    extended.add(item);
                    newResult.add(extended);
                }
            }

            result = newResult;
        }

        return result;
    }
}

public class Main {
   public static void main(String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           final int[] answer = new Solution().earliestAndLatest(scanner.nextInt(),
                   scanner.nextInt(), scanner.nextInt());
           System.out.println(answer[0] + " " + answer[1]);
       }
       
       scanner.close();
   }
}
