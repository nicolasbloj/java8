package com.nab.methodref;

import static com.nab.methodref.Numbers.findNumbers;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiPredicate;

/**
 *
 * @author
 * https://www.codementor.io/eh3rrera/using-java-8-method-reference-du10866vx
 */
public class MethodReference {

    public static void main(String args[]) {

        // Static method reference ****************
        List<Integer> list = Arrays.asList(12, 5, 45, 18, 33, 24, 40);

        // Using an anonymous class
        Numbers.findNumbers(list, new BiPredicate<Integer, Integer>() {
            public boolean test(Integer i1, Integer i2) {
                return Numbers.isMoreThanFifty(i1, i2);
            }
        });

        // Using a lambda expression
        findNumbers(list, (i1, i2) -> Numbers.isMoreThanFifty(i1, i2));

        // Using a method reference
        findNumbers(list, Numbers::isMoreThanFifty);

        // ****************
    }
}
