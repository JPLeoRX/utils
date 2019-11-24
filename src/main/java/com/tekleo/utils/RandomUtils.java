package com.tekleo.utils;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {
    public static double randomInRange(double minInclusive, double maxExclusive) {
        return ThreadLocalRandom.current().nextDouble(minInclusive, maxExclusive);
    }

    public static int randomInRange(int minInclusive, int maxExclusive) {
        return ThreadLocalRandom.current().nextInt(minInclusive, maxExclusive);
    }

    public static long randomInRange(long minInclusive, long maxExclusive) {
        return ThreadLocalRandom.current().nextLong(minInclusive, maxExclusive);
    }

    public static <O> O randomInList(List<O> list) {
        // Special cases
        if (list == null)
            throw new IllegalArgumentException("List can't be null");
        if (list.isEmpty())
            throw new IllegalArgumentException("List can't be empty");

        // If there's only one element in the list - return it
        if (list.size() == 1)
            return list.get(0);

        // Generate random index and return element at this index
        return list.get(randomInRange(0, list.size()));
    }
}
