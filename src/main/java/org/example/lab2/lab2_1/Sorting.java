package org.example.lab2.lab2_1;
import java.util.List;

public interface Sorting<T extends Comparable<T>> {
    void sort(List<T>nums);
}
