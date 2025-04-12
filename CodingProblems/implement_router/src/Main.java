import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

class Router {
    private final Map<Integer, Packet> timestampSourceDestinationSet;
    private final Set<Packet> currentSet;
    private final int MEMORY_LIMIT;
    private final Map<Integer, ArrayList<Integer>> destinationAndTimestampsMap;
    private final Map<Integer, Integer> indexPerDestination;
    private int currentId;
    private int oldestId;

    private static class Packet {
        int source;
        int destination;
        int timestamp;

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Packet p)) return false;

            return p.source == this.source && p.destination == this.destination && p.timestamp == this.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }
    }

    public Router(int memoryLimit) {
        timestampSourceDestinationSet = new HashMap<>();
        MEMORY_LIMIT = memoryLimit;
        destinationAndTimestampsMap = new HashMap<>();
        currentSet = new HashSet<>();
        indexPerDestination = new HashMap<>();
        currentId = 0;
        oldestId = 0;
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet p = new Packet(source, destination, timestamp);

        if (currentSet.contains(p)) {
            return false;
        }

        if (timestampSourceDestinationSet.size() >= MEMORY_LIMIT) {
            forwardPacket();
        }

        timestampSourceDestinationSet.put(currentId, p);
        destinationAndTimestampsMap.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);
        currentSet.add(p);
        ++currentId;

        return true;
    }

    public int[] forwardPacket() {
        if (timestampSourceDestinationSet.isEmpty()) {
            return new int[]{};
        }

        Packet p = timestampSourceDestinationSet.get(oldestId);
        int oldSrc = p.source;
        int oldDes = p.destination;
        int oldTs = p.timestamp;
        remove(oldDes, p);

        return new int[]{oldSrc, oldDes, oldTs};
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> list = destinationAndTimestampsMap.get(destination);

        if (list == null) return 0;

        int start = indexPerDestination.getOrDefault(destination, 0);
        int right = getIndexForEqualOrGreater(list, startTime, start);

        if (right == -1) return 0;

        int left = getIndexForEqualOrLesser(list, endTime, start);

        if (left == -1) return 0;

        return (left - right + 1);
    }

    private void remove(int destination, Packet p) {
        timestampSourceDestinationSet.remove(oldestId);
        indexPerDestination.put(destination, indexPerDestination.getOrDefault(destination, 0) + 1);
        currentSet.remove(p);
        ++oldestId;
    }

    private int getIndexForEqualOrGreater(List<Integer> list, int key, int start) {
        int n = list.size();
        int left = start;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (list.get(mid) >= key) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    private int getIndexForEqualOrLesser(List<Integer> list, int key, int start) {
        int n = list.size();
        int left = start;
        int right = n - 1;
        int result = -1;

        while (left <= right) {
            int mid = (left + ((right - left) >> 1));
            if (list.get(mid) <= key) {
                result = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

public class Main {
   public static void main(String[] args) {
       Router router = new Router(2);
       System.out.println(router.addPacket(1, 1, 1));
       System.out.println(router.addPacket(1, 2, 2));
       System.out.println(router.addPacket(1, 3, 3));
       int[] packet = router.forwardPacket();
       System.out.println(packet[0] + " " + packet[1] + " " + packet[2]);
       System.out.println(router.getCount(1, 4, 5));
   }
}
