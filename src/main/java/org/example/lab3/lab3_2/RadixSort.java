package org.example.lab3.lab3_2;
import org.example.lab2.lab2_1.Sorting;
import java.math.BigInteger;
import java.util.List;
import java.util.ArrayList;

public class RadixSort implements Sorting<BigInteger> {
    @Override
    public void sort(List<BigInteger> nums) {
        if (nums.isEmpty()) return;

        List<List<BigInteger>> input = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            input.add(new ArrayList<>());
        }

        for (int pos = 19; pos >= 0; pos--) {
            for (BigInteger num : nums) {
                String digits = num.toString();

                int digit = digits.charAt(pos) - '0';

                input.get(digit).add(num);
            }

            int index = 0;

            for (int i = 0; i < 10; i++) {
                for (BigInteger num : input.get(i)) {
                    nums.set(index, num);
                    index++;
                }
                input.get(i).clear();
            }
        }
    }
}
