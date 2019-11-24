package com.tekleo.utils.arguments;

import java.util.Arrays;

public final class Arguments {
    public static void checkForNull(Object ... arguments) {
        for (Object argument : arguments)
            if (argument == null)
                throw new ArgumentsAreNullException("One of the arguments is null: arguments=" + Arrays.toString(arguments));
    }
}
