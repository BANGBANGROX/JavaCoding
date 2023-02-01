import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

class SummaryRanges {
    private final Set<Integer> st;

    public SummaryRanges() {
        st = new TreeSet<>();
    }

    public void addNum(int value) {
        st.add(value);
    }

    public int[][] getIntervals() {
        if (st.isEmpty()) return new int[0][2];

        ArrayList<int[]> ans = new ArrayList<>();
        int left = -1;
        int right = -1;

        for (int x : st) {
            if (left == -1) {
                left = right = x;
            } else if (x == right + 1) {
                right = x;
            } else {
                ans.add(new int[]{left, right});
                left = right = x;
            }
        }

        ans.add(new int[]{left, right});

        return ans.toArray(new int[0][]);
    }
}

public class Main {
    static void print(int[][] result) {
        for (int[] x : result) {
            for (int y : x) {
                System.out.print(y + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        SummaryRanges summaryRanges = new SummaryRanges();
        summaryRanges.addNum(1);      // arr = [1]
        print(summaryRanges.getIntervals()); // return [[1, 1]]
        summaryRanges.addNum(3);      // arr = [1, 3]
        print(summaryRanges.getIntervals()); // return [[1, 1], [3, 3]]
        summaryRanges.addNum(7);      // arr = [1, 3, 7]
        print(summaryRanges.getIntervals()); // return [[1, 1], [3, 3], [7, 7]]
        summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
        print(summaryRanges.getIntervals()); // return [[1, 3], [7, 7]]
        summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
        print(summaryRanges.getIntervals()); // return [[1, 3], [6, 7]]
    }
}
