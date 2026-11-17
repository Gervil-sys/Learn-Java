package org.example.lab6.lab6_2;

public class Diplomas {

    public static long minBoxSide(long n, long w, long h) {
        long left = 1;
        long right = Math.max(w, h) * n;

        while (left < right) {
            long mid = left + (right - left) / 2;

            if (fits(n, w, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static boolean fits(long n, long w, long h, long side) {
        long perRow = side / w;
        long perCol = side / h;

        if (perRow == 0 || perCol == 0) return false;
        if (perRow > n / perCol) return true;

        return perRow * perCol >= n;
    }
}