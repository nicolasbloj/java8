/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nab.methodref;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;

/**
 *
 * @author nab
 */
public class Numbers {

    public static boolean isMoreThanFifty(int n1, int n2) {
        return (n1 + n2) > 50;
    }

    public static List<Integer> findNumbers(
            List<Integer> l, BiPredicate<Integer, Integer> p) {
        List<Integer> newList = new ArrayList<>();
        for (Integer i : l) { 
            if (p.test(i, i + 10)) {
                newList.add(i);
            }
        }
        return newList;
    }
}
