package com.company;

import java.util.ArrayList;
import java.util.Iterator;

public class ClassmatesList {

    // Property
    private ArrayList<Classmate> classmates = new ArrayList<>();

    // Public methods
    public void add(Classmate person) {
            classmates.add(person);
    }

    public Classmate get(int index) {
        return this.classmates.get(index);
    }

    public ArrayList<Classmate> getAll() {
        return this.classmates;
    }

}
