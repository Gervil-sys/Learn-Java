package org.example.lab2.lab2_3;
import org.example.lab2.lab2_1.Sorting;
import org.example.lab2.lab2_3.Student;
import java.util.List;

public class StudentSort implements Sorting<Student> {

    private final List<Student> students;
    private final boolean byAge;

    public StudentSort(List<Student> students, boolean byAge) {
        this.students = students;
        this.byAge = byAge;
    }
    @Override
    public void sort(List<Student> list) {
        if (list != students) {
            list.clear();
            list.addAll(students);
        }

        if (byAge) {
            stableSort(list, (s1, s2) -> Integer.compare(s1.getAge(), s2.getAge()));
        } else {
            stableSort(list, (s1, s2) -> s1.getName().compareTo(s2.getName()));
        }
    }

    private void stableSort(List<Student> list, java.util.Comparator<Student> comparator) {
        int n = list.size();
        Integer[] indices = new Integer[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i;
        }

        java.util.Arrays.sort(indices, (i, j) -> {
            int cmp = comparator.compare(list.get(i), list.get(j));
            return cmp != 0 ? cmp : Integer.compare(i, j);
        });

        List<Student> temp = new java.util.ArrayList<>();
        for (int i : indices) {
            temp.add(list.get(i));
        }
        list.clear();
        list.addAll(temp);
    }
}