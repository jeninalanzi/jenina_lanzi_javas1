package com.company;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {

    public void printSet(int a, int b, int c, int d, int e) {

        Set<Integer> integerSet = new HashSet<>();

        integerSet.add(a);
        integerSet.add(b);
        integerSet.add(c);
        integerSet.add(d);
        integerSet.add(e);

        Iterator i = integerSet.iterator();
            while (i.hasNext()) {
                System.out.println(i.next());
            }
    }
}
