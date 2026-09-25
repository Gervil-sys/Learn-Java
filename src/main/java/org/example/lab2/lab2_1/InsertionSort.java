package org.example.lab2.lab2_1;
import java.util.List;

public class InsertionSort implements Sorting<Integer> {
    @Override
    public void sort(List<Integer> nums) {
        for (int i = 1; i < nums.size(); i++) {
            int index = nums.get(i);
            int move = i - 1;

            while (move >= 0 && nums.get(move) > index) {
                nums.set(move + 1, nums.get(move));
                move--;
            }
            nums.set(move + 1, index);
        }
    }
}
