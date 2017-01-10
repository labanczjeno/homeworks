
package xyz.codingmentor.quicksort.sort;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private Main() {
        //hide default constructor
    }
    private static final Logger LOGGER = Logger.getAnonymousLogger();

    public static void main(String[] args) {
        List<Integer> list = new ArrayList();
        Random random = new Random();
        for (int i = 0; i < random.nextInt(100); i++) {
            list.add(random.nextInt(100));
        }
        QuickSort<Integer> quicksort = new QuickSort<>();
        LOGGER.log(Level.INFO, list.toString());
        quicksort.qsort(list, 0, list.size() - 1);
        LOGGER.log(Level.INFO, list.toString());
    }
}