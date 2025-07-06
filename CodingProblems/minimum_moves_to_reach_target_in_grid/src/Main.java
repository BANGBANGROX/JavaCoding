import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

class Solution {
    public int minMoves(final int sx, final int sy, final int tx, final int ty) {
        final Queue<List<Integer>> queue = new LinkedList<>();
        final Map<List<Integer>, Integer> distance = new HashMap<>();

        queue.add(List.of(tx, ty));
        distance.put(List.of(tx, ty), 0);

        while (!queue.isEmpty()) {
            final List<Integer> current = queue.poll();
            final int x = current.getFirst();
            final int y = current.get(1);
            final int currentDistance = distance.get(current);

            if (x == sx && y == sy) {
                return currentDistance;
            }

            if (x < sx || y < sy) {
                continue;
            }

            if (x < y) {
                final int newY = getNext(y, x);

                if (newY != -1) {
                    final List<Integer> next = List.of(x, newY);

                    if (!distance.containsKey(next)) {
                        distance.put(next, currentDistance + 1);
                        queue.add(next);
                    }
                }
            } else if (x > y) {
                final int newX = getNext(x, y);

                if (newX != -1) {
                    final List<Integer> next = List.of(newX, y);

                    if (!distance.containsKey(next)) {
                        distance.put(next, currentDistance + 1);
                        queue.add(next);
                    }
                }
            } else {
                final List<Integer> first = List.of(x, 0);
                final List<Integer> second = List.of(0, y);

                if (!distance.containsKey(first)) {
                    distance.put(first, currentDistance + 1);
                    queue.add(first);
                }

                if (!distance.containsKey(second)) {
                    distance.put(second, currentDistance + 1);
                    queue.add(second);
                }
            }
        }

        return -1;
    }

    // Assumes a > b
    private int getNext(final int a, final int b) {
        int diff = b;

        if ((a & 1) == 0) {
            diff = Math.max(diff, a / 2);
        } else {
            if (a > diff * 2) {
                return -1;
            }
        }

        return a - diff;
    }
}

public class Main {
   public static void main(final String[] args) {
       final Scanner scanner = new Scanner(System.in);
       int testCases = scanner.nextInt();
       
       while (testCases-- > 0) {
           System.out.println(new Solution().minMoves(scanner.nextInt(), scanner.nextInt(),
                   scanner.nextInt(), scanner.nextInt()));
       }
       
       scanner.close();
   }
}
