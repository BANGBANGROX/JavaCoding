import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class MyCalendar {
    ArrayList<ArrayList<Integer>> intervals;

    private boolean check(int l, int r, int key) {
        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (mid == key) return false;
            if (mid > key) r = mid - 1;
            else l = mid + 1;
        }

        return true;
    }

    public MyCalendar() {
        intervals = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        if (intervals.isEmpty()) {
            intervals.add(new ArrayList<>(Arrays.asList(start, end)));
            return true;
        }

        int pos = -1;

        for (int i = 0; i < intervals.size(); ++i) {
            int l = intervals.get(i).get(0);
            int r = intervals.get(i).get(1);
            if (l == start || r == end || !check(start, end - 1, l) || !check(start, end - 1, r - 1) || !check(l, r - 1, start) || !check(l, r - 1, end - 1)) {
                // if (start == 28 && end == 36) {
                // System.out.println(check(start, end - 1, l));
                // System.out.println(check(start, end - 1, r - 1));
                // System.out.println(i);
                // }
                return false;
            }
            if (start < l && pos == -1) {
                pos = i;
            }
        }

        if (pos == -1) intervals.add(new ArrayList<>(Arrays.asList(start, end)));
        else intervals.add(pos, new ArrayList<>(Arrays.asList(start, end)));

        //System.out.println(intervals);

        return true;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
