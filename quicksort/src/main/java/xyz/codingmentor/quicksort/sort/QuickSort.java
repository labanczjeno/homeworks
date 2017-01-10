
package xyz.codingmentor.quicksort.sort;

import java.util.List;

public class QuickSort<T extends Comparable<T>> {

    public void qsort(List<T> values, int low, int high) {
        if (low < high) {
            int i = low, j = high;
            T point = values.get((i + j) / 2);

            do {
                while (values.get(i).compareTo(point) < 0) {
                    i++;
                }
                while (point.compareTo(values.get(j)) < 0) {
                    j--;
                }

                if (i <= j) {
                    T tp = values.get(i);
                    values.add(i, values.get(j));
                    values.remove(i + 1);
                    values.add(j, tp);
                    values.remove(j + 1);
                    i++;
                    j--;
                }

            } while (i <= j);

            qsort(values, low, j);
            qsort(values, i, high);
        }
    }

}
