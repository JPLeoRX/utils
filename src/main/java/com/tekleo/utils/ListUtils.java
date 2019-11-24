package com.tekleo.utils;

import java.util.ArrayList;
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

    /**
     * Simple wrapper around default sort method. Sorts original list, and returns it.
     * @param list list to sort
     * @param comparator comparator
     * @param <O> any generic type
     * @return sorted original list
     */
    public static <O> List<O> sort(List<O> list, Comparator<O> comparator) {
        list.sort(comparator);
        return list;
    }

    /**
     * Simple wrapper around default sort method. Clones the original list, and then sorts on cloned version.
     * @param list list to sort
     * @param comparator comparator
     * @param <O> any generic type
     * @return sorted copy of original list
     */
    public static <O> List<O> sortWithCloned(List<O> list, Comparator<O> comparator) {
        ArrayList<O> cloned = new ArrayList<>(list);
        return sort(cloned, comparator);
    }

    /**
     * Simple wrapper around default removeAll method. Excludes elements from original list, and returns it.
     * @param list list to exclude elements from
     * @param toRemove elements to be excluded
     * @param <O> any generic type
     * @return original list, with elements removed from it
     */
    public static <O> List<O> exclude(List<O> list, List<O> toRemove) {
        list.removeAll(toRemove);
        return list;
    }

    /**
     * Simple wrapper around default removeAll method. Clones the original list, and then excludes elements from the cloned version.
     * @param list list to exclude elements from
     * @param toRemove elements to be excluded
     * @param <O> any generic type
     * @return copy of original list, with elements removed from it
     */
    public static <O> List<O> excludeWithCloned(List<O> list, List<O> toRemove) {
        ArrayList<O> cloned = new ArrayList<>(list);
        return exclude(cloned, toRemove);
    }
}
