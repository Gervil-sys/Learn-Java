package org.example.lab6.lab6_1;
import java.util.List;

public class NearestSearch {
    public static int findNearest(List<Integer> sorted, int query) {
        int left = 0;
        int right = sorted.size() - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int value = sorted.get(mid);

            if (value == query) {
                return value;
            } else if (value < query) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        if (left == 0) return sorted.get(0);
        if (left == sorted.size()) return sorted.get(sorted.size() - 1);

        int smaller = sorted.get(right);
        int bigger = sorted.get(left);

        return (query - smaller <= bigger - query) ? smaller : bigger;
    }
}
