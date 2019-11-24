package com.tekleo.utils;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class RandomUtilsTest {
    @Test
    public void randomInRange() {
        int min = 0;
        int max = 9;
        int targetOccurrencesOfSingleNumber = 10000;
        Map<Integer, Integer> occurrences = new HashMap<>();
        int targetCount = targetOccurrencesOfSingleNumber * 10;

        // Init map
        for (int i = min; i <= max; i++)
            occurrences.put(i, 0);

        // Generate random int 100000 times, and count occurrences of each int in range
        for (int i = 0; i < targetCount; i++) {
            int nextInt = RandomUtils.randomInRange(min, max + 1);
            occurrences.compute(nextInt, (key, value) -> value + 1);
        }

        // Make sure that all numbers were included
        assertEquals(10, occurrences.keySet().size());

        // Check that random distribution is more-or-less equal
        for (int i = min; i <= max; i++) {
            // Make sure that 9000 < occurrences of this number
            assertTrue(targetOccurrencesOfSingleNumber * 0.9 < occurrences.get(i));

            // Make sure that 11000 > occurrences of this number
            assertTrue(occurrences.get(i) < targetOccurrencesOfSingleNumber * 1.1);
        }
    }
}
