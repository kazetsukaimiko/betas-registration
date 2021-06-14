package com.acme.beta.registration;

import javax.swing.text.html.parser.Entity;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;

public class GeneratedStuff {
    public static final List<String> FIRST_NAMES = Arrays.asList("Alex", "Bob", "Cindy", "Doug", "Edward");
    public static final List<String> LAST_NAMES = Arrays.asList("Argon", "Booker", "Curtlass", "Dumbar", "Eddison");
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    public static <E extends Enum<E>> E randomEnum(E[] values) {
        return values[RANDOM.nextInt(values.length)];
    }

    public static <X> X randomMember(List<X> list) {
       return list.get(RANDOM.nextInt(list.size()));
    }

    public static String randomFirst() {
        return randomMember(FIRST_NAMES);
    }

    public static String randomLast() {
        return randomMember(LAST_NAMES);
    }

}
