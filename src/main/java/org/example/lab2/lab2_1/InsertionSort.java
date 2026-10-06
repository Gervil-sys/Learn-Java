package org.example.lab2.lab2_1;
import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

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

    public static void main(String[] args) {
        List<Integer> number = new ArrayList<>(List.of(21, 22, 3, 1, 1, 4, 23, 21, 28, 2, 89, 100));
        InsertionSort sorter = new InsertionSort();
        sorter.sort(number);
        System.out.println(number);
    }
}

