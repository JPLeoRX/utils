package com.tekleo.utils;

import java.util.Comparator;
import java.util.List;

public class ListUtils {
    /**
     * Is the list sorted?
     * @param list list to check
     * @param comparator ordering comparator for checks
     * @param <O> any generic type
     * @return true if it is sorted (or if the list is empty, or if it has only 1 element), false if it's not
     */
    public static <O> boolean isSorted(List<O> list, Comparator<O> comparator) {
        // Special cases
        if (list == null)
            throw new IllegalArgumentException("List can't be null");
        if (comparator == null)
            throw new IllegalArgumentException("Comparator can't be null");
        if (list.size() <= 1)
            return true;

        // For each element of the list
        for (int i = 1; i < list.size(); i++) {
            // Get previous and current elements
            O previous = list.get(i - 1);
            O current = list.get(i);

            // If previous <= current
            if (comparator.compare(previous, current) <= 0) {
                // Continue looping, all seems fine
            }

            // If previous > current
            else {
                // List is unsorted
                return false;
            }
        }

        // If we looped through the whole list and order is preserved - return true
        return true;
    }

    /**
     * Is the list sorted? Check according to natural ordering
     * @param list list to check
     * @param <O> any generic type
     * @return true if it is sorted (or if the list is empty, or if it has only 1 element), false if it's not
     */
    public static <O extends Comparable<? super O>> boolean isSorted(List<O> list) {
        return isSorted(list, Comparator.naturalOrder());
    }
}
