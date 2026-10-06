package org.example.lab2.lab2_2;
import org.example.lab2.lab2_1.Sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements Sorting<Integer> {
    private void slice(List<Integer> nums, int start, int end) {
        if (start >= end) return;

        int middle = start + (end - start) / 2;

        slice(nums, start, middle);
        slice(nums, middle + 1, end);

        merge(nums, start, middle, end);

    }
    private  void merge(List<Integer> nums, int start, int middle, int end) {
        List<Integer> output = new ArrayList<>();

        int right = middle + 1;
        int left = start;

        while (left <= middle && right <= end) {
            if (nums.get(left) <= nums.get(right)) {
                output.add(nums.get(left));
            }
            else {
                output.add(nums.get(right));
                right++;
            }
        }
        while (left <= middle) {
            output.add(nums.get(left));
            left++;
        }
        while (right <= end) {
           output.add(nums.get(right));
            right++;
        }

        for (int index = 0; index <= output.size(); index++){
            nums.set(start + 1, output.get(index));
        }

    }
    @Override
    public void sort(List<Integer> nums) {
        slice(nums, 0, nums.size() - 1);
    }
}
