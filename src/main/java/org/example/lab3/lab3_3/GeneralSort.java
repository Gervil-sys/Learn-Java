package  org.example.lab3.lab3_3;
import org.example.lab2.lab2_1.Sorting;
import org.example.lab2.lab2_3.StudentSort;
import java.util.List;

public class GeneralSort<T extends Comparable<T>> implements Sorting<T> {
    private final List<T> nums;
    private final java.util.Comparator<T> comparator;

    public GeneralSort(List<T> list, java.util.Comparator<T> comparator) {
        this.nums = list;
        this.comparator = comparator;
    }

    @Override
    public void sort(List<T> ignored) {
        nums.sort(comparator);
    }
}