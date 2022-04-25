import java.util.*;

class TimeMap {
    private final HashMap<String, ArrayList<Integer>> keyToTimestamps;
    private final HashMap<Integer, ArrayList<String>> timestampToKey;

    public TimeMap() {
       keyToTimestamps = new HashMap<>();
       timestampToKey = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
       if (keyToTimestamps.containsKey(key)) {
           keyToTimestamps.get(key).add(timestamp);
       }
       else {
           keyToTimestamps.put(key, new ArrayList<>(List.of(timestamp)));
       }

       timestampToKey.put(timestamp, new ArrayList<>(Arrays.asList(key, value)));
    }

    public String get(String key, int timestamp) {
        if (!keyToTimestamps.containsKey(key)) return "";

        int l = 0;
        int r = keyToTimestamps.get(key).size() - 1;
        int ans = -1;

        while (l <= r) {
            int mid = (l + ((r - l) >> 1));
            if (keyToTimestamps.get(key).get(mid) > timestamp) {
                r = mid - 1;
            }
            else {
                ans = mid;
                l = mid + 1;
            }
        }

        if (ans == -1) return "";

        return timestampToKey.get(keyToTimestamps.get(key).get(ans)).get(1);
    }
}

public class Main {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();

        timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
        System.out.println(timeMap.get("foo", 1));         // return "bar"
        System.out.println(timeMap.get("foo", 3));         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
        timeMap.set("foo", "bar2", 4); // store the key "foo" and value "bar2" along with timestamp = 4.
        System.out.println(timeMap.get("foo", 4));         // return "bar2"
        System.out.println(timeMap.get("foo", 5));         // return "bar2"
    }
}
