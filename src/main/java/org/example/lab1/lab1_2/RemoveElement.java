package org.example.lab1.lab1_2;
import java.util.List;

public class RemoveElement {
    public int removeElementInplace(List<Integer> arr, int val) {
        int k = 0;

        for (int i = 0; i < arr.size(); i++) {
            if (arr.get(i) != arr.get(k)) {
                arr.set(k, arr.get(i));
                k++;
            }
        }
        return k;
    }
}
