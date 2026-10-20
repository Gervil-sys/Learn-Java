package org.example.lab3.lab3_1;
import org.example.lab2.lab2_1.Sorting;
import java.util.List;

public class CountingSort implements Sorting<Integer> {

    @Override
    public void sort(List<Integer> nums) {
        int max = 127;
        int[] cnt = new int[max + 1];

        for (int num : nums) {
            cnt[num]++;
        }

        int index = 0;
        for (int i = 0; i <= max; i++) {
            for (int j = 0; j < cnt[i]; j++) {
                nums.set(index++, i);
            }
        }
    }
}