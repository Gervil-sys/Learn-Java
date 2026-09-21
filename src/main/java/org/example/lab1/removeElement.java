package org.example.lab1;

public class removeElement {
    public int removeElementInplace(int[] arr, int val) {
        int k = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != arr[k]) {
                arr[k] = arr[i];
                k++;
            }
        }
        return k;
    }
}
