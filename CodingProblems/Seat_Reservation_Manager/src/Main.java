import java.util.Scanner;
import java.util.TreeMap;
import java.util.TreeSet;

class SeatManager {
    private final TreeSet<Integer> reservedSeats;
    private final TreeSet<Integer> unreservedSeats;

    public SeatManager(int n) {
        reservedSeats = new TreeSet<>();
        unreservedSeats = new TreeSet<>();

        for (int i = 1; i <= n; ++i) {
            unreservedSeats.add(i);
        }
    }

    public int reserve() {
        int seat = unreservedSeats.pollFirst();
        reservedSeats.add(seat);

        return seat;
    }

    public void unreserve(int seatNumber) {
        reservedSeats.remove(seatNumber);
        unreservedSeats.add(seatNumber);
    }
}

/**
 * Your SeatManager object will be instantiated and called as such:
 * SeatManager obj = new SeatManager(n);
 * int param_1 = obj.reserve();
 * obj.unreserve(seatNumber);
 */

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
        }

        sc.close();
    }
}
