import java.util.TreeMap;

class MyCalendarThree {
    private final TreeMap<Integer, Integer> mp;

    public MyCalendarThree() {
        mp = new TreeMap<>();
    }

    public int book(int start, int end) {
        mp.put(start, mp.getOrDefault(start, 0) + 1);
        mp.put(end, mp.getOrDefault(end, 0) - 1);

        int current = 0;
        int ans = 0;

        for (int x: mp.values()) {
            current += x;
            ans = Math.max(ans, current);
        }

        return ans;
    }
}


public class Main {
    public static void main(String[] args) {
        MyCalendarThree myCalendarThree = new MyCalendarThree();

        System.out.println(myCalendarThree.book(10, 20)); // return 1, The first event can be booked and is disjoint, so the maximum k-booking is a 1 - booking.
        System.out.println(myCalendarThree.book(50, 60)); // return 1, The second event can be booked and is disjoint, so the maximum k-booking is a 1 - booking.
        System.out.println(myCalendarThree.book(10, 40)); // return 2, The third event [10, 40) intersects the first event, and the maximum k-booking is a 2 - booking.
        System.out.println(myCalendarThree.book(5, 15)); // return 3, The remaining events cause the maximum K-booking to be only a 3 - booking.
        System.out.println(myCalendarThree.book(5, 10)); // return 3
        System.out.println(myCalendarThree.book(25, 55)); // return 3
    }
}
