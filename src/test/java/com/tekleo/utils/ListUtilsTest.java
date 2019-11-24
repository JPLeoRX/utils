package com.tekleo.utils;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.junit.Assert.*;

public class ListUtilsTest {
    @Test
    public void isSorted() {
        Comparator<String> comparator = Comparator.naturalOrder();
        Comparator<String> reversed = comparator.reversed();
        List<String> l1 = Arrays.asList();
        List<String> l2 = Arrays.asList("a");
        List<String> l3 = Arrays.asList("a", "b");
        List<String> l4 = Arrays.asList("a", "b", "c");
        List<String> l5 = Arrays.asList("a", "c", "b");
        List<String> l6 = Arrays.asList("c", "b", "a");

        // Check natural order
        assertTrue(ListUtils.isSorted(l1, comparator));
        assertTrue(ListUtils.isSorted(l2, comparator));
        assertTrue(ListUtils.isSorted(l3, comparator));
        assertTrue(ListUtils.isSorted(l4, comparator));
        assertFalse(ListUtils.isSorted(l5, comparator));
        assertFalse(ListUtils.isSorted(l6, comparator));

        // Make sure that method overloading works fine
        assertTrue(ListUtils.isSorted(l1));
        assertTrue(ListUtils.isSorted(l2));
        assertTrue(ListUtils.isSorted(l3));
        assertTrue(ListUtils.isSorted(l4));
        assertFalse(ListUtils.isSorted(l5));
        assertFalse(ListUtils.isSorted(l6));

        // Check reversed order
        assertTrue(ListUtils.isSorted(l1, reversed));
        assertTrue(ListUtils.isSorted(l2, reversed));
        assertFalse(ListUtils.isSorted(l3, reversed));
        assertFalse(ListUtils.isSorted(l4, reversed));
        assertFalse(ListUtils.isSorted(l5, reversed));
        assertTrue(ListUtils.isSorted(l6, reversed));

        // Make sure that null list throws an exception
        boolean caught = false;
        try {
            ListUtils.isSorted(null, comparator);
        } catch (Exception e) {
            caught = true;
        }
        assertTrue(caught);

        // Make sure that null comparator throws an exception
        caught = false;
        try {
            ListUtils.isSorted(l6, null);
        } catch (Exception e) {
            caught = true;
        }
        assertTrue(caught);
    }
}
